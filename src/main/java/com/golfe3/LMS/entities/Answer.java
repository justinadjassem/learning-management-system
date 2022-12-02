package com.golfe3.LMS.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createBy;
    private LocalDate createAt;
    private String updateBy;
    private LocalDate updateAt;
    private Boolean isDelete;
    private LocalDate isDeleteAt;
    private String deleteBy;
    @ElementCollection
    @Column(nullable = false)
    private List<String> answerOption;
    @ElementCollection
    private List<String> wrongAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Answer answer = (Answer) o;
        return id != null && Objects.equals(id, answer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
