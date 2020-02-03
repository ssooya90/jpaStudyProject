package ssooya.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="ORDERS")
public class Order {

	@Id @GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;

	// 기존
//	@Column(name = "MEMBER_ID")
//	private Long memberId;

	// 양방향
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@OneToOne
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery; // 배송정보

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	//== 연관관계 메소드 제거 ==//
	public void setMember(Member member){

		// 기존 관계 제거
		if(this.member != null){
			this.member.getOrders().remove(this);
		}

		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem){

		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}







}
