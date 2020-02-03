package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	private String name; // 이름
	private int price; // 가격
	private int stockQuantity; // 재고수량

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();
}
