package fr.misteryy.lobby;

import fr.misteryy.lobby.Listeners.PlayerJoinListener;
import fr.misteryy.lobby.Listeners.Weather;
import fr.misteryy.lobby.Listeners.menu;
import fr.misteryy.lobby.commands.*;
import fr.misteryy.lobby.utils.Title;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
        private static main instance;
        public Title title = new Title();
        @Override
        public void onEnable() {
            getCommand("discordcommands").setExecutor(new DiscordCommands(this));
            getCommand("spawn").setExecutor(new CommandSpawn());
            getCommand("twittercommands").setExecutor(new TwitterCommands());
            getCommand("Youtubecommands").setExecutor(new YoutubeCommands());
            getCommand("DocCommands").setExecutor(new DocCommands());
            getCommand("stafflist").setExecutor(new stafflist(this));
            getCommand("fly").setExecutor(new Fly(this));
            getCommand("unfly").setExecutor(new Fly(this));
            getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
            getServer().getPluginManager().registerEvents(new menu(),this);
            getServer().getPluginManager().registerEvents(new Weather(), this);
            Runnable runnable = new Runnable();
            runnable.runTaskTimer(this, 0,20);
        }

        @Override
        public void onDisable() {
        }
        public static main getInstance(){
            return instance;
        }
    }
