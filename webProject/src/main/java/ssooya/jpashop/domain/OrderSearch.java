package ssooya.jpashop.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;

import static org.springframework.data.jpa.domain.Specifications.where;
import static ssooya.jpashop.domain.OrderSpec.memberNameLike;
import static ssooya.jpashop.domain.OrderSpec.orderStatusEq;

@Data
public class OrderSearch {

	private String memberName;
	private OrderStatus orderStatus; // 주문상태[ORDER, CANCEL]

	//Getter , Setter


	//추가
	public Specification<Order> toSpecification(){
		return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
	}


}
