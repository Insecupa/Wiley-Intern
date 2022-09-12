package FactoryDesign;

class HumanFactory {
	public Human createHuman(String category) {
		if(category == null || category.isEmpty())
			return null;
		switch(category) {
		case "Child":
			return new Child();
		case "Adult":
			return new Adult();
		case "GrandParent":
			return new GrandParent();
		}
		
		return null;
	}
}