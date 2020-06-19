package dataAccess;

import javax.persistence.EntityManager;

import entities.Pet;
import exception.ErrorInProcessPetData;
import utilities.AccessToDb;

public class PetDAO {
	public PetDAO() {
	}

	// Create new pet
	public Pet create(Pet newPet) throws ErrorInProcessPetData {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.persist(newPet);

			// Save and close
			AccessToDb.commitFactory();
			return newPet;
		} catch (Exception e) {
			throw new ErrorInProcessPetData("Error in process pet data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Update pet
	public Pet update(Pet updatePet) throws ErrorInProcessPetData {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.merge(updatePet);

			// Save and close
			AccessToDb.commitFactory();
			return updatePet;
		} catch (Exception e) {
			throw new ErrorInProcessPetData("Error in process pet data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Delete pet
	public void remove(int idPPet) throws ErrorInProcessPetData {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.remove(getPet(idPPet));

			// Save and close
			AccessToDb.commitFactory();
		} catch (Exception e) {
			throw new ErrorInProcessPetData("Error in process pet data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Get pet 
	public Pet getPet(int idPPet) throws ErrorInProcessPetData {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			Pet pet = em.find(Pet.class, idPPet);

			// Close
			return pet;
		} catch (Exception e) {
			throw new ErrorInProcessPetData("Error in process pet data");
		} finally {
			AccessToDb.closeFactory();
		}
	}
}
