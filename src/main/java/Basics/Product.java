package Basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ProductBasics") // DB���� ���̺�� ����, �빮�ڸ� �൵ �ҹ��ڷθ� �����ȴ�.
public class Product {

	@Id // Primary Key�� ���
	@GeneratedValue // �ڵ����� ����
	@Column(name = "product_id") // DB���� ���̺��� �÷��� ����, ���� ���� �� "id"�� �״�� ����.
	private int id;

	@Column(name = "product_name")
	private String name;

	private int price;

	private String description;

}
