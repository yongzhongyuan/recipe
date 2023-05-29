package com.abn.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="Recipe")
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", columnDefinition = "varchar(225) default null")
    private String name;

    @Column(name="instruction", columnDefinition ="LONGBLOB default null")
    private String instruction;

    @Column(name="serving", columnDefinition ="int(10)")
    private int serving;

    @Column(name="vegetarian", columnDefinition ="tinyint(1) default 0")
    private boolean vegetarian;

    @Column(name="ingredient", columnDefinition ="LONGBLOB default null")
    private String ingredient;
}
