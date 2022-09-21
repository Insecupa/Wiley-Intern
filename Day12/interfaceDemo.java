package Day12;

public class interfaceDemo {


    public static void main(String[] args){
        Person p = new Person() {
            @Override
            public void talk() {
                System.out.println("Talking");
            }
        };
        p.talk();
        Person.live();
        p.breathe();
    }
}
