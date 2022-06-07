package com.example.licenta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(generator = "SEQ_ROLES")
    @GenericGenerator(
            name = "SEQ_ROLES",
            strategy = "uuid2"
    )
    private String id;
    private String name;
}
