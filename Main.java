
public class Main {
	
	//This file demonstrates the work done on 8 - Sep - 2022
	//This program shows the usage of methods, 
	//loops - { for, while, do while }, if-else, switch cases,
	//break and continue keywords
	
	
	//This method deals with if else and while loop
	public void numbers(int nums) {
		while(nums-- > 0) {
			if(nums % 2 == 0)
				System.out.println(nums + " = Even");
			else
				System.out.println(nums + " = Odd");
		}
	}
	
	//This method demonstrates the use of switch case 
	//and do while loop and break keyword	
	public void number(int nums) {
		do {
			int temp = nums % 2;
			switch(temp) {
			case 0:
				System.out.println(nums + " = Even");
				break;
			case 1:
				System.out.println(nums + " = Odd");
				break;
			default:
				System.out.println("Default case");
			}
		}while(nums-- > 0);
	}
	
	public void forContinue() {
		for(int i = 0; i < 20; i++) {
			if(i % 2 == 0) {
				System.out.println("Continued because even");
				continue;
			}
			
			System.out.println("Odd.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		System.out.println("First method: ");
		m.numbers(25);
		System.out.println("Second method: ");
		m.number(10);
		System.out.println("Third method");
		m.forContinue();
	}

}
