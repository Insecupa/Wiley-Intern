//Enum example - related files - { Coffee.java, CoffeeDemo.java }

public class CoffeeDemo {
	public static void main(String[] args) {
		//Enum values
		Coffee[] coffee = Coffee.values();
		for(Coffee co : coffee) {
			System.out.println("Coffee is: " + co + ", and the beans required are: " + co.getBeans() + ". The total cost of the coffee is: " + co.calculateCost() + "$");
		}
		
		//Enum valueOf
		String coffeeName = "CAP";
		Coffee coffee2 = Coffee.valueOf(coffeeName);
		System.out.println(coffee2);
		
		//Enum ordinal
		for(Coffee co : coffee) {
			int i = co.ordinal() + 1;
			System.out.println(i + " " + co);
		}
	}
}
