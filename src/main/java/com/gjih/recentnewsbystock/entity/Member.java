package com.gjih.recentnewsbystock.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<SavedStock> stockCodes = new ArrayList<>();
}
