package ssooya.jpashop.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * Created by ssooya90@naver.com on 2020-02-18
 * Github : http://github.com/ssooya90
 */
public class OrderSpec {

	public static Specification<Order> memberNameLike(final String memberName){
		return new Specification<Order>() {
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

				if(StringUtils.isEmpty(memberName)) return null;

				Join<Order,Member> m = root.join("member", JoinType.INNER); // 회원과 조인
				return criteriaBuilder.like(m.<String>get("name"), "%" + memberName + "%");
			}
		};
	}


	public static Specification<Order> orderStatusEq(final OrderStatus orderStatus){

		return new Specification<Order>() {
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

				if(orderStatus == null) return null;

				return criteriaBuilder.equal(root.get("status"), orderStatus);
			}
		};

	}


}
