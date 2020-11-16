package me.prouge.lobbySystem.listeners;

import me.prouge.lobbySystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {
    private LobbySystem lobbySystem;
    public InventoryClickEvent(LobbySystem lobbySystem){
        this.lobbySystem = lobbySystem;
    }
    @EventHandler
    public void onInventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if("§c§lSpielerverstecker".equals(event.getInventory().getTitle())){
            if(event.getSlot() == 3){
                player.sendMessage("Dir werden nun keine Spieler mehr angezeigt!");
                for(Player playersOnline : Bukkit.getOnlinePlayers()){
                    player.hidePlayer(playersOnline);
                }

            }if(event.getSlot() == 5){
                player.sendMessage("Dir werden nun alle Spieler wieder angezeigt!");
                for(Player playersOnline : Bukkit.getOnlinePlayers()){
                    player.showPlayer(playersOnline);
                }
            }
        }
        if("§c§lNavigator".equals(event.getInventory().getTitle())){
            switch(event.getSlot()){
                case 4: teleportLocation("BedWars", player); break;
                case 12: teleportLocation("SkyWars", player); break;
                case 13: teleportLocation("Spawn", player); break;
                case 14: teleportLocation("CityBuild", player); break;
                case 22: teleportLocation("Community", player); break;

            }

        }
    }

    public void teleportLocation(String location, Player player){
        if(lobbySystem.getConfig().get(location) != null){
            player.teleport((Location) lobbySystem.getConfig().get(location));
            if(location.equals("Spawn")){
                player.sendMessage("§8» §7Du wurdest zum Spawn teleportiert!");
                return;
            }
            player.sendMessage("§8» §7Du wurdest zum Spawn von " + location + " teleportiert!");
        }

    }


}
