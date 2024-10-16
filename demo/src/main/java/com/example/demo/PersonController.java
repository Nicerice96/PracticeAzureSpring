    package com.example.demo;

    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    @Controller
    @RequestMapping("/")
    public class PersonController {

        @Autowired

        private PersonRepository personRepository;

        @GetMapping("/")
        public String home() {
            return "template";
        }

        @PostMapping("/add")
        public ResponseEntity<String> addPerson(@RequestBody Person person){

            personRepository.save(person);
            return ResponseEntity.ok("Added Person Successfully");
        
        }



        @GetMapping("/get")
        public ResponseEntity<List<Person>> getAll(Model model){
            List<Person> personList = (List<Person>)personRepository.findAll();
            model.addAttribute("personList", personList);
    
            return ResponseEntity.ok(personList);
        }


        @DeleteMapping("/del")
        public String delPerson(@RequestParam Long id){
            if(personRepository.existsById(id)){
                personRepository.deleteById(id);
                return "Person with ID " + id + " was deleted";
            }
            return "Person not found";

        }
    }
