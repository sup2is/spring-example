package me.sup2is.securitylogin2.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 등록")
    public void save_member() {
        Member member = Member.createMember("dev.sup2is@gmail.com", "sup2is");
        memberRepository.save(member);
        List<Member> members = (List<Member>) memberRepository.findAll();
        assertEquals(members.size(), 1);
    }

}