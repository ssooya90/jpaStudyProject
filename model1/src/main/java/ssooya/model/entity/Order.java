package ssooya.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Orders")
public class Order extends BaseEntity{

	@Id @GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;

	// 기존
//	@Column(name = "MEMBER_ID")
//	private Long memberId;

	// 양방향
	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩 fetch = FetchType.LAZY
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name ="DELIVERY_ID")
	private Delivery delivery;

	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL) // 영속성 전이 설정
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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
