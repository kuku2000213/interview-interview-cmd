package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.Interview;
import kr.gyuna.interview.hexagonal.domain.InterviewId;

public interface FindInterviewPort {
    Interview findInterviewById(InterviewId interviewId);
}
