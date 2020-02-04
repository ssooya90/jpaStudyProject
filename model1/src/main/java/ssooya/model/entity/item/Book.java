package ssooya.model.entity.item;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by ssooya90@naver.com on 2020-02-05
 * Github : http://github.com/ssooya90
 */

@Data
@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") // ID 재정의
public class Book extends Item{

	private String author;
	private String isbn; // ISBN
}
