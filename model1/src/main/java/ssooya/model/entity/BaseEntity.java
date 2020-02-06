package ssooya.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass // 객체 입장에서 공통 매핑 정보가 ㅣㄹ요할 때 사용

//MappedSuperclas는 entity가 아니므로 jap에서 사용할 수 없다ㅒㅒ
public class BaseEntity {


	private Date createdDate;
	private Date lastModifiedDate;

}
