public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String[] awards; // String dizisi ekledik

    ;

    public Inventory() {
        this.weapon = new Weapon(-1, "Yumruk", 0, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.awards = new String[4]; //  maksimum 4 ödül saklamak için bir dizi oluşturduk
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String[] getAwards() {
        return awards;
    }

    // String ödül eklemek için bir metot
    public void addAward(String award) {
        // Aynı ödülün zaten mevcut olup olmadığını kontrol et
        if (!containsAward(award)) {
            for (int i = 0; i < awards.length; i++) {
                if (awards[i] == null) {
                    awards[i] = award;
                    System.out.println("Ödül eklendi: " + award);
                    break;
                }
            }
        } else {
            System.out.println("Bu ödül zaten mevcut. Eklenmedi.");
        }
    }

    // Verilen ödülün envanterde zaten bulunup bulunmadığını kontrol eden metot varsa eklemez
    private boolean containsAward(String award) {
        for (String existingAward : awards) {
            if (existingAward != null && existingAward.equals(award)) {
                return true;
            }
        }
        return false;
    }

}


