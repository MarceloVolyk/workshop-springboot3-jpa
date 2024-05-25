package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/*Basic entity chscklist:
 * -Basic attributes
 * -Associations (instatiate collections) -> from class diagram
 * -Constructors (do not include collections)
 * -Getters and setters (collections: only get)
 * -Hashcode and equals
 * -Serializable
 * -Mapping (@ notations)
 */

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {           //serializable
	private static final long serialVersionUID = 1L;   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                           //basic attributes
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	//criando a tabela de associação "Muitos pra muitos (N pra N):
	
	@ManyToMany
	@JoinTable(name = "tb_product_category",
	joinColumns = @JoinColumn(name = "product_id"),         
	inverseJoinColumns = @JoinColumn(name = "category_id")) 
	//como uma tabela de associação possui apenas chaves estrangeiras, temos que especificar qual e qual,
	//então o parâmetro "joinColumns" irá se referir à classe onde estamos fazendo o mapeamento do JPA,
	//neste caso, Product, e o "inverseJoinColumns" irá se referir à outra classe da associação, neste caso, Category
	private Set<Category> categories = new HashSet<>();   //associations (instantiate collections)
	
	public Product() {                          //constructors
		
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {               //getters and setters (collections: only get)
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {                 //hashcode and equals (for id only)
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
}
