package jpa.ch07.s03.identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(IdentifiedGrandChildId.class)
public class IdentifiedGrandChild {
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID", referencedColumnName = "PARENT_ID"),
		@JoinColumn(name = "CHILD_ID", referencedColumnName = "CHILD_ID")
	})
	private IdentifiedChild child;
	
	@Id
	@Column(name = "GRANDCHILD_ID")
	private String id;
	
	private String name;
}
