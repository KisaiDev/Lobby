package fr.misteryy.lobby.commands;

import fr.misteryy.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stafflist implements CommandExecutor {
    private main main;
    public stafflist(main main){
        this.main = main;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("stafflist")){
                StringBuilder stringBuilder = new StringBuilder();
                for(OfflinePlayer offlinePlayer : Bukkit.getServer().getOperators()){
                    stringBuilder.append(offlinePlayer.getName() + " ");
                }
                player.sendMessage("§d§lLobby §6» §f" + stringBuilder);
            }
        }
        return false;
    }
}
