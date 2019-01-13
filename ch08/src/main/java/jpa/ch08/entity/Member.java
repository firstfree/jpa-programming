package jpa.ch08.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Embedded
	private Address homeAddress;
	
	@Default
	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();
	
	@Default
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AddressEntity> addressHistory = new ArrayList<>();
}
