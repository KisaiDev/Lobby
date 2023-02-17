package fr.misteryy.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location spawn = new Location(Bukkit.getWorld("world"), 216, 64, 85);
            player.sendMessage("§cVous venez d'etre téléporté au spawn");
            player.teleport(spawn);
            player.playSound(player.getLocation(), Sound.ORB_PICKUP,1,1);
        }
        return false;
    }
}