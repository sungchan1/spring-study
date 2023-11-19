package hello.springbasic;

import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemberService;
import hello.springbasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // memberServiceImpl
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 이름 , 아비
        new Member(1L, "memberA", Grade.VIP);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        new Member(1L, "memberA", Grade.VIP);

     
        

        Member findMember = memberService.findMember(1L);
        System.out.println("member.getName() = " + member.getName());
        System.out.println("findMember.getName() = " + findMember.getName());

    }
}
