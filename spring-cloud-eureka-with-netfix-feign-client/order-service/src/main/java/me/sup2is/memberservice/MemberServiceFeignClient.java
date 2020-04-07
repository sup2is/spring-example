package me.sup2is.memberservice;

        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("memberservice")
public interface MemberServiceFeignClient {

    @GetMapping(value = "/member",
            consumes = "application/json")
    Member getMember();

}
