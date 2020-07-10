package com.session.testinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {

    private String className;
    private Long studentCount;
    private List<Student> student;

}
