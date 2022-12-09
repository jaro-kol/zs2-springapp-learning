package pl.zs2.springapp


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity

import static org.springframework.http.HttpHeaders.ACCEPT
import static org.springframework.http.HttpHeaders.CONTENT_TYPE
import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.HttpMethod.POST



trait Rest {

    @Autowired
    TestRestTemplate restTemplate;

    def <T> ResponseEntity<T> get(String url, Class<T> responseType, String acceptMediaType) {
        restTemplate.exchange(url, GET, new HttpEntity(new HttpHeaders([(ACCEPT): acceptMediaType])), responseType)
    }

    def <T> ResponseEntity<T> post(String url, String request, Class<T> responseType,String contentType, String acceptMediaType) {
        restTemplate.exchange(url, POST, new HttpEntity(request, new HttpHeaders([(ACCEPT): acceptMediaType, (CONTENT_TYPE): contentType])), responseType)
    }
}