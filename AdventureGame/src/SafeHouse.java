public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(1,player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz");
        System.out.println("Canınız Yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());

        return true;

    }
}
