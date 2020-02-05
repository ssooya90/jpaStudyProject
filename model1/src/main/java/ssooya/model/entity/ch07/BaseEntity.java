package ssooya.model.entity.ch07;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by ssooya90@naver.com on 2020-02-06
 * Github : http://github.com/ssooya90
 */
@Data
@MappedSuperclass // 객체 입장에서 공통 매핑 정보가 ㅣㄹ요할 때 사용

//MappedSuperclas는 entity가 아니므로 jap에서 사용할 수 없다ㅒㅒ
public abstract class BaseEntity {

	@Id @GeneratedValue
	private Long id;
	private String name;
}
