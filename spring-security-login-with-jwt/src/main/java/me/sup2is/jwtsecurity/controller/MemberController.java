package me.sup2is.jwtsecurity.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.sup2is.jwtsecurity.member.Member;
import me.sup2is.jwtsecurity.member.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    final MemberRepository memberRepository;
    final PasswordEncoder encode;

    @PostMapping("/api/member")
    public String saveMember(@RequestBody MemberDto memberDto) {
        memberRepository.save(Member.createMember(memberDto.getEmail(), encode.encode(memberDto.getPassword())));
        return "success";
    }

}

@Data
class MemberDto {
    private String email;
    private String password;
}
