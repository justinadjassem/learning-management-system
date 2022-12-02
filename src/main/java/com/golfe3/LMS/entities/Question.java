package com.golfe3.LMS.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String topic;
    private Integer points;
    private String createBy;
    private LocalDate createAt;
    private String updateBy;
    private LocalDate updateAt;
    private Boolean isDelete;
    private LocalDate isDeleteAt;
    private String deleteBy;
    @OneToOne(mappedBy = "question")
    private UserResult userResult;
    @ManyToOne
    private Section section;
    @ManyToOne
    private QuestionType questionType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
