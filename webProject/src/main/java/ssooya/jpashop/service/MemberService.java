package ssooya.jpashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssooya.jpashop.domain.Member;
import ssooya.jpashop.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	/** 회원가입 *
	 *
	 */
	public Long join(Member member){
		validateDuplicateMember(member); // 중복회원검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member){
		List<Member> findMembers = memberRepository.findByName(member.getName());
		if(!findMembers.isEmpty()){
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}


	/** 전체회원 조회
	 *
	 */
	public List<Member> findMember(){
		return memberRepository.findAll();
	}

	public Member findOne(Long memberId){
		return memberRepository.findOne(memberId);
	}

}

