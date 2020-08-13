package com.personal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "intProductID", nullable = false)
    private int id;

    @Column(name = "varDescription", nullable = false)
    private String description;

    @Column(name = "intValue", nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "productWiringInstructions",
        joinColumns = {@JoinColumn(name = "intProductID")},
        inverseJoinColumns = {@JoinColumn(name = "intWiringInstructionsID")})
    private WiringInstruction wiringInstruction;

}
