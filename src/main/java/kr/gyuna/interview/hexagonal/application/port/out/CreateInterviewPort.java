package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.Interview;

public interface CreateInterviewPort {

    Interview createInterview(Interview interview);
}
