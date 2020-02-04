package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {

	@Id @GeneratedValue
	@Column(name ="MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;

	@OneToMany(mappedBy = "member") // mappedBy = "필드이름"? 객체이름?
	private List<Order> orders = new ArrayList<Order>();
}
