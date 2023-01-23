package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.*;
import kr.gyuna.interview.hexagonal.domain.reference.apply.ApplyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interview {

    @EmbeddedId
    private InterviewId interviewId;

    @Embedded
    private ApplyId applyId;

    @Embedded
    private InterviewDate interviewDate;

    @Enumerated(value = EnumType.STRING)
    private InterviewStatus interviewStatus;

    public InterviewId toInterviewId(){

        if(interviewId == null){
            throw new NullPointerException("interviewId가 존재하지 않습니다.");
        }

        return this.interviewId;
    }

    public void changeInterviewStatus(InterviewStatus interviewStatus){
        this.interviewStatus = interviewStatus;
    }
}
