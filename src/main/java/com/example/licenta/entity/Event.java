package com.example.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private String name;
    private String location;
    private Float price;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;
    @ManyToOne
    @JoinColumn(name="app_user_id", nullable = false)
    private AppUser user;

}
