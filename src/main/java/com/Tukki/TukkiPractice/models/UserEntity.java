package com.Tukki.TukkiPractice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data // <-- Get y los sets
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_board")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @NotNull
    private String last_name;

    private int age;


}
