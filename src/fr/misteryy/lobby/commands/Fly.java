package fr.misteryy.lobby.commands;

import fr.misteryy.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Fly implements CommandExecutor {
    private main main;
    public Fly(main main){
        this.main = main;
    }
    public static HashMap<Player, Boolean > flyb = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(cmd.getName().equalsIgnoreCase("fly")){
                player.sendMessage("§a§lVous venez d'activer le fly");
                player.setAllowFlight(true);
                flyb.put(player , true);
                return true;
            }
            if(cmd.getName().equalsIgnoreCase("unfly")){
                player.sendMessage("§4§lVous venez de désactiver le fly");
                player.setAllowFlight(false);
                flyb.put(player, false);
            }
        }
        return false;
    }
}
