package ssooya.model.entity.item;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 상속맵핑을 위한 부모 정의
@DiscriminatorColumn(name = "DTYPE") // 기본값이 DTYPE이므로 생략가능 , 부모클래스 구분 컬럼
public abstract class Item {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	private String name;
	private int price;
}
