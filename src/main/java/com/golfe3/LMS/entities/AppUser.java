package com.golfe3.LMS.entities;

import com.golfe3.LMS.enums.Gender;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender sex;
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String avatarImgUrl;
    private String createBy;
    private LocalDate createAt;
    private String updateBy;
    private LocalDate updateAt;
    private LocalDate isDeleteAt;
    private String deleteBy;
    private Boolean isDelete;
    private Boolean isActive;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole>appRoles = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return id != null && Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
