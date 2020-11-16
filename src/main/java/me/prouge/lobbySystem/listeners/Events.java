package me.prouge.lobbySystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Events implements Listener {
    @EventHandler
    public void onItemMoveEvent(InventoryMoveItemEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onItemDropEvent(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onItemPickUp(InventoryPickupItemEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            event.setCancelled(true);
        }

    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onBuild(BlockPlaceEvent event){
        event.setCancelled(true);
    }


}
