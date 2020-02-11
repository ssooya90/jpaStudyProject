package ssooya.jpashop.domain.item;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ssooya90@naver.com on 2020-02-12
 * Github : http://github.com/ssooya90
 */

@Data
@Entity
@DiscriminatorValue("B")
public class Book extends Item{

	private String author;
	private String isbn;

}
