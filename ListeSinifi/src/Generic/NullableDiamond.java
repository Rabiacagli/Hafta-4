package Generic;

public class NullableDiamond <T>{
    private final T value;

    public NullableDiamond(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean isNull (){
        return this.getValue() == null;
    }

    public void run (){
        if (isNull()){
            System.out.println("Bu değişkene değer atanmamıştır");
        }else{
            System.out.println(this.getValue());
        }
    }
}
