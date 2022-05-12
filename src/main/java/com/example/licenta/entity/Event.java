package com.example.licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String location;
    private Float price;
    private Integer maxPlayers;
    private Boolean accepted = false;
    @ManyToMany
    @JoinTable(
            name = "participant",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id")
    )
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

}
