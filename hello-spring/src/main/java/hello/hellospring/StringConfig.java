package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {

//    DataSource dataSource;
//
//    @Autowired
//    public StringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
////    }
//    EntityManager em;
//
//    @Autowired
//    public StringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;

    @Autowired
    public StringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository()
//    {
////        return new MemoryMemberRepository();

//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);

//        return new JpaMemberRepository(em);

//    }

}
