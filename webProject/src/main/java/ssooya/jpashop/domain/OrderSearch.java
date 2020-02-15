package ssooya.jpashop.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class OrderSearch {

	private String memberName;
	private OrderStatus orderStatus; // 주문상태[ORDER, CANCEL]

	//Getter , Setter




}
