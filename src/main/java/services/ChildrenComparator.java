package services;

import java.util.Comparator;
import java.util.Random;

import models.Child;

public class ChildrenComparator implements Comparator<Child> {
	private Random random = new Random();
	
	@Override
	public int compare(Child o1, Child o2) {
			return o1.getPoints() > o2.getPoints()
					? -1 
					: o1.getPoints() < o2.getPoints()
						? 1 
						: random.nextBoolean() 
							? 1 
						    : -1;
	}
}
