package kr.gyuna.interview.hexagonal.application.port.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateInterviewStatusCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateInterviewUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.FindInterviewPort;
import kr.gyuna.interview.hexagonal.domain.Interview;
import kr.gyuna.interview.hexagonal.domain.InterviewId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UpdateInterviewService implements UpdateInterviewUseCase {

    private final FindInterviewPort findInterviewPort;

    @Override
    public DefaultResponse updateInterviewStatus(UpdateInterviewStatusCommand command) {

        InterviewId interviewId = command.toInterviewId();

        Interview interview = findInterviewPort.findInterviewById(interviewId);

        interview.changeInterviewStatus(command.toInterviewStatus());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "면접 상태가 정상적으로 변경되었습니다.",
                interviewId.toString()
        );
    }
}
