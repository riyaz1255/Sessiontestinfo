package com.session.testinfo.controller;

//import com.online.coursedetails.transformation.ResponseTransformer;

import com.session.testinfo.api.TestInfoApi;
import com.session.testinfo.dal.TestInfoDAL;
import com.session.testinfo.model.Request;
import com.session.testinfo.model.SessionInfo;
import com.session.testinfo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestInfoController implements TestInfoApi {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TestInfoDAL testInfoDAL;

    @Override
    public List<SessionInfo> getSessionInfoByDateAndTime(@RequestBody Request request) {
        return testInfoDAL.getSessionInfoByDateAndTime(request);
    }

    public List<SessionInfo> getAllSessionInfo() {
        return testInfoDAL.getAllSessionInfo();
    }

    public SessionInfo createSession(@RequestBody SessionInfo course) {
        return testInfoDAL.createSessionInfo(course);
    }

}