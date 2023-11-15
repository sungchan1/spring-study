package hello.springbasic;

import hello.springbasic.discount.DiscountPolicy;
import hello.springbasic.discount.FixDiscountPolicy;
import hello.springbasic.discount.RateDiscountPolicy;
import hello.springbasic.member.*;
import hello.springbasic.order.OrderService;
import hello.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(meberRepository());
    }

    @Bean
    public static MemberRepository meberRepository() {
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(meberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy()
        return new RateDiscountPolicy();

    }
}
