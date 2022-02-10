package services;

import java.util.Collections;
import java.util.List;

import enums.RoleEnum;
import models.Role;
import models.User;

public class LoginService {
	public static User sessionUser = new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345678", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase()));
	public static User sessionAdmin = new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "123456789", "Ivan", "Ivanov", new Role(RoleEnum.ADMIN.name().toLowerCase()));

	private static List<User> userDb = Collections.singletonList(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "123456789", "Ivan", "Ivanov"));

	public static String login(String username, String password) {

		if (username == null || password == null) {
			return "Въведете потребителско име и парола.";
		}
		boolean isUserExists = userDb.stream().anyMatch(
					u -> u.getUsername().equals(username) && 
					u.getPassword().equals(password)
				);
		

		return isUserExists ? "Успешно влизане." : "Грешно потребителско име или парола.";
	}

}