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
public class GrandChildId implements Serializable {
	
	private static final long serialVersionUID = 7084782951400471023L;
	
	private ChildId child;
	private String id;
}
