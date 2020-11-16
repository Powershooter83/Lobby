package me.prouge.lobbySystem.listeners;

import me.prouge.lobbySystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;

public class PlayerInteractEvent implements Listener {
    Inventory playerNavigatorInventory = Bukkit.createInventory(null, 27, "§c§lNavigator");
    Inventory playerHideInventory = Bukkit.createInventory(null, 9, "§c§lSpielerverstecker");


    @EventHandler
    public void onPlayerInteractEvent(org.bukkit.event.player.PlayerInteractEvent event) {
        if(event.getItem() == null) return;

        Player player = event.getPlayer();
        if (event.getItem().getType() == Material.COMPASS) {
            for (int i = 0; i < 27; i++) {
                playerNavigatorInventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).
                        setDyeColor(DyeColor.GRAY).toItemStack());
            }
            playerNavigatorInventory.setItem(4, new ItemBuilder(Material.BED).setName("§eBedWars").toItemStack());
            playerNavigatorInventory.setItem(12, new ItemBuilder(Material.GRASS).setName("§eSkyWars").toItemStack());
            playerNavigatorInventory.setItem(13, new ItemBuilder(Material.MAGMA_CREAM).setName("§eSpawn").toItemStack());
            playerNavigatorInventory.setItem(14, new ItemBuilder(Material.WOOD_AXE).setName("§eCityBuild").toItemStack());
            playerNavigatorInventory.setItem(22, new ItemBuilder(Material.RED_ROSE).setName("§eCommunity").toItemStack());
            player.openInventory(playerNavigatorInventory);
        }
        if(event.getItem().getType() == Material.BLAZE_ROD){
            for(int i = 0; i < 9; i++){
                playerHideInventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.GRAY)
                        .setName("§c")
                        .toItemStack());
                playerHideInventory.setItem(3, new ItemBuilder(Material.STAINED_GLASS).setDyeColor(DyeColor.RED).
                        setName("§cKeine Spieler anzeigen").
                        toItemStack());
                playerHideInventory.setItem(5, new ItemBuilder(Material.STAINED_GLASS).setDyeColor(DyeColor.GREEN).
                        setName("§eAlle Spieler anzeigen").
                        toItemStack());
                player.openInventory(playerHideInventory);
            }

        }else {
            return;
        }
    }

}
