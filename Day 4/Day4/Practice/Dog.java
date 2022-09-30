//Inheritance Example - Related Files - [ Animal.java, Dog.java, AnimalApp.java }

//Polymorphic Reference	
//superclass ref = new subclass() - Polymorphic Ref
//Polymorphic Ref is used to make sure that the subclass 
//is restricted to run methods that are present in the superclass.
//This restricts the subclass from running its own their methods.
//Is also called as - Dynamic Method Disptach

// Downcasting - ((Dog) animal).trainMe();


public class Dog extends Animal{

	Dog(){
		super();
	}
	//Method overriding
	public void talk() {
		System.out.println("Dog is barking");
	}
	
}
