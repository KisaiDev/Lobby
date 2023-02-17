package fr.misteryy.lobby;

import fr.misteryy.lobby.commands.Fly;
import fr.misteryy.lobby.scoreboard.ScoreboardManager;
import fr.misteryy.lobby.scoreboard.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

public class Runnable extends BukkitRunnable {

    @Override
    public void run() {
    for(Player player : Bukkit.getOnlinePlayers()){
       if(ScoreboardManager.scoreboardGame.get(player )!= null){
           ScoreboardSign scoreboard = ScoreboardManager.scoreboardGame.get(player);
           scoreboard.setLine(12, "§f§l" + player.getName());
           scoreboard.setLine(11, "§8» §7Grade : ");
           scoreboard.setLine(10, "§8» §7Fly : " + isFly(player));
           scoreboard.setLine(9, "§1");
           scoreboard.setLine(8, "§f§lServeur §f");
           scoreboard.setLine(7, "§8» §7Joueurs : " + " §b"+ Bukkit.getOnlinePlayers().size());
           scoreboard.setLine(6, "§8» §7Horaire :");
           scoreboard.setLine(5, "§f");
           scoreboard.setLine(4, "§ddsc.gg/");
       }

    }
    }
    public String isFly(Player player){
        if(Fly.flyb.get(player) != null){
            return Fly.flyb.get(player) ? "§a§l✔" : "§c§l✖";
        }
        return "§c§l✖";
    }
}
