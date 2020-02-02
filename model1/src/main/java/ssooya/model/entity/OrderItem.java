package ssooya.model.entity;

import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

	@Id @GeneratedValue
	@Column(name ="ORDER_ITEM_ID")
	private Long id;

	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "ORDER_ID")
	private Long orderId;

	private int orderPrice; // 주문가격
	private int count;  // 주문수량

}
