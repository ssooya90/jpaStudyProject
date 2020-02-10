package ssooya.model.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;

// 값타입 사용
@Data
@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;
}
