package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Pet;
import exception.ErrorInProcessPetData;
import models.PetModel;

@ManagedBean(name = "petMB")
@SessionScoped
public class PetMB implements Serializable {

	private PetModel petModel;

	private byte[] imgString;

	public byte[] getImgString() {
		return imgString;
	}

	public void setImgString(byte[] imgString) {
		this.imgString = imgString;
	}

	// Contractor
	public PetMB() throws ErrorInProcessPetData {
		this.petModel = new PetModel();

		System.out.println("Check photo");

		// Get pet
		Pet pet = this.petModel.getPetById(1);

		// Get Image
		this.imgString = pet.getPetPhoto();
	}
}