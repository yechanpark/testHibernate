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
@Table(name = "ProductBasics") // DB에서 테이블명 변경, 대문자를 줘도 소문자로만 생성된다.
public class Product {

	@Id // Primary Key로 사용
	@GeneratedValue // 자동으로 생성
	@Column(name = "product_id") // DB에서 테이블의 컬럼명 변경, 지정 안할 시 "id"가 그대로 들어간다.
	private int id;

	@Column(name = "product_name")
	private String name;

	private int price;

	private String description;

}
