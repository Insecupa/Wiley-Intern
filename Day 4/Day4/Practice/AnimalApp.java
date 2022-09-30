//Inheritace Example - Related Files - [ Animal.java, Dog.java, AnimalApp.java }

public class AnimalApp {

//	public static void displayDog(Dog d) {
//	//...	
//	}
//	
//	public static void displayCat(Cat c) {
//		//...
//	}
	
	public static void printAnimal(Animal animal) {
		//...
		//Reduces multiple methods into one by taking ref as a input
		//But only methods in Animal works
		
		/*
		 * if(animal instanceof Dog)
		 * -> can run methods only in Dog. This enables to use subclass methods
		 */
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		printAnimal(dog);
		printAnimal(cat);
		
		//Throws Error
		//Animal animal = new Animal();
	}
}
