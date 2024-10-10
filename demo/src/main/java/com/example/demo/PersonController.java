package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAll(Model model){
        Iterable<Person> personList = personRepository.findAll();
        for (Person person : personList) {
            model.addAttribute("firstName", person.getFirstName());
            model.addAttribute("lastName", person.getLastName());
            model.addAttribute("weight", person.getWeight());
            model.addAttribute("height", person.getHeight());
        }
        return "template";
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
