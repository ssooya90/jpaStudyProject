package ssooya.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-01-29
 * Github : http://github.com/ssooya90
 */


public class JpaMain {


	public static void main(String[] args){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ssooya");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();
			logic(em);
			tx.commit();

		}catch (Exception e){

			tx.rollback();
		}finally {
			em.close();
		}

		emf.close();
	}

	// 비즈지스 로직
	private static void logic(EntityManager em){

		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("희수");
		member.setAge(2);

		// 등록
		em.persist(member);

		//수정
		member.setAge(20);

		//한건조회
		Member findMember = em.find(Member.class, id);
		System.out.println("findMember" + findMember.getUsername() + ", age=" + findMember.getAge());

		//목록조회
		List<Member> members = em.createQuery("select m from Member m",Member.class).getResultList();

		System.out.println("members.size =" + members.size());

		//삭제
		em.remove(member);


	}
}
