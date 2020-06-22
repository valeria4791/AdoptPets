package test;

import java.util.List;

import entities.Pet;
import entities.PetOwner;
import entities.User;
import models.LikeModel;
import models.PetModel;
import models.UserModel;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Create User
		UserModel userModel = new UserModel();
		try {
			userModel.createNewUser("valeria", "Aa123456", "Valeria", "Yermaev", "valeria4791@gmail.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 2. Create Per + Owner x 4
		PetModel petModel = new PetModel();
		try {

			// Get created user
			User user = userModel.findUser("valeria", "Aa123456");

			long number = Long.valueOf("0544458996");
			petModel.createNewPet(user.getUserId(), "Dog", "Lucky", 5, "Big", "male", "הכלב הכי חמוד שיש",
					"הכלב הכי חמוד שיש.לא נושך ולא נובח", number, "תל אביב", "רודשילד", 16);
			petModel.createNewPet(user.getUserId(), "Dog", "Moana", 1, "small", "female", "הכלבה הכי חמודה שיש",
					"הכלבה הכי חמודה שיש.לא נושכת ולא נובחת", number, "תל אביב", "רודשילד", 16);
			petModel.createNewPet(user.getUserId(), "Cat", "Lucky", 3, "Big", "male", "החתול הכי חמוד שיש",
					"החתול הכי חמוד שיש.לא נושך ולא נובח", number, "תל אביב", "רודשילד", 16);
			petModel.createNewPet(user.getUserId(), "Cat", "Lucky", 7, "small", "male", "החתול הכי חמוד שיש",
					"החתול הכי חמוד שיש.לא נושך ולא נובח", number, "תל אביב", "רודשילד", 16);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 3. Create Likes of user x 2
		LikeModel likeModel = new LikeModel();
		try {

			// Get created user
			User user = userModel.findUser("valeria", "Aa123456");

			// Get created pets - Dogs
			List<Pet> pets = petModel.getPetsByCriteria("Dog", 0, "", "");

			for (Pet currPet : pets) {
				likeModel.createNewLike(user.getUserId(), currPet.getPetId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 4. Get user likes
		try {

			// Get created user
			User user = userModel.findUser("valeria", "Aa123456");

			// Get created pets - Dogs
			List<Pet> pets = likeModel.getAllLikes(user.getUserId());

			for (Pet currPet : pets) {
				System.out.println(currPet.getPetName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
