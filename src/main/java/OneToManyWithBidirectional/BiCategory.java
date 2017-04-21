package OneToManyWithBidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BiCategory {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	private String name;

	// Category와 Product는 1:N 이므로 현재 클래스 기준으로 OneToMany
	// Product에서 foreign key역할을 하는 변수의 이름, 자식(Product)까지 같이 저장
	// mappedBy속성의 값은 상대방 클래스에서 이 클래스를 가리키는 Reference의 변수명과 같다.
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<BiProduct> products = new HashSet<BiProduct>();
}
