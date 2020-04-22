package me.sup2is.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PublishMemberChange {

    @Autowired
    private Source source;

    public void publishMemberChange(Long memberId) {
        MemberChangeModel model = new MemberChangeModel(memberId, "회원의 상태가 변경되었습니다");
        source.output().send(MessageBuilder.withPayload(model).build());
    }

}
