package jpa.ch07.s03.nonidentification.entity;

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
public class ParentId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PARENT_ID1")
	private String id1;
	
	@Column(name = "PARENT_ID2")
	private String id2;
}
