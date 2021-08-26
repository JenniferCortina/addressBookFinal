package com.tts.javaAddressBook.repository;

import com.tts.javaAddressBook.model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Long>  {
}
