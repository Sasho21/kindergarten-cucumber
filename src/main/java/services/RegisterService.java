package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.ChildStatusEnum;
import enums.RoleEnum;
import models.Child;
import models.ChildStatus;
import models.Role;
import models.User;

public class RegisterService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
				"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE
			);
	public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])");
	public static final Pattern VALID_PHONE_REGEX = Pattern.compile("^08(8|9)\\d{7}$");
	
	public static List<User> usersDb = new ArrayList<>();

	public static String register(
				final String username, final String password, final String confirmPassword,
				final String email, final String phone, final String first_name, final String last_name
			) {

		initDb();

		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return "Въведете парола.";
		}
		
		if (password.length() < 4) {
			return "Въведете парола с поне четери знака.";
		}
		
		if (!isPasswordValid(password)) {
			return "Паролата трябва да съдържа поне една главна буква, малка буква и цифра.";
		}

		final boolean isUsernameExists = usersDb.stream().anyMatch(u -> u.getUsername().equals(username));
		if (isUsernameExists) {
			return "Потребителското име е заето.";
		}
		final boolean isEmailExists = usersDb.stream().anyMatch(u -> u.getEmail().equals(email));
		if (isEmailExists) {
			return "Има регистриран потребител с тази поща.";
		}
		
		final boolean isPhoneExists = usersDb.stream().anyMatch(u -> u.getPhone().equals(phone));
		if (isPhoneExists) {
			return "Има регистриран потребител с този телефонен номер.";
		}

		if (email.isEmpty()) {
			return "Въведете електронна поща.";
		}
		if (username.isEmpty()) {
			return "Въведете потребитеско име.";
		}
		
		if(!password.equals(confirmPassword)) {
			return "Въведете еднакви пароли.";
		}

		if (!isEmailValid(email)) {

			return "Въведете валидна електронна поща.";
		}
		if (username.length() < 3) {
			return "Въведете име с поне три знака.";
		}
		if (!isPhoneValid(phone)) {
			return "Въведете валиден телефонен номер.";
		}

		final User newUser = new User(username, password, email, phone, first_name, last_name);
		usersDb.add(newUser);
		return "Регистрирахте се успешно.";
	}

	public static void initDb() {
		usersDb.clear();
		Set<Child> children = new HashSet<Child>();
		children.add(new Child("Ivancho2", "Ivanov2", "2017-04-12", true, 1, false, 3, new ChildStatus(ChildStatusEnum.ACCEPTED.name().toLowerCase())));
		usersDb.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345678", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase()), children));
		usersDb.add(new User("Ivan2", "Pass123!", "iIvanov2@abv.bg", "0887654321", "Ivan", "Ivanov"));
	}

	public static boolean isEmailValid(final String emailStr) {
		final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	public static boolean isPasswordValid(final String passwordStr) {
		final Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordStr);
		return matcher.find();
	}
	
	public static boolean isPhoneValid(final String phoneStr) {
		final Matcher matcher = VALID_PHONE_REGEX.matcher(phoneStr);
		return matcher.find();
	}	
}