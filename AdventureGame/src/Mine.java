import java.util.Random;

public class Mine extends BattleLoc {
    static String award = generateRandomAward();
    public Mine(Player player) {
        super(6, player, "Maden", new Snake(),Mine.award,5 );

    }
    public static String generateRandomAward() {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1; // 1 ile 100 arasında rastgele bir değer üret

        if (randomValue <= 15) {
            // Silah kazanma ihtimali: 15%
            int weaponSubtype = random.nextInt(100) + 1;
            if (weaponSubtype <= 20) {
                return "Tüfek"; // Tüfek kazanma ihtimali: 20%
            } else if (weaponSubtype <= 50) {
                return "Kılıç"; // Kılıç kazanma ihtimali: 30%
            } else {
                return "Tabanca"; // Tabanca kazanma ihtimali: 50%
            }
        } else if (randomValue <= 130) {
            // Zırh kazanma ihtimali: 45%
            int armorSubtype = random.nextInt(100) + 1;
            if (armorSubtype <= 20) {
                return "Ağır Zırh"; // Ağır Zırh kazanma ihtimali: 20%
            } else if (armorSubtype <= 50) {
                return "Orta Zırh"; // Orta Zırh kazanma ihtimali: 30%
            } else {
                return "Hafif Zırh"; // Hafif Zırh kazanma ihtimali: 50%
            }
        } else if (randomValue <= 355) {
            // Para kazanma ihtimali: 25%
            int moneySubtype = random.nextInt(100) + 1;
            if (moneySubtype <= 20) {
                return "10"; // 10 Para kazanma ihtimali: 20%
            } else if (moneySubtype <= 50) {
                return "5"; // 5 Para kazanma ihtimali: 30%
            } else {
                return "1"; // 1 Para kazanma ihtimali: 50%
            }
        } else {
            return null; // Hiçbir şey kazanamama ihtimali: 45%
        }
    }
}
