package com.brindha.oms.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @Column(name="created_at")
//    private DateTime createdAt ;
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @Column(name="updated_at")
   // private DateTime updatedAt;

  }
