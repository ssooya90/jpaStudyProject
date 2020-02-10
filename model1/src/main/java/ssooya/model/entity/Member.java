package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AttributeOverride(name ="id", column = @Column(name= "MEMBER_ID")) // 부모로 부터 물려받은 매핑 정보 재정의
public class Member extends BaseEntity {


	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;


	@Embedded
	private Address address;

	private String city;
	private String street;
	private String zipcode;

	@OneToMany(mappedBy = "member") // mappedBy = "필드이름"? 객체이름?
	private List<Order> orders = new ArrayList<Order>();
}
