package ssooya.start;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ssooya90@naver.com on 2020-01-31
 * Github : http://github.com/ssooya90
 */

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

	//==추가==
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Lob
	private String description;



}
