package jpa.ch07.s03.identification.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentifiedChildId implements Serializable {
	
	private static final long serialVersionUID = -507296629641442166L;
	
	private String parent;
	private String childId;
}
