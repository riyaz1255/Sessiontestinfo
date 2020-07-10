package com.session.testinfo.repository;

import com.session.testinfo.model.SessionInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<SessionInfo, String> {
}
