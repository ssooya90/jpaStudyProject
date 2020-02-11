package ssooya.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name ="DELIVERY_ID")
	private Delivery delivery;

	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status; // 주문상태

	// ==연관관계 메소드== //
	public void setMember(Member member){
		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem){
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
		delivery.setOrder(this);
	}
}
