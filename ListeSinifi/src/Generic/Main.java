package Generic;

public class Main {
    public static void main(String[] args) {
       /*//Undefined
        String s;
      // null
        String s1 = null;

        // empty
        String s2 = " "; */

        //Nullable sınıfına ait run metodu
       /* String str  = null; // "123554"
        Nullable n = new Nullable(str);
        n.run();*/


        // NullableDiamond sınıfına ait run metodu

     /*   NullableDiamond <Integer> r = new NullableDiamond<>(null); // veya değer herhangi bir ınt sayı
        r.run(); */



        // TEST SINIFI

        Integer a = 10;
        String b = "777";
        Double c = 3.14;

        Test <Integer,String,Double> t = new Test<>(a,b,c);
        t.showInfo();

    }

}
