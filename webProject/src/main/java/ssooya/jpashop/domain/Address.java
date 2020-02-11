package ssooya.jpashop.domain;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */
@Data
@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;

}
