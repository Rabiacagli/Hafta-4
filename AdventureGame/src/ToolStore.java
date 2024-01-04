public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(2, player, "Dükkan");
    }

    @Override
    public boolean onLocation() {

        System.out.println();
        System.out.println("----- Dükkana Hoşgeldiniz! ------");
        System.out.println();

        boolean showMenu = true;
        while (showMenu) {

            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("0 - Çıkış Yap");
            System.out.println();
            System.out.print("Seçiminiz: ");
            int selectCase = Location.input.nextInt();

            while (selectCase < 0 || selectCase > 2) {
                System.out.println("Geçersiz değer,tekrar giriniz : ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;

                case 2:
                    printArmor();
                    buyArmor();
                    break;

                case 0:
                    System.out.println("Tekrar Bekleriz");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println();
        System.out.println("----- Silahlar -----");
        System.out.println();

        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + " " + w.getName() + " < Para : " + w.getPrice() + ", Hasar : " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
        System.out.println();
    }

    public void buyWeapon() {

        System.out.print("Silahınızı Seçiniz: ");
        int selectWeaponId = input.nextInt();

        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Geçersiz değer,tekrar giriniz : ");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);

            if (selectedWeapon != null) {

                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız bulunmamaktadır !");

                } else {
                    System.out.println();
                    System.out.println(selectedWeapon.getName() + " satın aldınız");

                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor() {
        System.out.println();
        System.out.println("----- Zırhlar -----");
        System.out.println();

        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getId() + " " + a.getName() + " < Para : " + a.getPrice() + ", Zırh Değeri : " + a.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
        System.out.println();
    }

    public void buyArmor() {

        System.out.print("Zırhınızı Seçiniz: ");
        int selectArmorId = input.nextInt();

        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Geçersiz değer,tekrar giriniz : ");
            selectArmorId = input.nextInt();
        }
        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);

            if (selectedArmor != null) {

                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız bulunmamaktadır !");
                    System.out.println();

                } else {
                    System.out.println();
                    System.out.println(selectedArmor.getName() + " zırh satın aldınız");

                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}

