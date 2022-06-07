package com.example.licenta.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
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
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private Collection<Event> events = new ArrayList<>();
    @ManyToMany(mappedBy = "participants")
    @JsonManagedReference
    private Collection<Event>  attendingEvents = new ArrayList<>();
}
