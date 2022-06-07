package com.example.licenta.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "user", "participants"}) // This,
@ToString(exclude = { "user", "participants"}) // and this
public class Event {
    @Id
    @GeneratedValue(generator = "SEQ_EVENT")
    @GenericGenerator(
            name = "SEQ_EVENT",
            strategy = "uuid2"
    )
    private String id;
    private String sport;
    private String level;
    private String contactEmail;
    private String contactPhone;
    private Integer maxPlayers;
    private Integer price;
    private String description;
    private String date;
    private String time;
    private String location;
    private Boolean accepted = false;
    private Boolean rejected = false;
    @ManyToMany
    @JoinTable(
            name = "participant",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id")
    )
    @JsonBackReference
    private Collection<AppUser> participants = new ArrayList<>();
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;
    @ManyToOne
    @JoinColumn(name="app_user_id", nullable = false)
    @JsonIgnore
    private AppUser user;
    private String email;
    private String firstName;
    private String lastName;


}
