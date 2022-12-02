package com.golfe3.LMS.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "section")
    @ToString.Exclude
    private List<Question> question;
    @ManyToOne
    private Quiz quiz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Section section = (Section) o;
        return id != null && Objects.equals(id, section.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
