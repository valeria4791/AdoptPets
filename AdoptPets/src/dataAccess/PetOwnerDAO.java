package dataAccess;

import javax.persistence.EntityManager;

import entities.PetOwner;
import exception.ErrorInProcessPetOwner;
import utilities.AccessToDb;

public class PetOwnerDAO {
	public PetOwnerDAO() {
	}

	// Create new pet owner
	public PetOwner create(PetOwner newPetOwner) throws ErrorInProcessPetOwner {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.persist(newPetOwner);

			// Save and close
			AccessToDb.commitFactory();
			return newPetOwner;
		} catch (Exception e) {
			throw new ErrorInProcessPetOwner("Error in process pet owner data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Update pet owner
	public PetOwner update(PetOwner updatePetOwner) throws ErrorInProcessPetOwner {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.merge(updatePetOwner);

			// Save and close
			AccessToDb.commitFactory();
			return updatePetOwner;
		} catch (Exception e) {
			throw new ErrorInProcessPetOwner("Error in process pet owner data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Delete pet owner
	public void remove(int idPetOwner) throws ErrorInProcessPetOwner {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.remove(getPetOwner(idPetOwner));

			// Save and close
			AccessToDb.commitFactory();
		} catch (Exception e) {
			throw new ErrorInProcessPetOwner("Error in process pet owner data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Get pet owner
	public PetOwner getPetOwner(int idPetOwner) throws ErrorInProcessPetOwner {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			PetOwner petOwner = em.find(PetOwner.class, idPetOwner);

			// Close
			return petOwner;
		} catch (Exception e) {
			throw new ErrorInProcessPetOwner("Error in process pet owner data");
		} finally {
			AccessToDb.closeFactory();
		}
	}
}
