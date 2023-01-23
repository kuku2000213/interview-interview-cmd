package kr.gyuna.interview.hexagonal.repository.reference.apply;

import kr.gyuna.interview.hexagonal.domain.reference.apply.Apply;
import kr.gyuna.interview.hexagonal.domain.reference.apply.ApplyId;
import org.springframework.data.repository.CrudRepository;

public interface ApplyRepository extends CrudRepository<Apply, ApplyId> {
}
