package com.personal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @Column(name = "intObjectID")
    private int id;

    @Column(name = "vchCommonName")
    private String commonName;

}
