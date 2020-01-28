package ssooya.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by ssooya90@naver.com on 2020-01-29
 * Github : http://github.com/ssooya90
 */
public class ExamMergetMain {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ssooya");

	public static void main(String[] args){

		Member member = createMember("memberA","회원1");
		member.setUsername("회원명변경");
		mergeMember(member);
	}

	static Member createMember(String id, String username){

		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();

		Member member = new Member();
		member.setId(id);
		member.setUsername(username);

		em1.persist(member);
		tx1.commit();

		em1.close(); // 영속성 컨텍스트1 종료

		return member;
	}

	static void mergeMember(Member member){

		// 영속성 컨텐스트 2 시작

		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();

		tx2.begin();
		Member mergeMember = em2.merge(member);
		tx2.commit();

		//준영속상태
		System.out.println("member = " + member.getUsername());

		// 영속상태
		System.out.println("mergeMember = " + mergeMember.getUsername());

		System.out.println("em2 contains member = " + em2.contains(member));

		System.out.println("em2 contains mergeMember =" + em2.contains(mergeMember));

		em2.close();
	}
}
