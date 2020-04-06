package me.sup2is.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MemberRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    public Member getMember() {
        ResponseEntity<Member> restExchange =
                restTemplate.exchange(
                        "http://memberservice/member",
                        HttpMethod.GET,
                        null, Member.class);

        return restExchange.getBody();
    }

}
