package OneToManyWithBidirectional;

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
@Table(name = "BiProduct") // Table�� ����
public class BiProduct {

	@Id // Primary Key�� ���
	@GeneratedValue // �ڵ����� ����
	@Column(name = "product_id") // DB���� �Ӽ��� ����, ���� ���� �� "id"�� �״�� ����.
	private int id;

	private String name;

	private int price;

	private String description;

	// Product�� Category�� N:1 �̹Ƿ� ���� Ŭ���� �������� ManyToOne
	@ManyToOne
	// foreignŰ�� �����ϸ� �̸��� "category_id"�� ����.
	// �ܷ�Ű�� ���� Many ���̵�(child)���� ������ �ִ�.
	@JoinColumn(name = "category_id")
	private BiCategory category;

}
