package jpa.ch07.s03.identification.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChildId implements Serializable {
	
	private static final long serialVersionUID = -507296629641442166L;
	
	private String parentId;
	
	@Column(name = "CHILD_ID")
	private String id;
}
