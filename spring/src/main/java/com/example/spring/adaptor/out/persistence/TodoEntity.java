package com.example.spring.adaptor.out.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean complete;


}
