package ssooya.start;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ssooya90@naver.com on 2020-01-29
 * Github : http://github.com/ssooya90
 */
// 수정테스트
@Data
@Entity
@Table(name="MEMBER")
public class Member {

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="NAME")
	private String username;

	@Column
	private int age;

}
