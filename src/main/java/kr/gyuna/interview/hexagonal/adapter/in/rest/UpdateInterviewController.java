package kr.gyuna.interview.hexagonal.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.req.UpdateInterviewStatusReq;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateInterviewStatusCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateInterviewUseCase;
import kr.gyuna.interview.hexagonal.domain.InterviewId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateInterviewController {

    private final UpdateInterviewUseCase updateInterviewUseCase;

    @PutMapping("/v1/interviews/{interviewId}/status")
    public ResponseEntity<DefaultResponse> updateInterviewStatus(
            @PathVariable(name = "interviewId") String interviewId,
            @RequestBody UpdateInterviewStatusReq req
    ) {
        UpdateInterviewStatusCommand command = UpdateInterviewStatusCommand.builder()
                .interviewId(InterviewId.of(interviewId))
                .interviewStatus(req.getStatus())
                .build();

        DefaultResponse response = updateInterviewUseCase
                .updateInterviewStatus(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
