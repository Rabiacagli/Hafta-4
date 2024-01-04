public class GameControl {

    public void checkAndEndGame(Player player) {
        if (allAwardsObtained(player)) {
            endGame();
        }
    }

    private boolean allAwardsObtained(Player player) {
        for (String award : player.getInventory().getAwards()) {
            if (award == null) {
                return false;
            }
        }
        return true;
    }

    private void endGame() {
        System.out.println("Tebrikler! Tüm ödülleri aldınız. Oyun Bitti!");

        System.exit(0);
    }
}