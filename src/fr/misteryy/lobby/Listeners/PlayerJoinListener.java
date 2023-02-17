package fr.misteryy.lobby.Listeners;

import fr.misteryy.lobby.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PlayerJoinListener implements Listener {
    public PlayerJoinListener() {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (!ScoreboardManager.scoreboardGame.containsKey(player)) {
            new ScoreboardManager(player).loadScoreboard();
        }
        player.setHealth(20);
        player.setFoodLevel(20);
        e.setJoinMessage("§a» " + player.getName());
        player.teleport(new Location(Bukkit.getWorld("world"), 216, 64, 85));
        player.playSound(player.getLocation(), Sound.ORB_PICKUP,1,1);
        player.sendMessage("§8");
        player.sendMessage(" §l» Bienvenue sur §d§lLobby §f!");
        player.sendMessage(" §l• ...");
        player.sendMessage("§f");
        player.sendMessage(" §l| §fDiscord : " );
        player.sendMessage(" §l| §fTwitter : ");
        player.sendMessage(" §l| §fYoutube : ");
        player.sendMessage("§l");
        player.setWalkSpeed(0.35F);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,1000000000,255, true));
        player.setNoDamageTicks(Integer.MAX_VALUE);
        player.getInventory().clear();
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        e.setQuitMessage("§c« §7 " + player.getName());
    }

}
