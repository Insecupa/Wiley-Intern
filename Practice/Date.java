//Classes - Composition Example?? - related Files - { Student.java, Date.java }

public class Date {
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
	
	public String displayDate() {
		return "The Date is: " + this.dd + " - " + this.mm + " - " + this.yy;
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
	
	public Boolean checkDate() {
		
		if(this.yy > 9999 || this.yy < 0) 
			return false;
		
		
		if(this.mm > 12 || this.mm < 1)
			return false;
		
		if(this.dd < 1 || this.dd > 31)
			return false;
		
		if(this.mm != 6 && this.mm % 2 == 0 && this.dd == 31) 
			return false;
		
		if(checkLeapYear(this.yy))
			if(this.mm == 2 && this.dd > 29)
				return false;
		
		if(this.mm == 2 && this.dd > 28)
			return false;
		
		return true;
	}
}

