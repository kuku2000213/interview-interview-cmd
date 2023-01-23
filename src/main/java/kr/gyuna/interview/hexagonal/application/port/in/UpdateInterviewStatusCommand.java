package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.InterviewId;
import kr.gyuna.interview.hexagonal.domain.InterviewStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInterviewStatusCommand {

    private InterviewId interviewId;
    private InterviewStatus interviewStatus;

    public InterviewId toInterviewId(){
        return this.interviewId;
    }

    public InterviewStatus toInterviewStatus(){
        return this.interviewStatus;
    }
}
