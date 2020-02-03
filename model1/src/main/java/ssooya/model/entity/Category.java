package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-04
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private long id;

	private String name;

	@ManyToMany
	@JoinTable(name =  "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ITEM_CD"))
	private List<Item> items = new ArrayList();

	// 카테고리 계층 구조를 위한 필드들
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();

	//==연관관계 메소드==//
	public void addChlidCategory(Category child){
		this.child.add(child);
		child.setParent(this);
	}

	public void addItem(Item item){
		items.add(item);
	}

}
