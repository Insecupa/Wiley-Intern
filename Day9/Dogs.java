package Day9;

import java.io.Serializable;

public class Dogs extends Animal implements Serializable {
    private int legs;
    private String gender;


    public Dogs(int legs, String gender) {
        super();
        this.setBreed("Q");
        this.setAnimalClass("B");
        this.legs = legs + 3;
        this.gender = gender + "Hello";
    }

    @Override
    public String toString() {
        return "{" + super.toString() + " Dogs{" +
                "legs=" + legs +
                ", gender='" + gender + '\'' +
                '}';
    }
}
