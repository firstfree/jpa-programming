package jpa.ch07.s01.single.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@DiscriminatorValue("A")
public class Album extends Item {
	
	private String artist;
	
	@Builder
	public Album(String name, int price, String artist) {
		super(name, price);
		this.artist = artist;
	}
}
