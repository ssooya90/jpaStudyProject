package ssooya.model.entity.item;

import lombok.Data;
import ssooya.model.entity.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 상속맵핑을 위한 부모 정의 나는 부모다.
@DiscriminatorColumn(name = "DTYPE") // 기본값이 DTYPE이므로 생략가능 , 부모클래스 구분 컬럼
public abstract class Item {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	private String name;
	private int price;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();

}
