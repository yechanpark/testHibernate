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
	// �ڵ����� �����ϵ� "myGenerator"��� Generator���� �����Ǵ� ���� ����.
	@GeneratedValue(generator = "myGenerator")
	// FK�μ� ���� ���� �����ϰ�, �̴� FK���� ���ڷ� value�Ӽ��� ���� "person"�� �����Ѵ�.
	// ���⼭ value = "person" �̶�� ���� Person��ü�� ������� ���ƾ� �Ѵ�.
	@GenericGenerator(name = "myGenerator", strategy = "foreign", parameters = @Parameter(value = "person", name = "property"))
	private long id;

	private String licenseNumber;
	private Date issue_date;

	@OneToOne(cascade = CascadeType.ALL)
	// UniLicense�� �ܷ�Ű�� UniPerson�� person_id��� �÷����� ����
	@JoinColumn(name = "person_id")
	private UniPerson person;
}
