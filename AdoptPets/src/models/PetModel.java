package models;

//Class that process logic for create/update/delete pet data

import entities.Pet;
import entities.PetOwner;

public class PetModel {
	
	private Pet pet;

	private int petId;
	private PetOwner petOwner;
	private String category;
	private String petName;
	private int petAge;
	private int petSize;
	private String gender;
	private String shortDescription;
	private String detailDescription;
	
	public Pet createNewPet() {
		return this.pet;
	}
}
