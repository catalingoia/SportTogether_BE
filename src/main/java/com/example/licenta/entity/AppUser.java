package com.example.licenta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "events"}) // This,
@ToString(exclude = { "events"}) // and this
public class AppUser {
    @Id
    @GeneratedValue(generator = "SEQ_APPUSER")
    @GenericGenerator(
            name = "SEQ_APPUSER",
            strategy = "uuid2"
    )
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private Collection<Event> events = new ArrayList<>();
    @ManyToMany(mappedBy = "participants")
    @JsonManagedReference
    private Collection<Event>  attendingEvents = new ArrayList<>();
}
