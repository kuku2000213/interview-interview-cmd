package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.Interview;
import kr.gyuna.interview.hexagonal.domain.InterviewDate;
import kr.gyuna.interview.hexagonal.domain.InterviewId;
import kr.gyuna.interview.hexagonal.domain.InterviewStatus;
import kr.gyuna.interview.hexagonal.domain.reference.apply.ApplyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInterviewCommand {

    private ApplyId applyId;
    private Date interviewStartDate;

    public Interview toEntity(){
        Date today = new Date();

        InterviewDate interviewDate = InterviewDate.builder()
                .interviewCreatedDate(today)
                .interviewStartDate(this.interviewStartDate)
                .interviewEndDate(null)
                .build();

        return Interview.builder()
                .interviewId(InterviewId.uuid())
                .applyId(this.applyId)
                .interviewStatus(InterviewStatus.STANDBY)
                .interviewDate(interviewDate)
                .build();
    }
}
