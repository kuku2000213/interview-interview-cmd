package kr.gyuna.interview.hexagonal.application.port.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.CreateInterviewCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateInterviewUseCase;
import kr.gyuna.interview.hexagonal.application.port.in.reference.apply.CreateApplyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.CreateInterviewPort;
import kr.gyuna.interview.hexagonal.domain.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateApplyService implements CreateInterviewUseCase {

    private final CreateInterviewPort createInterviewPort;

    @Override
    public DefaultResponse createInterview(CreateInterviewCommand command) {

        Interview interview = createInterviewPort.createInterview(command.toEntity());


        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "면접이 정상적으로 등록되었습니다.",
                interview.toInterviewId().toString()
        );
    }
}
