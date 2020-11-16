package me.prouge.lobbySystem.listeners;

import me.prouge.lobbySystem.LobbySystem;
import me.prouge.lobbySystem.utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinEvent implements Listener {
    private LobbySystem lobbySystem;

    public PlayerJoinEvent(LobbySystem lobbySystem){
        this.lobbySystem = lobbySystem;
    }


    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("");
        if(lobbySystem.getConfig().get("Spawn") != null){
            player.teleport((Location) lobbySystem.getConfig().get("Spawn"));
            player.sendMessage("§8» §7Willkommen auf Spiele-insel.eu!");
            player.getInventory().clear();
            player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setName("§8« §cNavigator §8»")
                    .setLore("§7Wähle ein Ziel aus!").toItemStack());
            player.getInventory().setItem(6, new ItemBuilder(Material.BLAZE_ROD).setName("§8« §cSpielerVerstecker §8»")
                    .setLore("§7Verstecke Spieler!").toItemStack());
        }else{
            player.sendMessage("§8» §7ERROR: Der Spawn wurde nicht gesetzt!");
        }

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage("");
    }


}
