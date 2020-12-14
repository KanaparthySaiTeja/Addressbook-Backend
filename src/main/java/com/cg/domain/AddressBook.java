package com.cg.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "address")
public class AddressBook implements Serializable {

    private static final long serialVersionUID = -8900492704842756948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phno;

    public AddressBook(){

    }

    public AddressBook( String name, String address, String city, String state, String zip, String phno) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phno = phno;
    }
}
