package jpa.ch07.s03.nonidentification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Child {

	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Parent parent;
	
	private String name;
}
