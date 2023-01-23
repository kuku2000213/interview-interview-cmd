package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface UpdateInterviewUseCase {
    DefaultResponse updateInterviewStatus(UpdateInterviewStatusCommand command);
}
