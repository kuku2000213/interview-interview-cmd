package kr.gyuna.interview.hexagonal.adapter.in.rest.req;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateInterviewReq {

    private Date startDate;
    private String applyId;
}
