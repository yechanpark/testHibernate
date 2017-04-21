package OneToOneWIthBidirectional;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BiLicense {

	@Id
	@GeneratedValue(generator = "myGenerator")
	@GenericGenerator(name = "myGenerator", strategy = "foreign", parameters = @Parameter(value = "person", name = "property"))
	private long id;

	private String licenseNumber;
	private Date issue_date;

	@OneToOne // 부모쪽만 저장해도 cascade에 의해 자동적으로 자식도 저장되므로 여기서 cascade는 필요 없다.
	@JoinColumn(name = "person_id")
	private BiPerson person;
}
