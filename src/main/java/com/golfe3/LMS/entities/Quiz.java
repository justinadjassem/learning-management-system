package com.golfe3.LMS.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Duration;
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
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private Boolean isActive;
    @Column(nullable = false)
    private Duration duration;
    @Column(nullable = false)
    private Integer attemptsNumber;
    private LocalDate createAt;
    private LocalDate updateAt;
    private Boolean isDelete;
    private LocalDate isDeleteAt;
    @OneToOne
    private Chapter chapter;
    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Section>sections;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quiz quiz = (Quiz) o;
        return id != null && Objects.equals(id, quiz.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
