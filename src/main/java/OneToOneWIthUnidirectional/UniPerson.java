package OneToOneWIthUnidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UniPerson {

	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;

	private String firstName;
	private String lastName;

}
