package jpa.ch07.s04.manytoone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Child {

	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;
	
	private String name;
	
	@ManyToOne(optional = false)
	@JoinTable(name = "PARENT_CHILD",
		joinColumns = @JoinColumn(name = "CHILD_ID"),
		inverseJoinColumns = @JoinColumn(name = "PARENT_ID")
	)
	private Parent parent;
}
