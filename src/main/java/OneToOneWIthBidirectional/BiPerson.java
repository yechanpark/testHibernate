package OneToOneWIthBidirectional;

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
public class BiPerson {

	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;

	private String firstName;
	private String lastName;

	// 양방향이므로 BiPerson에서도 매핑정보를 기술한다. 부모쪽에 Cascade를 설정한다.
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private BiLicense license;

}
