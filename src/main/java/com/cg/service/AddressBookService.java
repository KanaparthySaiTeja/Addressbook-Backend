package com.cg.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.cg.domain.AddressBook;
import com.cg.dto.AddressBookDto;
import com.cg.exceptions.AddressBookException;
import com.cg.repository.AddressBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookDto CreateUser(AddressBookDto addressBookDto) throws AddressBookException {
        if(Objects.nonNull(addressBookDto.getName()) && Objects.nonNull(addressBookDto.getAddress()) && Objects.nonNull(addressBookDto.getCity())
                && Objects.nonNull(addressBookDto.getState()) && Objects.nonNull(addressBookDto.getZip()) && Objects.nonNull(addressBookDto.getPhno())) {
            AddressBook addressBook = new AddressBook(addressBookDto.getName(), addressBookDto.getAddress(),addressBookDto.getCity(),addressBookDto.getState(),addressBookDto.getZip(),addressBookDto.getPhno());
            return new AddressBookDto(addressBookRepository.save(addressBook));
        }
        throw new AddressBookException(AddressBookException.ExceptionTypes.USER_NOT_FOUND);
    }

    public AddressBookDto UpdateUser(AddressBookDto addressBookDto) throws AddressBookException {

        return addressBookRepository.findById(addressBookDto.getId()).map(addressBook -> {
            if(Objects.nonNull(addressBookDto.getName())){
                addressBook.setName(addressBookDto.getName());
            }
            if(Objects.nonNull(addressBookDto.getAddress())){
                addressBook.setAddress(addressBookDto.getAddress());
            }
            if(Objects.nonNull(addressBookDto.getCity())){
                addressBook.setCity(addressBookDto.getCity());
            }
            if(Objects.nonNull(addressBookDto.getState())){
                addressBook.setState(addressBookDto.getState());
            }
            if(Objects.nonNull(addressBookDto.getZip())){
                addressBook.setZip(addressBookDto.getZip());
            }
            if(Objects.nonNull(addressBookDto.getPhno())){
                addressBook.setPhno(addressBookDto.getPhno());
            }
           return new AddressBookDto(addressBookRepository.save(addressBook));
        }).orElseThrow(()-> new AddressBookException(AddressBookException.ExceptionTypes.ID_NOT_FOUND));
    }

    public AddressBookDto deleteUser(Long id) throws AddressBookException {
        return addressBookRepository.findById(id).map(addressBook -> {
            addressBookRepository.deleteById(addressBook.getId());
            return new AddressBookDto(addressBook);
        }).orElseThrow(()-> new AddressBookException(AddressBookException.ExceptionTypes.ID_NOT_FOUND));
    }


    public List<AddressBookDto> getAllUser(){
        return addressBookRepository.findAll()
                .stream()
                .map(addressBook -> new AddressBookDto(addressBook))
                .collect(Collectors.toList());
    }
}
