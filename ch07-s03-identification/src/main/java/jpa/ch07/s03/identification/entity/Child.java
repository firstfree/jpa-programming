package jpa.ch07.s03.identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
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
@IdClass(ChildId.class)
public class Child {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Parent parent;
	
	@Id
	@Column(name = "CHILD_ID")
	private String childId;
	
	private String name;
}
