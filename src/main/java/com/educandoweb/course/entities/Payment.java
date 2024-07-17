package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_payment")                              //mapping
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;     //serializable

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                      //basic attributes
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;                  //associations(collections)
	
	public Payment() {                    //constructors
		
	}

	public Payment(Long id, Instant moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	public Long getId() {                 //getters and setters
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {                          //hashcode and equals (id only)
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
