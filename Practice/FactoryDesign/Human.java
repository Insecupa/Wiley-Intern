package FactoryDesign;

public abstract class Human {
	int age;
	
	abstract int getAge();
	
	void print() {
		System.out.println("age: " + getAge());
	}
}
