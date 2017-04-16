package OneToMany;

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
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	private String name;

	// Category와 Product는 1:N 이므로 OneToMany
	// Product에서 foreign key역할을 하는 변수의 이름, 이 변수가 지정하는 자식테이블(Product)까지 같이 저장
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>();
}
