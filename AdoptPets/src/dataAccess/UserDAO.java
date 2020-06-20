package dataAccess;

import javax.persistence.EntityManager;

import entities.User;
import exception.ErrorInProcessUser;
import utilities.AccessToDb;

public class UserDAO {
	public UserDAO() {
	}

	// Create new user
	public User create(User newUser) throws ErrorInProcessUser {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.persist(newUser);

			// Save and close
			AccessToDb.commitFactory();
			return newUser;
		} catch (Exception e) {
			throw new ErrorInProcessUser("Error in process user data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Update user
	public User update(User updateUser) throws ErrorInProcessUser {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.merge(updateUser);

			// Save and close
			AccessToDb.commitFactory();
			return updateUser;
		} catch (Exception e) {
			throw new ErrorInProcessUser("Error in process user data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Delete user
	public void remove(int idUser) throws ErrorInProcessUser {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			em.remove(getUser(idUser));

			// Save and close
			AccessToDb.commitFactory();
		} catch (Exception e) {
			throw new ErrorInProcessUser("Error in process user data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Get user
	public User getUser(int idUser) throws ErrorInProcessUser {
		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			User user = em.find(User.class, idUser);

			// Close
			return user;
		} catch (Exception e) {
			throw new ErrorInProcessUser("Error in process user data");
		} finally {
			AccessToDb.closeFactory();
		}
	}

	// Get User by username and password
	public User findUserByData(String username, String password) throws ErrorInProcessUser {

		try {
			// access to DB
			EntityManager em = AccessToDb.createFactory();

			// Select User by username and password
			User selectedUser = em.createNamedQuery("FindUser", User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			
			return selectedUser;
		} catch (Exception e) {
			throw new ErrorInProcessUser("Error in process user data");
		} finally {
			AccessToDb.closeFactory();
		}
	}
}
