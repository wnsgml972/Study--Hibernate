package testHibernate;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //table µî·Ï
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int id;
	
	private String name;
	
	private int price;	
	
	private String description;	

	@ManyToOne
	@JoinColumn
	private Category category;
}