package com.session.testinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
}
