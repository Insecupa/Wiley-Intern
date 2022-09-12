package FactoryDesign;
/*
 * When to use Factory Design Pattern ?
1. When it is unknown what type of class is needed at runtime
2. When all potential classes are in the same subclass hierarchy
3. To centralize the class selection code
4. To Encapsulate object creation
 */
public class Main {
	public static void main(String[] args) {
		String sample = "Child";
		HumanFactory humanFactory = new HumanFactory();
		Human ans = humanFactory.createHuman(sample);
		ans.print();
	}
}
