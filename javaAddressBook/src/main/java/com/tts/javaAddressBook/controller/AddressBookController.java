package com.tts.javaAddressBook.controller;

import com.tts.javaAddressBook.model.AddressBook;
import com.tts.javaAddressBook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import org.springframework.web.bind.annotation.*;
//I'm using the * to get all the mappings because I kept getting errors, but I need to investigate further

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

//If I comment this out, the application runs. If I comment it back in, I have 6 errors(investigate further).

    @GetMapping("/")
    public String index(AddressBook addressBook, Model model) {
        model.addAttribute("queries", addressBookRepository.findAll());
        return "query/index";
    }

    @PostMapping("/query")
    public String addNewAddressBook(AddressBook addressBook, Model model) {
        addressBookRepository.save(addressBook);

        model.addAttribute("firstName", addressBook.getFirstName());
        model.addAttribute("lastName", addressBook.getLastName());
        model.addAttribute("address", addressBook.getAddress());
        model.addAttribute("phoneNumber", addressBook.getPhoneNumber());
        model.addAttribute("emailAddress", addressBook.getEmailAddress());
        return "query/result";
    }

    @GetMapping("/queries/new")
    public String newAddressBook(AddressBook addressBook) {
        return "query/new";
    }

//    TODO(): Edit query method

    @DeleteMapping("/queries/delete/{id}")
    public String deleteQueryById(@PathVariable Long id, AddressBook addressBook) {
        addressBookRepository.deleteById(id);
        return "query/delete";
    }


}