package jpa.ch07.s03.nonidentification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parent {
	
	@Id
	@GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	
	private String name;
}
