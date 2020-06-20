package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pet
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "AllPets", query = "SELECT p FROM Pet p"),
		@NamedQuery(name = "PetsByCriteria", query = "SELECT p FROM Pet p WHERE p.category = :category") })
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int petId;

	// one to one relationship - To pet owner table
	@OneToOne
	private PetOwner petOwner;

	private String category;
	private String petName;
	private int petAge;
	private int petSize;
	private String gender;
	private String shortDescription;
	private String detailDescription;

	public Pet() {
		super();
	}

	public int getPetId() {
		return this.petId;
	}

	public PetOwner getPetOwner() {
		return this.petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPetName() {
		return this.petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return this.petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public int getPetSize() {
		return this.petSize;
	}

	public void setPetSize(int petSize) {
		this.petSize = petSize;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return this.detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

}
