package pl.zs2.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zs2.springapp.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PersonDBService {

    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager entityManager;

    public Person addPersonToDb(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person addPersonToDbEM(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person;
    }

    public List<Person> findEveryPersonWithLastName(String lastName) {
        return Collections.emptyList();
    }

    public Person updatePersonFirstName(Integer id, String firstName) {
        return null;
    }

    public Person updatePerson(Person person) {
        return null;
    }

    public Map<Integer, Person> groupedPersonsByAge() {
        return Collections.emptyMap();
    }

}
