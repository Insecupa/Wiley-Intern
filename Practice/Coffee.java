//Enum example - related files - { Coffee.java, CoffeeDemo.java }

public enum Coffee {
	NESCAFE(5), LATTE(3), CAP(12), EXPRESSO(6), BLACK(15);
	int coffebeans;
	private Coffee(int coffeebeans) {
		this.coffebeans = coffeebeans;
	}
	
	public int getBeans() {
		return this.coffebeans;
	}
	
	public int calculateCost() {
		return this.coffebeans * 2;
	}
}
