package pl.zs2.springapp

import org.springframework.beans.factory.annotation.Autowired
import pl.zs2.springapp.model.Person
import pl.zs2.springapp.service.PersonRepository

import static groovy.json.JsonOutput.toJson
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


class DbControllerTest extends IntegrationTest implements Rest {

    @Autowired
    PersonRepository personRepository

    def setup() {
        personRepository.deleteAll();
    }

    def "should add person to db using spring repo"() {
        given:
        def requestBody = [
                'firstName': "Jaro",
                'lastName': "Kol",
                'age': 13
        ]

        when:
        def result = post(localUrl("/db/add"), toJson(requestBody), Person.class, APPLICATION_JSON_VALUE, APPLICATION_JSON_VALUE)

        then:
        result.body.age == 13
        result.body.firstName == "Jaro"
        result.body.lastName == "Kol"
        result.body.id != null
    }

    def "should add person to db using entity manager"() {
        given:
        def requestBody = [
                'firstName': "Jaro",
                'lastName': "Kol",
                'age': 13
        ]

        when:
        def result = post(localUrl("/db/add/em"), toJson(requestBody), Person.class, APPLICATION_JSON_VALUE, APPLICATION_JSON_VALUE)

        then:
        result.body.age == 13
        result.body.firstName == "Jaro"
        result.body.lastName == "Kol"
        result.body.id != null
    }
}
