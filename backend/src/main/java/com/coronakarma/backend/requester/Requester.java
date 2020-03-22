package com.coronakarma.backend.requester;

import com.coronakarma.backend.common.Person;

import javax.persistence.*;

@Entity
@Table(name = "requester")
public class Requester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="personId")
	private Person person;
	
	private String shoppingList;
	
	private String dietaryRequirements;
	
	private Boolean premium;
	
	private String paymentMethod;
	
	private Double maxAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(String shoppingList) {
		this.shoppingList = shoppingList;
	}

	public String getDietaryRequirements() {
		return dietaryRequirements;
	}

	public void setDietaryRequirements(String dietaryRequirements) {
		this.dietaryRequirements = dietaryRequirements;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	
	
}
