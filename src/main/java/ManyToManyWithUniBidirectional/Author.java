package ManyToManyWithUniBidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {

	@Id
	@GeneratedValue
	@Column(name = "author_id")
	private long id;

	private String name;
	
	/* 있으면 Bidirectional, 없으면 Unidirectional*/
	/*@ManyToMany(cascade=CascadeType.ALL, mappedBy="authors")
	private Set<Book> books = new HashSet<Book>();
	*/
}
