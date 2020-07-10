package com.session.testinfo.dal;


import com.session.testinfo.model.Request;
import com.session.testinfo.model.SessionInfo;
import com.session.testinfo.transformation.ResponseTransformer;
import com.session.testinfo.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class TestInfoDALImpl implements TestInfoDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ResponseTransformer responseTransformer;


    @Override
    public List<SessionInfo> getAllSessionInfo() {
        return mongoTemplate.findAll(SessionInfo.class);
    }


    @Override
    public List<SessionInfo> getSessionInfoByDateAndTime(Request request) {
        List<SessionInfo> sessionInfo = null;
        log.info(Constants.TEST_DATE, request.getTestDate());
        Query query = new Query();
        query.addCriteria(Criteria.where("testDate").is(request.getTestDate()));
         sessionInfo = mongoTemplate.find(query, SessionInfo.class);
         SessionInfo s=new SessionInfo();
        if (null != sessionInfo) {
            log.info(Constants.SUCCESS);
            return responseTransformer.getSessionTestInfo(sessionInfo, request.getStartTime());
        }
        return sessionInfo;
    }


    @Override
    public SessionInfo createSessionInfo(SessionInfo sessionInfo) {
        mongoTemplate.save(sessionInfo);
        return sessionInfo;
    }

}
