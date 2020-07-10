package com.session.testinfo.dal;

import com.session.testinfo.model.Request;
import com.session.testinfo.model.SessionInfo;

import java.util.List;

public interface TestInfoDAL {

    List<SessionInfo> getSessionInfoByDateAndTime(Request request);

    SessionInfo createSessionInfo(SessionInfo sessionInfo);

    List<SessionInfo> getAllSessionInfo();

}