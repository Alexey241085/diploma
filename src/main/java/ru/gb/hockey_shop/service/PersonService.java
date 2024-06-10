package ru.gb.hockey_shop.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hockey_shop.model.Person;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    // создать пользователя ( администратор)
    public void createPerson(Person person){
//        person.setName(person.getName());
//        person.setMail(person.getMail());
//        person.setPass(person.getPass());
        personRepository.save(person);
    }

    // Удалить пользователя (администратор)
    public void delletePerson(Long id){
        personRepository.deleteById(id);
    }


    // изменить пользователя (администратор)
    public Person updatePerson(Long id, Person updatePerson){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(updatePerson.getName());
            person.setMail(person.getMail());
            person.setPass(person.getPass());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person not found with id: " + id);
        }
    }




}
