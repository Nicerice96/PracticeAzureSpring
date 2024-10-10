package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Person")
public class PersonController {


    private PersonRepository personRepository;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){

        personRepository.save(person);

        return "added Person";
    }

    @GetMapping("/getAll")
    public Iterable<Person> getAll(@RequestParam Long id){
        return personRepository.findAll();
    }


    @DeleteMapping("/del")
    public String delPerson(@RequestParam Long id){
        Iterable<Person> iteratePerson = personRepository.findAll();
        
        for (Person person : iteratePerson){
            if (person.getLongId() == id){
                personRepository.deleteById(id);
                return "Person: " + id + "was deleted";
            }
        }
        return "Person not found";

    }
}
