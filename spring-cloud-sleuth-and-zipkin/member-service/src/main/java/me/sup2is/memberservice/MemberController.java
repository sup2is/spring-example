package me.sup2is.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/{memberId}")
    public Member getMember(@PathVariable("memberId") Long memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/member/{memberId}")
    public void updateMember(@PathVariable("memberId") Long memberId) {
        memberService.updateMember(memberId);
    }

}
