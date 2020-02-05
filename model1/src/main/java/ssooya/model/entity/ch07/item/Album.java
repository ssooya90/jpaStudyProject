package ssooya.model.entity.ch07.item;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

	private String artist;
}
