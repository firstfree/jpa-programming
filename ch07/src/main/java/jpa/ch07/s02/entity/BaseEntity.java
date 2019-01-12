package jpa.ch07.s02.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public BaseEntity(String name) {
		this.name = name;
	}
}
