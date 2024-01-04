import java.util.Arrays;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private GameControl gameControl;


    public BattleLoc(int id, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(id, player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.gameControl = new GameControl();
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println();
        System.out.println("Şu an Buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada "  + this.getObstacle().getName() + " yaşıyor!");
        System.out.println();
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine().toUpperCase();


        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " tüm düşmaları yendin!");
            System.out.println(this.getAward() + " ödülünü kazandınız");

            if (this.getAward().equals("1")) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());

            } else if (this.getAward().equals("5")) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());

            } else if (this.getAward().equals("10")) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());

            } else{

                this.getPlayer().getInventory().addAward(this.getAward());
                System.out.println("Ödüller: " + Arrays.toString(this.getPlayer().getInventory().getAwards()));
                this.gameControl.checkAndEndGame(this.getPlayer());
            }
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz! :(");
            return false;
        }
        return true;
    }


    public Boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            System.out.println("--------------");
            playerStats();
            System.out.println("--------------");
            obstacleStats(i);

            boolean playerAttacksFirst = new Random().nextBoolean(); // 50% chance

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println(" <V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();

                if ((playerAttacksFirst && selectCombat.equals("V")) || (!playerAttacksFirst && selectCombat.equals("K"))) {
                    // Player attacks
                    System.out.println("Siz Vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();

                    if (this.getObstacle().getHealth() > 0) {
                        // Obstacle counterattacks
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    // Obstacle attacks
                    System.out.println("Canavar size vurdu!");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();

                    if (this.getPlayer().getHealth() > 0) {
                        // Player counterattacks
                        System.out.println("Siz Vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                // Player wins
                System.out.println("Düşmanı Yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());

            } else {
                // Obstacle wins
                return false;
            }

        }

        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Paramız: " + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i) {
        System.out.println();
        System.out.println(i + ". " + this.getObstacle().getName() + "'nın Değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public String setAward(String award) {
        this.award = award;
        return award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
