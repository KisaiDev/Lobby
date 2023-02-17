package fr.misteryy.lobby.commands;

import fr.misteryy.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YoutubeCommands implements CommandExecutor {
    private main main;

    public YoutubeCommands(){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("YoutubeCommands")){
                player.sendMessage("§d§lLobby §6» §fNotre youtube : ");
                return true;
            }
        }
        return false;
    }
}
