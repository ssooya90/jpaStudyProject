package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;

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
}
