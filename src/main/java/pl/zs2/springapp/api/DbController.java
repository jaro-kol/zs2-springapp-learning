package pl.zs2.springapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zs2.springapp.model.Person;
import pl.zs2.springapp.service.PersonDBService;

@RestController
@RequestMapping(value = "/db")
public class DbController {

    @Autowired
    PersonDBService personDBService;

    @PostMapping(value = "/add")
    public Person addPersonToDb(@RequestBody Person person) {
        return personDBService.addPersonToDb(person);
    }

    @PostMapping(value = "/add/em")
    public Person addPersonToDbEM(@RequestBody Person person) { return personDBService.addPersonToDbEM(person); }
}
