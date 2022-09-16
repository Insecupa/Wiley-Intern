package Day9;

import java.io.Serializable;

public class Animal {
    private String breed;
    private String animalClass;

    public Animal() {
//        System.out.println("In Animal");
        this.breed = "X";
        this.animalClass = "Y";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "breed='" + breed + '\'' +
                ", animalClass='" + animalClass + '\'' +
                '}';
    }

    public void setBreed(String s) {
        breed = s;
    }

    public void setAnimalClass(String a) {
        animalClass = a;
    }
}
