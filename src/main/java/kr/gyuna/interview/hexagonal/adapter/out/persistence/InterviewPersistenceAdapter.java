package kr.gyuna.interview.hexagonal.adapter.out.persistence;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.CreateInterviewPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindInterviewPort;
import kr.gyuna.interview.hexagonal.domain.Interview;
import kr.gyuna.interview.hexagonal.domain.InterviewId;
import kr.gyuna.interview.hexagonal.repository.InterviewDSL;
import kr.gyuna.interview.hexagonal.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@RequiredArgsConstructor
public class InterviewPersistenceAdapter implements
        CreateInterviewPort,
        FindInterviewPort
{

    private final InterviewRepository interviewRepository;
    private final InterviewDSL interviewDSL;

    @Override
    public Interview createInterview(Interview interview) {

        return interviewRepository
                .save(interview);
    }

    @Override
    public Interview findInterviewById(InterviewId interviewId) {

        Optional<Interview> interviewOpt =
                interviewRepository.findById(interviewId);

        return interviewOpt.orElseThrow(() ->
                new NullPointerException("해당 면접이 존재하지 않습니다.")
        );
    }
}
