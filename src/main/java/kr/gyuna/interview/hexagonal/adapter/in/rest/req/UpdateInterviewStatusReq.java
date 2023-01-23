package kr.gyuna.interview.hexagonal.adapter.in.rest.req;

import kr.gyuna.interview.hexagonal.domain.InterviewStatus;
import lombok.Getter;

@Getter
public class UpdateInterviewStatusReq {

    private InterviewStatus status;
}
