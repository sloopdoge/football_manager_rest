package com.example.footballmanager.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "players")
public class Players {

    private static final String SEQ_NAME = "players_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "players_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "experience")
    private Integer experience;
}
