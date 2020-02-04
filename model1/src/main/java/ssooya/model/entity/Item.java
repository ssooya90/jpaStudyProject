package ssooya.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Item {

	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	// 테스트
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	private String name; // 이름
	private int price; // 가격
	private int stockQuantity; // 재고수량
}
