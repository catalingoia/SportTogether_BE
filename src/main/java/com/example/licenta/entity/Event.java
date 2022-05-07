package com.example.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(generator = "SEQ_EVENT")
    @GenericGenerator(
            name = "SEQ_EVENT",
            strategy = "uuid2"
    )
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="app_user_id", nullable = false)
    private AppUser user;

}
