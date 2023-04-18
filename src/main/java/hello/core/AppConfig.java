package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.
    //refactoring(ctrl alt m) 로 memberService / memberRepository / orderService / discountPolicy 의 역활을 전부 보여준다.
    //이렇게 하면 AppConfig 에서 바꿔주기만 하면 된다.
    public MemberService memberService() {
        //실제 동작에 필요한 구현 객체 생성, 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}