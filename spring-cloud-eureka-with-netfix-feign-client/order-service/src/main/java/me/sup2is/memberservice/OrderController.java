package me.sup2is.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

//    @Autowired
//    private MemberServiceFeignClient memberServiceFeignClient;

    @Autowired
    MemberRestTemplateClient memberRestTemplateClient;

    @GetMapping("/order")
    public String order() {
//        return memberServiceFeignClient.getMember().getName() + "님이 주문요청하셨습니다.";
        return memberRestTemplateClient.getMember().getName() + "님이 주문요청하셨습니다.";
    }

}
