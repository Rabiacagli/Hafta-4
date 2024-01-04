import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen İsminizi Giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println();
        System.out.println("Sevgili " + player.getName() + " Bu Karanlık ve Issız Adaya Hoşgeldin !");
        System.out.println();
        System.out.println("Oyuna başlamak için bir karakter seçmelisin!");
        player.selectChar();

        Location location = null;
        while (true) {
            System.out.println();
            player.printInfo();
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("Gidebileceğiniz Bölgeler");
            System.out.println();
            System.out.println("1- Güvenli Ev --> Burası Sizin İçin Güvenli, Düşman Yok !");
            System.out.println("2- Dükkan \t  --> Silah veya zırh alabilirsiniz!");
            System.out.println("3- Mağara \t  --> Dikkatli ol zombi çıkabilir!!");
            System.out.println("4- Orman \t  --> Dikkatli ol vampir çıkabilir!!");
            System.out.println("5- Nehir \t  --> Dikkatli ol ayı çıkabilir!!");
            System.out.println("6- Maden \t  --> Dikkatli ol yılan çıkabilir!!");
            System.out.println("0- Çıkış");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest (player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location == null) {
                System.out.println();
                System.out.println("Bu karanlık ve ıssız adadan çabuk vazgeçtin :)");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}
