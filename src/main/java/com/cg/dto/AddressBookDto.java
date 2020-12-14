package com.cg.dto;


import com.cg.domain.AddressBook;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDto {

    private Long id;
    @NotEmpty(message = "Name should not be empty")
    @NotNull(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Z][a-z]{3,}$",message = "Min 3 characters and first should be uppercase")
    private String name;
    @NotEmpty(message = "Address should not be empty")
    @NotNull(message = "Address should not be empty")
    private String address;
    @NotEmpty(message = "city should not be empty")
    @NotNull(message = "city should not be empty")
    private String city;
    @NotEmpty(message = "state should not be empty")
    @NotNull(message = "state should not be null")
    private String state;
    @NotEmpty(message = "Zip code should not be empty")
    @NotNull(message = "Zip should not be null")
    private String zip;
    @NotNull(message="Phone number should not be null ")
    @NotEmpty(message="Phone number should not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain 10 digits")
    private String phno;

    public AddressBookDto(){

    }

    public AddressBookDto(AddressBook user) {
        this.id = user.getId();
        this.name = user.getName();
        this.address = user.getAddress();
        this.city = user.getCity();
        this.state = user.getState();
        this.zip = user.getZip();
        this.phno = user.getPhno();
    }

    @Override
    public String toString() {
        return "data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phno=" + phno +
                '}';
    }
}
