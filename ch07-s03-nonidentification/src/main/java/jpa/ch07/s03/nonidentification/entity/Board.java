package jpa.ch07.s03.nonidentification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
	
	@Id
	@GeneratedValue
	@Column(name = "BOARD_ID")
	private Long id;
	
	@OneToOne(mappedBy = "board")
	private BoardDetail boardDetail;
	
	private String title;
}
