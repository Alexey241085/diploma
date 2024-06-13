package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.hockey_shop.model.Person;
import ru.gb.hockey_shop.service.PersonService;

import java.util.List;

@Controller
@AllArgsConstructor

public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * пока не используется
     * цель: сделать регистрацию пользователей
     */
//    @GetMapping("/admin")
//    public String startPerson(Model model){
//        List<Person> personList = personService.getPerson();
//        model.addAttribute("persons", personList);
//        return "admin";
//    }

//    @PostMapping("/")
//    public vo
//    @GetMapping
//    public List<Person> showAllPersons(){
//        return  personService.getPerson();
//    }


}
