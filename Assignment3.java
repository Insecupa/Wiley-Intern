/*
 * Create a class Date with following details:
Attributes : dd,mm,yy
Methods: displayDate(), checkDate()
(Use the concept of parameterized constructor, code recommendation and
this keyword
 */

class Date {
	int dd;
	int mm;
	int yy;
	
	public Date() {
		dd = 1;
		mm = 1;
		yy = 0001;
	}
	
	public Date(int dd, int mm, int yy) {
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}
	
	public void displayDate() {
		System.out.println("The Date is: " + this.dd + " - " + this.mm + " - " + this.yy);
	}
	
	private boolean checkLeapYear(int year) {
	    if (year % 400 == 0)
	        return true;
	 
	    if (year % 100 == 0)
	        return false;
	 
	    if (year % 4 == 0)
	        return true;
	    
	    return false;		
	}
	
	public String checkDate() {
		String no = "NOT VALID";
		String yes = "VALID";
		
		if(this.yy > 9999 || this.yy < 0) 
			return no;
		
		
		if(this.mm > 12 || this.mm < 1)
			return no;
		
		if(this.dd < 1 || this.dd > 31)
			return no;
		
		if(this.mm != 6 && this.mm % 2 == 0 && this.dd == 31) 
			return no;
		
		if(checkLeapYear(this.yy))
			if(this.mm == 2 && this.dd > 29)
				return no;
		
		if(this.mm == 2 && this.dd > 28)
			return no;
		
		return yes;
	}
}
public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1 = new Date(32, 12, 1995);
		Date date2 = new Date();
		date1.displayDate();
		System.out.println(date1.checkDate());
		date2.displayDate();
		System.out.println(date2.checkDate());

	}

}
