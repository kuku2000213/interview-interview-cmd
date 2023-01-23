package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class InterviewDate {

    private Date interviewCreatedDate;
    private Date interviewStartDate;
    private Date interviewEndDate;
}
