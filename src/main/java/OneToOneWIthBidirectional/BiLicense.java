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

	@OneToOne // �θ��ʸ� �����ص� cascade�� ���� �ڵ������� �ڽĵ� ����ǹǷ� ���⼭ cascade�� �ʿ� ����.
	@JoinColumn(name = "person_id")
	private BiPerson person;
}