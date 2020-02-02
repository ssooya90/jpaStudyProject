package ssooya.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Orders")
public class Order {

	@Id @GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;

	@Column(name = "MEMBER_ID")
	private Long memberId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}
