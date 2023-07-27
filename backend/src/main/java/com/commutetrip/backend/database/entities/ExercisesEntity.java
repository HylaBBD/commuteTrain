package com.commutetrip.backend.database.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class ExercisesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exercisesId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;
}
