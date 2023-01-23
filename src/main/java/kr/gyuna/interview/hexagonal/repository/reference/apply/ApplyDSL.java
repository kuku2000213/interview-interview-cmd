package kr.gyuna.interview.hexagonal.repository.reference.apply;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ApplyDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public ApplyDSL(
            EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
