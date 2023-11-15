package hello.springbasic.member;


import hello.springbasic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfg = new AppConfig();
        memberService = appConfg.memberService();

    }


    @Test
    void join()
    {

        // given
        Member member = new Member(1L, "memberA", Grade.VIP);



        // when
        this.memberService.join(member);
        Member findMember = this.memberService.findMember(1L);


        // then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
