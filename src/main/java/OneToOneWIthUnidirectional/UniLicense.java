package OneToOneWIthUnidirectional;

import java.util.Date;

import javax.persistence.CascadeType;
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
public class UniLicense {

	@Id
	// 자동으로 생성하되 "myGenerator"라는 Generator에서 생성되는 값을 쓴다.
	@GeneratedValue(generator = "myGenerator")
	// FK로서 오는 값을 생성하고, 이는 FK값은 인자로 value속성의 값인 "person"을 참조한다.
	// 여기서 value = "person" 이라는 값은 Person객체의 변수명과 같아야 한다.
	@GenericGenerator(name = "myGenerator", strategy = "foreign", parameters = @Parameter(value = "person", name = "property"))
	private long id;

	private String licenseNumber;
	private Date issue_date;

	@OneToOne(cascade = CascadeType.ALL)
	// UniLicense의 외래키는 UniPerson의 person_id라는 컬럼으로 지정
	@JoinColumn(name = "person_id")
	private UniPerson person;
}
