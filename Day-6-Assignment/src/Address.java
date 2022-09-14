//Assignment 9

//Attributes of address class: flatNumber, flatName, roadName, cityName.
public class Address {
	private int flatNumber;
	private String flatName;
	private String roadName;
	private String cityName;
	
	public Address(int flatNumber, String flatName, String roadName, String cityName) {
		this.flatNumber = flatNumber;
		this.flatName = flatName;
		this.roadName = roadName;
		this.cityName = cityName;
	}
	
	@Override
	public String toString() {
		return "Flat No: " + this.flatNumber + "\nFlat Name: " + this.flatName 
				+ "\nRoad Number/Name: " + this.roadName + "\nCity Name: " + this.cityName;
	}
}
