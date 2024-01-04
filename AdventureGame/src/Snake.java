import java.util.Random;

public class Snake extends Obstacle{
    private int damage;
    public Snake() {
        super(4, "Yılan", 0, 12, 0);
        this.damage = generateRandomDamage();
        super.setDamage(this.damage); // super class'ın damage değerini güncelledim
    }

    private int generateRandomDamage() {
        Random random = new Random();
        return random.nextInt(4) + 3; // 3 ile 6 arasında rastgele hasar ürettim
    }
}









