package ssooya.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */
@Entity
@Data
public class Member {

	@Id
	@GeneratedValue
	@Column (name = "MEMBER_ID")
	private Long id;

	private String name;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();
}
