package ssooya.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ssooya90@naver.com on 2020-02-04
 * Github : http://github.com/ssooya90
 */
@Data
@Entity
public class Delivery {
	@Id
	@GeneratedValue
	@Column
	private Long id;

	@OneToOne(mappedBy = "delivery")
	private Order order;

	private String city;
	private String street;
	private String zipcode;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
}
