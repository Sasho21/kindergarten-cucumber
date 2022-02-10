package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import enums.ChildStatusEnum;
import enums.RoleEnum;
import models.Child;
import models.ChildStatus;
import models.Role;
import models.User;

public class PlacementService {
	
	private static List<Child> childrenDb = new ArrayList<>();
	private static List<Child> rankingDb = new ArrayList<>();
	private static Random random = new Random();
	
	public static String registerChild(
				final String first_name, final String last_name, final String date_of_birth, final boolean is_disabled,
				final int working_parents, final boolean has_twin
			) {
		initDb();
		
		if (first_name.isEmpty() || last_name.isEmpty()) {
			return "Моля въведете и двете имена на детето.";
		}
		
		if (!isDateValid(date_of_birth)) {
			return "Детето ви е твърде малко или твърде голямо за детска градина.";
		}

		Child newChild =  new Child(first_name, last_name, date_of_birth, is_disabled, working_parents, has_twin, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()));
		
		if (childrenDb.stream().anyMatch(ch -> ch.getFirstName().equals(newChild.getFirstName()) &&
				   ch.getLastName().equals(newChild.getLastName()) &&
				   ch.getDateOfBirth().equals(newChild.getDateOfBirth()) &&
				   ch.getIsDisabled() == newChild.getIsDisabled() &&
				   ch.getWorkingParents() == newChild.getWorkingParents() &&
				   ch.getHasTwin() == newChild.getHasTwin()
				   )) {
			Set<Child> children = new HashSet<Child>();
			if (null != LoginService.sessionUser.getChildren()) {
				children.addAll(LoginService.sessionUser.getChildren());
			}
			children.add(newChild);
			LoginService.sessionUser.setChildren(children);
			
			return "Детето ви е вече регистрирано.";
		}
		
		if (RoleEnum.PARENT.name() == LoginService.sessionUser.getRole().getCode()) {
			Set<User> parent = new HashSet<User>();
			parent.add(LoginService.sessionUser);
			newChild.setParent(parent);
		}
		
		
		newChild.setPoints(calculatePoints(newChild));
		childrenDb.add(newChild);
		
