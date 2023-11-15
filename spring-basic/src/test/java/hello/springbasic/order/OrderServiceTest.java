package hello.springbasic.order;

import hello.springbasic.AppConfig;
import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemberService;
import hello.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.BorderUIResource;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfg = new AppConfig();
        memberService = appConfg.memberService();
        orderService = appConfg.orderService();

    }

    @Test
    void createOrder()
    {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(100);

    }
}
