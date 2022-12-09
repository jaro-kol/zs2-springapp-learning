package pl.zs2.springapp.service;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.zs2.springapp.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findById(Integer id);

    Person save(Person entity);

    void deleteAll();
}
