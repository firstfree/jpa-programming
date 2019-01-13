package jpa.ch07.s03.identification.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
public class GrandChild {

	@EmbeddedId
	private GrandChildId id;
	
	@MapsId("childId")
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID", referencedColumnName = "PARENT_ID"),
		@JoinColumn(name = "CHILD_ID", referencedColumnName = "CHILD_ID")
	})
	private Child child;
	
	
	private String name;
}
