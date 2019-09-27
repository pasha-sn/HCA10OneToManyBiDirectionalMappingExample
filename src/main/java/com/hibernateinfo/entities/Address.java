package com.hibernateinfo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
@Entity
@Table(name="address_table")
@DynamicUpdate
public class Address 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private Integer addressId;
	
	@Column(name = "street_name",length=50)
    private String street;
	
    @Column(name = "city_name",length=50)
    private String city;
    
    @Column(name = "state_name")
    private String state;
    
    @Column(name = "postal_code")
    private Long postalcode;
    
    //A bidirectional association via a foreign key with a foreign column name specification
    //what is @JoinColumn and how it is used in Hibernate:
    //https://stackoverflow.com/questions/37542208/what-is-joincolumn-and-how-it-is-used-in-hibernate
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Long pincode) {
		this.postalcode = pincode;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postalcode=" + postalcode + "]";
	}	    
}
