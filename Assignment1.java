/*Create a class Circle with following details: 
Attributes: radius, area
Methods  : calculateArea
Create object of circle with given radius and calculate the area. 
(Use the concept of parameterized constructor, code recommendation and
this keyword)
*/
class Circle{
	double radius;
	double area;
	
	public Circle() {
		radius = 1;
		area = calculateArea();
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = calculateArea();
	}
	
	public double getArea() {
		return this.area;
	}
	
	private double calculateArea() {
		return Assignment1.PI * this.radius * this.radius;
	}
}

public class Assignment1 {
	final static double PI = 3.1415926;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle1 = new Circle(2.5);
		Circle circle2 = new Circle();
		
		System.out.println(circle1.getArea());
		System.out.println(circle2.getArea());
	}

}
