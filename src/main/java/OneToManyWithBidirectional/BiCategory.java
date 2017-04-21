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

	// Category�� Product�� 1:N �̹Ƿ� ���� Ŭ���� �������� OneToMany
	// Product���� foreign key������ �ϴ� ������ �̸�, �ڽ�(Product)���� ���� ����
	// mappedBy�Ӽ��� ���� ���� Ŭ�������� �� Ŭ������ ����Ű�� Reference�� ������� ����.
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<BiProduct> products = new HashSet<BiProduct>();
}
