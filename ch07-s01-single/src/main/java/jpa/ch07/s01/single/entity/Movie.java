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
@DiscriminatorValue("M")
public class Movie extends Item {
	
	private String director;
	private String actor;
	
	@Builder
	public Movie(String name, int price, String director, String actor) {
		super(name, price);
		this.director = director;
		this.actor = actor;
	}
}
