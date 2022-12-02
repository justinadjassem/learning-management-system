package com.golfe3.LMS.entities;

import com.golfe3.LMS.enums.FormatType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Boolean availability;
    private Date createAt;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private FormatType format;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Chapter> chapters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
