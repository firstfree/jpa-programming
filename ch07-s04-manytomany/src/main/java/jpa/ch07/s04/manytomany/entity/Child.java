package jpa.ch07.s04.manytomany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Child {

	@Id
	@GeneratedValue
	@JoinColumn(name = "CHILD_ID")
	private Long id;
	
	private String name;
}
