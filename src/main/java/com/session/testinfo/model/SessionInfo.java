package com.session.testinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionInfo {

    @Id
    private String SessionId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private Test test;

}
