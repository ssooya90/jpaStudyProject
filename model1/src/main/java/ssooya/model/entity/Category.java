package ssooya.model.entity;

import lombok.Data;
import ssooya.model.entity.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-07
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;

	@Column
	private String name;

	// 조인
	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name= "CATEGORY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items = new ArrayList<Item>();

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();

	//=연관관계 메서드==//
	public void addChildCategory(Category child){
		this.child.add(child);
		child.setParent(this);
	}

}
