package hello.springbasic.discount;

import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        Member memverVIP = new Member(1L, "memverVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(memverVIP, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x()
    {
        // given
        Member memverBasic = new Member(1L, "memverBasic", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(memverBasic, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}