package pl.zs2.springapp

import org.springframework.http.MediaType

class AppControllerTest extends IntegrationTest implements Rest {

    def "should call app endpoint"() {
        when:
        def result = get(localUrl("/app"), String.class, MediaType.APPLICATION_JSON_VALUE)

        then:
        result.statusCodeValue == 200
        result.body == "Spring app working!"
    }
}
