package jpa.market.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	private Date createdDate;
	private Date lastModifiedDate;
}
