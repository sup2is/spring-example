package me.sup2is.memberservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(Sink.class)
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void memberChanged(MemberChangeModel model) {
        System.out.println("### OrderService에서 소비");
        System.out.println(model.getMessage() + "memberId : " + model.getId());
        System.out.println("memberId : " + model.getId() + "의 캐시정보를 삭제");
    }
}
