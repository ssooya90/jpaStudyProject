package ssooya.model;

import ssooya.model.entity.Member;
import ssooya.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by ssooya90@naver.com on 2020-02-03
 * Github : http://github.com/ssooya90
 */
public class Main {

	public static void main(String[] args) {

		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); // 트랜잭션 기능 획득

		try{

			tx.begin(); // 트랙잭션 시작

			//===== 이런식으로 객체 그래프 탐색
			long orderId = 1;

			//TODO 비즈니스 로직
			Order order = em.find(Order.class, orderId);
			Member member = order.getMember(); // 주문한 회원 참조사용
			//======


			tx.commit();

		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close(); // 엔티티 매니저 종료
		}

		emf.close(); // 매니저 팩토리 종료

	}
}
