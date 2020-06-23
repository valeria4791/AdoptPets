package models;

import java.util.List;

import dataAccess.PetDAO;
import dataAccess.PetLoveDAO;
import dataAccess.UserDAO;
import entities.Pet;
import entities.PetLove;
import entities.User;
import exception.ErrorInProcessPetData;
import exception.ErrorInProcessPetLove;
import exception.ErrorInProcessUser;

//Class that process logic for create/update/delete likes of user likes 

public class LikeModel {

	// Access to Pet table in DB
	private PetDAO petAccess = new PetDAO();

	// Access to Love Pet table in DB
	private PetLoveDAO lovePetAccess = new PetLoveDAO();

	// Access to User table in DB
	private UserDAO userAccess = new UserDAO();

	// Create new like of pet by user
	public PetLove createNewLike(int userId, int petId)
			throws ErrorInProcessUser, ErrorInProcessPetData, ErrorInProcessPetLove {
		try {

			// Get user by user id
			User user = this.userAccess.getUser(userId);

			// Get pet by pet id
			Pet pet = this.petAccess.getPet(petId);

//			// Get user likes by user id
//			PetLove petLike = this.lovePetAccess.getPetLoveByUserId(userId);
//
//			// Check if data was found
//			if (petLike != null) {
//
//				// Add new pet to list of likes
//				petLike.getPets().add(pet);
//				
//
//				// Now update all changes in DB
//				this.lovePetAccess.update(petLike);
//			} else {

			// Create new object for user likes
			PetLove petLike = new PetLove();

			// Set data of this new like
			petLike.setUser(user);
			petLike.getPets().add(pet);

			user.getPetLove().add(petLike);

			// Now update all changes in DB
			this.lovePetAccess.create(petLike);
			this.userAccess.update(user);
//			}
			return petLike;
		} catch (ErrorInProcessPetLove ePetLove) {
			throw ePetLove;
		} catch (ErrorInProcessUser eUser) {
			throw eUser;
		} catch (ErrorInProcessPetData ePet) {
			throw ePet;
		}
	}

	// Delete like of pet by user
	public void deleteLike(int userId, int petId) throws ErrorInProcessPetData, ErrorInProcessPetLove {
		try {
			// Get pet by pet id
			Pet pet = this.petAccess.getPet(petId);

			// Get user likes by user id
			PetLove petLike = this.lovePetAccess.getPetLoveByUserId(userId);

			// Check if data was found
			if (petLike != null) {

				// Delete pet from list of likes
				petLike.getPets().remove(pet);

				// Now update all changes in DB
				this.lovePetAccess.update(petLike);
			}
		} catch (ErrorInProcessPetLove ePetLove) {
			throw ePetLove;
		} catch (ErrorInProcessPetData ePet) {
			throw ePet;
		}
	}

	// Show all likes of user
	public List<Pet> getAllLikes(int userId) throws ErrorInProcessPetLove {
		try {

			// Get user likes by user id
			PetLove petLike = this.lovePetAccess.getPetLoveByUserId(userId);

			// Get all likes of pets
			return petLike.getPets();

		} catch (ErrorInProcessPetLove ePetLove) {
			throw ePetLove;
		}
	}
}
