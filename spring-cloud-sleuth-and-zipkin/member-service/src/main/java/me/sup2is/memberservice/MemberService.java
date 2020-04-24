package me.sup2is.memberservice;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public Member getMember(long memberId) {
        return new Member(memberId, "sup2is", "qwer!23");
    }

    public void updateMember(long memberId) {
        // member update 로직 ...
        System.out.println("### MemberService에서 발행");
        System.out.println("MemberService에서 받은 memberId : " + memberId);
    }

}
