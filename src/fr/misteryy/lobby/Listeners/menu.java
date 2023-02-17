package fr.misteryy.lobby.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.block.Action;

public class menu implements Listener {
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";


    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem()!= null){
            Player player = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()){
                case STAINED_GLASS_PANE:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§f")){
                        e.setCancelled(true);
                    }
                    break;
                case FEATHER:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6▸ §a§lJump")){
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case GOLDEN_APPLE:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6▸ §e§lUHC")){
                        e.setCancelled(true);
                        Inventory INV = Bukkit.createInventory((InventoryHolder) null,45, "§d§lNAVIGATION §8-> §e§lUHC");
                        INV.setItem(36, this.getPaneItem((byte)6));
                        INV.setItem(18, this.getPaneItem((byte)6));
                        INV.setItem(26, this.getPaneItem((byte)6));
                        INV.setItem(27, this.getPaneItem((byte)6));
                        INV.setItem(17, this.getPaneItem((byte)6));
                        for(int i = 0; i < 10; i++){
                            INV.setItem(i, this.getPaneItem((byte)6));
                        }
                        for(int i = 35; i < 45; i++){
                            INV.setItem(i, this.getPaneItem((byte)6));
                        }
                        ItemStack skull = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
                        SkullMeta meta = (SkullMeta)skull.getItemMeta();
                        meta.setOwner("Minty_Fresh123");
                        meta.setDisplayName("§8§l▪ §f§l§kOOOOO§f§l UHC");
                        skull.setItemMeta(meta);
                        INV.setItem(20, skull);
                        player.openInventory(INV);
                    }
            }
        }
    }
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getInventory().clear();
        ItemStack Itemlobby1 = new ItemStack(Material.COMPASS);
        ItemMeta ItemsLobby = Itemlobby1.getItemMeta();
        ItemsLobby.setDisplayName("§8§l▪ §d§lNavigation");
        ItemsLobby.addEnchant(Enchantment.LURE, 1, true);
        ItemsLobby.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        Itemlobby1.setItemMeta(ItemsLobby);
        player.getInventory().setItem(4, Itemlobby1);
        player.updateInventory();
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
    }
    @EventHandler
    public void OnInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();
        if (it != null && it.getType() != null && action != null && it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§8§l▪ §d§lNavigation")){
            e.setCancelled(true);
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                Inventory INV = Bukkit.createInventory((InventoryHolder) null,45,"§d§lNAVIGATION");
                INV.setItem(36, this.getPaneItem((byte)6));
                INV.setItem(18, this.getPaneItem((byte)6));
                INV.setItem(26, this.getPaneItem((byte)6));
                INV.setItem(27, this.getPaneItem((byte)6));
                INV.setItem(17, this.getPaneItem((byte)6));
                for(int i = 0; i < 10; i++){
                    INV.setItem(i, this.getPaneItem((byte)6));
                }
                for(int i = 35; i < 45; i++){
                    INV.setItem(i, this.getPaneItem((byte)6));
                }

                ItemStack ItemMenu1 = new ItemStack(Material.FEATHER);
                ItemMeta ItemsMenu1 = ItemMenu1.getItemMeta();
                ItemsMenu1.setDisplayName("§6▸ §a§lJUMP");
                ItemsMenu1.addEnchant(Enchantment.LURE,1,true);
                ItemsMenu1.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                ItemMenu1.setItemMeta(ItemsMenu1);
                INV.setItem(21, ItemMenu1);
                ItemStack ItemMenu2 = new ItemStack(Material.GOLDEN_APPLE);
                ItemMeta ItemsMenu2 = ItemMenu2.getItemMeta();
                ItemsMenu2.setDisplayName("§6▸ §e§lUHC");
                ItemsMenu2.addEnchant(Enchantment.LURE,1,true);
                ItemsMenu2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                ItemMenu2.setItemMeta(ItemsMenu2);
                INV.setItem(23, ItemMenu2);
                player.openInventory(INV);
            }
        }
    }
    public ItemStack getPaneItem(byte data){
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE,1,data);
        ItemMeta itemmeta = itemStack.getItemMeta();
        itemmeta.setDisplayName("§f");
        itemStack.setItemMeta(itemmeta);
        return itemStack;
    }


    }