		return "Успешно регистриране, вашето дете има " + newChild.getPoints() + " точки.";
	}
	
	public static String registerChild(
			final String first_name, final String last_name, final String date_of_birth, final boolean is_disabled,
			final int working_parents, final boolean has_twin, final String parent_phone
		) {
		if (RoleEnum.ADMIN.name().equals(LoginService.sessionAdmin.getRole().getCode())) {
			return "Нямате достъп до тази опреация.";
		}
		
	initDb();
	RegisterService.initDb();
	
	if (first_name.isEmpty() || last_name.isEmpty()) {
		return "Моля въведете и двете имена на детето.";
	}
	
	if (!isDateValid(date_of_birth)) {
		return "Детето е твърде малко или твърде голямо за детска градина.";
	}
	
	if (!RegisterService.isPhoneValid(parent_phone)) {
		return "Телефонът на родителя не е валиден.";
	}
	
	User parent = RegisterService.usersDb.stream().filter(u -> u.getPhone().equals(parent_phone)).findAny().orElse(null);
	
	if (null == parent) {
		return "Не съществува такъв родител.";
	}
	
	Set<User> parentRelation = new HashSet<User>();
	parentRelation.add(parent);

	Child newChild =  new Child(first_name, last_name, date_of_birth, is_disabled, working_parents, has_twin, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parentRelation);
	
	if (childrenDb.stream().anyMatch(ch -> ch.getFirstName().equals(newChild.getFirstName()) &&
			   ch.getLastName().equals(newChild.getLastName()) &&
			   ch.getDateOfBirth().equals(newChild.getDateOfBirth()) &&
			   ch.getIsDisabled() == newChild.getIsDisabled() &&
			   ch.getWorkingParents() == newChild.getWorkingParents() &&
			   ch.getHasTwin() == newChild.getHasTwin()
			   )) {
		return "Детето е вече регистрирано.";
	}
	
	
	newChild.setPoints(calculatePoints(newChild));
	childrenDb.add(newChild);
	
	return "Успешно регистриране, детето има " + newChild.getPoints() + " точки.";
}
	
	public static void calculateRanking() {
		initRankingDb();
		
		Collections.shuffle(rankingDb);
		
		Collections.sort(rankingDb, new ChildrenComparator());
		
		for (int i = 0; i < rankingDb.size(); i++) {
			rankingDb.get(i).setPosition(i+1);
		}
	}
	
	public static List<Integer> showChildRanking() {
		var messageWrapper = new Object() {List<Integer> positions = new ArrayList<Integer>();};
		
		rankingDb.stream().filter(ch -> ch.getParents().stream().anyMatch(u -> u.getPhone().equals(LoginService.sessionUser.getPhone()))).forEachOrdered(ch -> {
			messageWrapper.positions.add(ch.getPosition());
		});
		
		return messageWrapper.positions;
	}
	
	public static List<Integer> showChildRanking(String phone) {
		calculateRanking();
		
		var messageWrapper = new Object() {List<Integer> positions = new ArrayList<Integer>();};
		
		rankingDb.stream().filter(ch -> ch.getParents().stream().anyMatch(u -> u.getPhone().equals(phone))).forEachOrdered(ch -> {
			messageWrapper.positions.add(ch.getPosition());
		});
		
		return messageWrapper.positions;
	}
	
	private static void initDb() {
		childrenDb.clear();
		childrenDb.add(new Child("Ivancho", "Ivanov", "2018-04-12", false, 2, false, 5, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho3", "Ivanov3", "2019-04-12", false, 2, false, 2, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho4", "Ivanov4", "2016-04-12", false, 2, false, 3, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho5", "Ivanov5", "2020-01-12", false, 2, false, 4, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho6", "Ivanov6", "2018-04-12", false, 2, false, 4, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho7", "Ivanov7", "2018-04-12", false, 2, false, 3, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase())));
		childrenDb.add(new Child("Ivancho2", "Ivanov2", "2017-04-12", true, 1, false, 3, new ChildStatus(ChildStatusEnum.ACCEPTED.name().toLowerCase())));
	}
	
	private static void initRankingDb() {
		rankingDb.clear();
		
		Set<User> parents = new HashSet<User>();
		parents.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345678", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents1 = new HashSet<User>();
		parents1.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345671", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents2 = new HashSet<User>();
		parents2.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345672", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents3 = new HashSet<User>();
		parents3.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345673", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents4 = new HashSet<User>();
		parents4.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345674", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents5 = new HashSet<User>();
		parents5.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345675", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		Set<User> parents6 = new HashSet<User>();
		parents6.add(new User("Ivan1", "Pass123!", "iIvanov1@abv.bg", "0892345676", "Ivan", "Ivanov", new Role(RoleEnum.PARENT.name().toLowerCase())));
		
		rankingDb.add(new Child("Ivancho", "Ivanov", "2018-04-12", false, 2, false, 5, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents));
		rankingDb.add(new Child("Ivancho3", "Ivanov3", "2019-04-12", false, 2, false, 3, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents2));
		rankingDb.add(new Child("Ivancho4", "Ivanov4", "2016-04-12", false, 2, false, 3, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents2));
		rankingDb.add(new Child("Ivancho5", "Ivanov5", "2020-01-12", false, 2, false, 4, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents4));
		rankingDb.add(new Child("Ivancho6", "Ivanov6", "2018-04-12", false, 2, false, 4, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents4));
		rankingDb.add(new Child("Ivancho7", "Ivanov7", "2018-04-12", false, 2, false, 3, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents2));
		rankingDb.add(new Child("Ivancho2", "Ivanov2", "2017-04-12", true, 1, false, 1, new ChildStatus(ChildStatusEnum.PENDING.name().toLowerCase()), parents1));
	}
	
	private static int calculatePoints(Child child) {
		int points = 0;
		
		if (child.getIsDisabled()) {
			points += 2;
		}
		points += child.getWorkingParents();
		
		var siblingWrapper = new Object() {boolean has_sibling = false;};
		child.getParents().forEach(u -> {
			if (!siblingWrapper.has_sibling && u.getChildren().stream().anyMatch(ch -> ch.getStatus().getStatus().equals(ChildStatusEnum.ACCEPTED.name().toLowerCase()))) {
				siblingWrapper.has_sibling = true;
			}
		});
		
		points += siblingWrapper.has_sibling ? 1 : 0;
		
		points += child.getHasTwin() ? 1 : 0;
		
		return points;
	}
	
	private static boolean isDateValid(String date_of_birth) {
		try {
			Calendar inputYear = Calendar.getInstance();
			Date inputDate = new SimpleDateFormat("yyyy-MM-dd").parse(date_of_birth);
			inputYear.setTime(inputDate);
			Calendar minimalYear = Calendar.getInstance();
			minimalYear.setTime(new Date());
			minimalYear.add(Calendar.YEAR, -6);
			
			int childAge = inputYear.get(Calendar.YEAR) - minimalYear.get(Calendar.YEAR);
			
			return childAge >= 0 && childAge < 5;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
