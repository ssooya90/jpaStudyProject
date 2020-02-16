package ssooya.jpashop.domain.item;

import lombok.Data;
import ssooya.jpashop.domain.Category;
import ssooya.jpashop.exception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	private String name;
	private int price; // 주석
	private int stockQuantity;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();

	//==비즈니스 로직==//
	public void addStock(int quantity){
		this.stockQuantity += quantity;
	}

	public void removeStock(int quantity){
		int restStock = this.stockQuantity - quantity;
		if (restStock < 0){
			throw new NotEnoughStockException("need more stock");
		}
		this.stockQuantity = restStock;
	}

}
