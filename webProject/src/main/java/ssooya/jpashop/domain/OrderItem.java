package ssooya.jpashop.domain;

import lombok.Data;
import ssooya.jpashop.domain.item.Item;

import javax.persistence.*;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	private int orderPrice;
	private int count;

	//==생성 메소드 ==//
	public static OrderItem createOrderItem(Item item, int orderPrice, int count){
		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		orderItem.setOrderPrice(orderPrice);
		orderItem.setCount(count);

		item.removeStock(count);
		return orderItem;
	}

	//==비즈니릇 로직==//
	/**
	 * 주문취소
	 */
	public void cancel(){
		getItem().addStock(count);
	}

	//==조회 로직==//
	/** 주문상품 전체 가격 조회 */
	public int getTotalPrice(){
		return getOrderPrice() * getCount();
	}


}
