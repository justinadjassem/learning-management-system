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
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDate createAt;
    private LocalDate updateAt;
    private Boolean isDelete;
    private LocalDate isDeleteAt;
    @OneToMany (mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
