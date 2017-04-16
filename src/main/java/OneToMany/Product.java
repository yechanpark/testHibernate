package OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Product") // Table명 지정
public class Product {

	@Id // Primary Key로 사용
	@GeneratedValue // 자동으로 생성
	@Column(name = "product_id") // DB에서 속성명 변경, 지정 안할 시 "id"가 그대로 들어간다.
	private int id;

	private String name;

	private int price;

	private String description;

	// Product와 Category는 N:1 이므로 ManyToOne
	@ManyToOne
	@JoinColumn(name = "category_id") // foreign키를 지정하며 이름은 "category_id"로 설정.
	private Category category; // Category에 대한 reference

}
