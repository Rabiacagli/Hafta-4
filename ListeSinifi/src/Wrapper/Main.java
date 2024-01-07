package Wrapper;

public class Main {
    public static void main(String[] args) {
        /*int a = 20;
        Integer b = 20;

        System.out.println(a+b); */

       /* Integer a = 20;
        String str = a.toString();
        System.out.println(str);*/

        String a = "10";
        int b = 30 ;
        int c = Integer.parseInt(a);  // String i ınteger'a cevirir
        System.out.println(b+c);

        System.out.println(Integer.max(20,30));  // max'ı bulur

        System.out.println(Integer.sum(30,40)); // toplamı verir
    }
}
