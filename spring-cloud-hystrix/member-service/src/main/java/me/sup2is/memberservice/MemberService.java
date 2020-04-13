package me.sup2is.memberservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @HystrixCommand(
            fallbackMethod = "commonMemberInfo",
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(
                            name="circuitBreaker.requestVolumeThreshold", value="10"),
                    @HystrixProperty(
                            name="circuitBreaker.errorThresholdPercentage", value="50"),
                    @HystrixProperty(
                            name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
                    @HystrixProperty(
                            name="metrics.rollingStats.timeInMilliseconds", value="15000")
            }
    )
    public Member getMemberById(long id) {
        randomlySleep();
        return new Member(id, "sup2is", "qwer!23");
    }

    private void randomlySleep() {
        int random = (int) (Math.random() * 10);
        if(random % 2 == 0) {
            try {
                System.out.println("### 3초간 대기");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("### 정상 작동");
    }

    public Member commonMemberInfo(long id) {
        System.out.println("### fallback 발동");
        return new Member(null, "customer" , "undefined");
    }

}
