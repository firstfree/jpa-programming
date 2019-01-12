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
public class IdentifiedGrandChildId implements Serializable {
	
	private static final long serialVersionUID = 7084782951400471023L;
	
	private IdentifiedChildId child;
	private String id;
}
