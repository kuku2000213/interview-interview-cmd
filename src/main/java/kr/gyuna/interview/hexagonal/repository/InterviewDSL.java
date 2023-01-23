package kr.gyuna.interview.hexagonal.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class InterviewDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public InterviewDSL(
            EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
