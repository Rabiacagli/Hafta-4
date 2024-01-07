import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cümle giriniz:");
        String cumle = scanner.nextLine();

        String buyukHarfliCumle = buyukHarfYap(cumle);
        System.out.println("Baş harfleri büyük yazılmış cümle: " + buyukHarfliCumle);
    }

    static String buyukHarfYap(String cumle) {
        String[] kelimeler = cumle.split(" ");
        StringBuilder buyukHarfliCumle = new StringBuilder();

        for (String kelime : kelimeler) {
            if (!kelime.isEmpty()) {
                buyukHarfliCumle.append(Character.toUpperCase(kelime.charAt(0)))
                        .append(kelime.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return buyukHarfliCumle.toString().trim();
    }
}