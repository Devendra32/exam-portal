package com.exam.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    //user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;

}
