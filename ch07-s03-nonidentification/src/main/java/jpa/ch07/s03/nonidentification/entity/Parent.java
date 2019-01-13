package jpa.ch07.s03.nonidentification.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
	
	@EmbeddedId
	private ParentId parent;
	
	private String name;
}
