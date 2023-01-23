package kr.gyuna.interview.hexagonal.domain.reference.apply;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apply {

    @EmbeddedId
    private ApplyId applyId;

    @Enumerated(value = EnumType.STRING)
    private ApplyProgress applyProgress;
}
