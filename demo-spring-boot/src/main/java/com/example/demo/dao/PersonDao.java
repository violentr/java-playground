package com.example.demo.dao;
import com.example.demo.model.Person;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        insertPerson(id, person);
        return 1;
    }
    
    List<Person> selectAllPeople();

    Optional<Person>selectPersonById(UUID id);
    
    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person); 
}
