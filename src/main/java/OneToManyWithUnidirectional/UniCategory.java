package OneToManyWithUnidirectional;

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
public class UniCategory {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	private String name;
}
