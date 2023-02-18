package fr.misteryy.lobby.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ScoreboardManager {
    public Player player;
    public ScoreboardSign sign;
    public static Map<Player, ScoreboardSign> scoreboardGame = new HashMap<>();

    public ScoreboardManager(Player player) {
        player = player;
        sign = new ScoreboardSign(player, player.getName());
        scoreboardGame.put(player, this.sign);

    }

    public void loadScoreboard() {
        for(Player player : Bukkit.getOnlinePlayers()){
            sign.setObjectiveName("§6» §d§lLOBBY§6 «");
            sign.create();

            ((ScoreboardSign)scoreboardGame.get(player)).setLine(12, "§f§l" + player.getName());
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(11, "§8» §7Grade : ");
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(10, "§8» §7Fly : " + player.isFlying());
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(9, "§1");
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(8, "§f§lServeur §f");
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(7, "§8» §7Joueurs : " + " §b"+ Bukkit.getOnlinePlayers().size());
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(6, "§8» §7Horaire :");
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(5, "§f");
            ((ScoreboardSign)scoreboardGame.get(player)).setLine(4, "§ddsc.gg/");
        }
    }
}
