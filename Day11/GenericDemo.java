package Day11;

public class GenericDemo<T>{
    T data;
    public GenericDemo(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
