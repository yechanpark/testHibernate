package OneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;

	private String firstName;
	private String lastName;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private License license;

}
