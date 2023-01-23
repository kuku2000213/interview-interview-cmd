package kr.gyuna.interview.hexagonal.repository;

import kr.gyuna.interview.hexagonal.domain.Interview;
import kr.gyuna.interview.hexagonal.domain.InterviewId;
import org.springframework.data.repository.CrudRepository;

public interface InterviewRepository extends CrudRepository<Interview, InterviewId> {
}
