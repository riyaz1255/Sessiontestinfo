package com.session.testinfo.transformation;

import com.session.testinfo.model.ClassRoom;
import com.session.testinfo.model.SessionInfo;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseTransformer {

    public List<SessionInfo> getSessionTestInfo(List<SessionInfo> response, LocalTime startTime) {

        List<SessionInfo> sessionInfo = response.stream().filter(time -> (time.getStartTime().compareTo(startTime) >= 0))
                .collect(Collectors.toList());

        for (SessionInfo sessionTestInfo : sessionInfo) {
            List<ClassRoom> classRooms = sessionTestInfo.getTest().getClassRooms();
            sessionTestInfo.getTest().setClassRooms(classRooms.stream().map(a -> {

                a.setStudentCount(a.getStudent().stream().count());
                return a;
            }).collect(Collectors.toList()));

        }
        return sessionInfo;
    }
}

