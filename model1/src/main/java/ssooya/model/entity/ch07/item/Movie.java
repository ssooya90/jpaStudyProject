package ssooya.model.entity.ch07.item;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ssooya90@naver.com on 2020-02-05
 * Github : http://github.com/ssooya90
 */

@Data
@Entity
@DiscriminatorValue("B")
public class Movie extends Item{

	private String director;
	private String actor;
}
