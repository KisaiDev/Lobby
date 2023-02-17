package fr.misteryy.lobby.utils;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class HeadsMain {
    public HeadsMain() {
    }
    public static ItemStack createSkull(String url, String name){
        ItemStack head = new ItemStack(Material.SKULL_ITEM,1,(short) 3);
        if(url.isEmpty()){
            return head;
        } else {
            SkullMeta headMeta = (SkullMeta) head.getItemMeta();
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String) null);
            profile.getProperties().put("textures", new Property("textures", url));

            try {
                Field profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
                profileField.set(headMeta, profile);
            } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException var6){
                var6.printStackTrace();
            }
            return head;
        }
    }
    public static ItemStack getHead(String name){
        Heads[] var4;
        int var3 = (var4 = Heads.values()).length;

        for (int var2 = 0; var2 < var3; ++var2){
            Heads head = var4[var2];
            if(head.getName().equals(name)){
                return head.getItemStack();
            }
        }
        return null;
    }

}