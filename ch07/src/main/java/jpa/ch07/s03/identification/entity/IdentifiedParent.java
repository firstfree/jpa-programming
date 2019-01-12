package jpa.ch07.s03.identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class IdentifiedParent {
	
	@Id
	@Column(name = "PARENT_ID")
	private String id;
	
	private String name;
}
