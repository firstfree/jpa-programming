package jpa.ch07.s03.identification.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	
	@EmbeddedId
	private ChildId id;

	@MapsId("parentId")
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Parent parent;
	
	private String name;
}
