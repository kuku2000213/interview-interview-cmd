package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Embeddable
public class InterviewId implements Serializable {

    private String interviewUuid;

    public InterviewId(String interviewUuid) {
        if (interviewUuid == null) {
            throw new IllegalArgumentException("interviewUuid is null");
        }

        this.interviewUuid = interviewUuid;
    }


    @Override
    public int hashCode() {
        return Objects.hash(interviewUuid);
    }

    public static InterviewId of(String interviewUuid) {
        return new InterviewId(interviewUuid);
    }

    public static InterviewId uuid(){
        return new InterviewId(UUID.randomUUID().toString());
    }

    public String toString(){
        return this.interviewUuid;
    }
}
