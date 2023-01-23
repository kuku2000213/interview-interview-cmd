package kr.gyuna.interview.hexagonal.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.req.CreateInterviewReq;
import kr.gyuna.interview.hexagonal.application.port.in.CreateInterviewCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateInterviewUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.apply.ApplyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateInterviewController {

    private final CreateInterviewUseCase createInterviewUseCase;

    @PostMapping("/v1/interviews")
    public ResponseEntity<DefaultResponse> createInterview(
            @RequestBody CreateInterviewReq createInterviewReq
    ) {
        CreateInterviewCommand command = CreateInterviewCommand.builder()
                .interviewStartDate(createInterviewReq.getStartDate())
                .applyId(ApplyId.of(createInterviewReq.getApplyId()))
                .build();

        DefaultResponse response = createInterviewUseCase
                .createInterview(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
