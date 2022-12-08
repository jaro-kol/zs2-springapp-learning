package pl.zs2.springapp

import com.github.tomakehurst.wiremock.junit.WireMockClassRule
import org.junit.ClassRule
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(classes = [SpringApp],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest extends Specification {

    @Value('${local.server.port}')
    protected int port;

    @Shared
    @ClassRule
    WireMockClassRule wireMock = new WireMockClassRule(8081)

    def setup() {
        wireMock.resetAll()
    }

    protected String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }
}
