package ssooya.model.entity;

import lombok.Data;
import ssooya.model.entity.item.Item;

import javax.persistence.*;

@Data
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

	// 테스트
	@Id @GeneratedValue
	@Column(name ="ORDER_ITEM_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name = "ORDER_ID") // 객체 컬럼명
	private Order order;

	private int orderPrice; // 주문가격
	private int count;  // 주문수량

}
