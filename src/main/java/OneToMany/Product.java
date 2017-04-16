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
@Table(name = "Product") // Table�� ����
public class Product {

	@Id // Primary Key�� ���
	@GeneratedValue // �ڵ����� ����
	@Column(name = "product_id") // DB���� �Ӽ��� ����, ���� ���� �� "id"�� �״�� ����.
	private int id;

	private String name;

	private int price;

	private String description;

	// Product�� Category�� N:1 �̹Ƿ� ManyToOne
	@ManyToOne
	@JoinColumn(name = "category_id") // foreignŰ�� �����ϸ� �̸��� "category_id"�� ����.
	private Category category; // Category�� ���� reference

}
