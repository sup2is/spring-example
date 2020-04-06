package me.sup2is.memberservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("memberservice")
public interface MemberServiceFeignClient {

    @RequestMapping(value = "/member",
            method = RequestMethod.GET,
            consumes = "application/json")
    Member getMember();

}
