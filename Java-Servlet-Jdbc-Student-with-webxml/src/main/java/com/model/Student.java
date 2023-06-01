package com.model;

import lombok.Data;

@Data
public class Student {
    private int S_ID;
    private int S_AGE;
    private String S_FNAME;
    private String S_LNAME;
    private String S_GENDER;
    private String S_BRANCH;

    public Student() {}

    public Student(String s_FNAME, String s_LNAME, int s_AGE, String s_GENDER, String s_BRANCH) {
        S_AGE = s_AGE;
        S_FNAME = s_FNAME;
        S_LNAME = s_LNAME;
        S_GENDER = s_GENDER;
        S_BRANCH = s_BRANCH;
    }
}
