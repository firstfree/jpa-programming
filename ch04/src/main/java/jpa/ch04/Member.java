package jpa.ch04;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEMBER", uniqueConstraints =
	@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"}))
public class Member {
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String username;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;
}
