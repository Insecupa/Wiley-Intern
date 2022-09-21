package Day11;

class Obj<T>{
    T data;
    Obj next;

    public Obj(T data){
        this.data = data;
        next = null;
    }
}
public class GenericList{
    Obj head;

    public GenericList(){

    }
    public static void main(String[] args) {
        GenericList gen = new GenericList();
        gen.head = new Obj<String>("Hello");


    }
}
