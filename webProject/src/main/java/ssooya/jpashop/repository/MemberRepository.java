package ssooya.jpashop.repository;

import org.springframework.stereotype.Repository;
import ssooya.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

	@PersistenceContext
	EntityManager em;

	// @PersistenceContext
	// 순수 자바 환경에서는 직접 생성했지만, 스프링이나 J2EE 컨테이너를 사용하면 컨테이너가 엔티티 매니저를 관리하고 제공해줌
	// 따라서 엔티티 매니저 팩토리에서 엔티티 매니저를 직접 생성해서 사용하는 것이 아닌 컨테이너가 제공하는 엔티티 매니저를 사용해야 함

	public void save(Member member){
		em.persist(member);
	}

	public Member findOne(Long id){
		return em.find(Member.class, id);
	}

	public List<Member> findAll(){
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

	public List<Member> findByName(String name){
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name",name)
				.getResultList();
	}
}
