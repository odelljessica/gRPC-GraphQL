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
@Table(name = "wiringInstructions")
public class WiringInstruction {

    @Id
    @Column(name = "intWiringInstructionsID")
    private int id;

    @Column(name = "vchWiringName")
    private String name;

    @Column(name = "vchBankName")
    private String bankName;

    @Column(name = "chrABANumber")
    private char abaNumber;

    @Column(name = "vchSwift")
    private String swift;

    @Column(name = "vchForAccountOf")
    private String forAccountOf;

    @Column(name = "vchAccountNumber")
    private String accountNumber;

    @Column(name = "vchInFavourOf")
    private String inFavourOf;

    @Column(name = "vchInFavourOfAccountNumber")
    private String inFavourOfAccountNumber;

    @Column(name = "intObjectID")
    private int bankId;

}
