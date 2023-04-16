package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;//인터페이스만 의존

    //생성자 생성 -> 생성자를 통해 어떤 구현 객체를 주입될지는 오직 외부(AppConfig)에서 결정된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}