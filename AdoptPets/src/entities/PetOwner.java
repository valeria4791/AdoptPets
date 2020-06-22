package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PetOwner
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "PetOfOwner", query = "SELECT p FROM PetOwner o JOIN o.pet p WHERE o.petOwnerId = :petOwnerId") })
public class PetOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int petOwnerId;

	// many to one relationship - To user table
	@ManyToOne
	private User user;

	private long phoneNumber;
	private String city;
	private String street;
	private int houseNumber;

	// one to one relationship - To pet table
	@OneToOne
	private Pet pet;

	public PetOwner() {
		super();
	}

	public int getPetOwnerId() {
		return this.petOwnerId;
	}

	public void setPetOwnerId(int petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	public long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
