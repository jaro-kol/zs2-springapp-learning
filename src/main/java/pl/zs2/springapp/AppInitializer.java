package pl.zs2.springapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.zs2.springapp.model.Person;
import pl.zs2.springapp.service.PersonDBService;
import pl.zs2.springapp.service.PersonRepository;

import java.util.List;

@Component
public class AppInitializer implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(AppInitializer.class.getName());

    @Autowired
    PersonDBService personDBService;

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Adding to db");
        personDBService.addPersonToDb(new Person(1, "1", "1", 1));
        List<Person> person = personRepository.findAll();
        logger.info("PERSONS SIZE {}", person.size());

    }
}
