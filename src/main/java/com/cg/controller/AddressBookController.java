package com.cg.controller;

import com.cg.dto.AddressBookDto;
import com.cg.dto.ResponseDto;
import com.cg.exceptions.AddressBookException;
import com.cg.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid AddressBookDto user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto((bindingResult.getAllErrors().get(0).getDefaultMessage()),"404"),HttpStatus.BAD_REQUEST);
        }
        try{
            AddressBookDto addressBookDto = addressBookService.CreateUser(user);
            ResponseDto responseDto = new ResponseDto("User created succesfully",addressBookDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (AddressBookException e){
            ResponseDto responseDto = new ResponseDto("User not created succesfully","404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody @Valid AddressBookDto user,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto((bindingResult.getAllErrors().get(0).getDefaultMessage()),"404"),HttpStatus.BAD_REQUEST);
        }
        try{
            AddressBookDto addressBookDto = addressBookService.UpdateUser(user);
            ResponseDto responseDto = new ResponseDto("User details updated succesfully",addressBookDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (AddressBookException e){
            ResponseDto responseDto = new ResponseDto("Updated Call Unsuccesfull","404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id") @Valid Long id,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto((bindingResult.getAllErrors().get(0).getDefaultMessage()),"404"),HttpStatus.BAD_REQUEST);
        }
        try{
            AddressBookDto addressBookDto = addressBookService.deleteUser(id);
            ResponseDto responseDto = new ResponseDto("User deleted succesfully",addressBookDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
        } catch (AddressBookException e){
            ResponseDto responseDto = new ResponseDto("Delete Call Unsuccesfull","404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllUser(){
        try{
            List<AddressBookDto> addressBookDto = addressBookService.getAllUser();
            ResponseDto responseDto = new ResponseDto("Get Call Succesfull",addressBookDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (Exception e){
            ResponseDto responseDto = new ResponseDto("Get Call Unsuccesfull","404");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }
}
