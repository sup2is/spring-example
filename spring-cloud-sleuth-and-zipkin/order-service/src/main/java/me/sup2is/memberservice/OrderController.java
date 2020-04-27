package me.sup2is.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private MemberServiceFeignClient memberServiceFeignClient;

    @GetMapping("/order/{memberId}")
    public String order(@PathVariable("memberId") Long memberId) {
        return memberServiceFeignClient.getMember(memberId).getName() + "님이 주문요청하셨습니다.";
    }

}
