package fr.misteryy.lobby.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {
    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(e.toWeatherState());
    }
    @EventHandler
    public void P(AsyncPlayerChatEvent e){
        e.setFormat("§7 " + e.getPlayer().getName() + " " +  e.getMessage());
    }
}
