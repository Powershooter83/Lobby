package me.prouge.lobbySystem;

import me.prouge.lobbySystem.commands.SetSpawn;
import me.prouge.lobbySystem.listeners.InventoryClickEvent;
import me.prouge.lobbySystem.listeners.Events;
import me.prouge.lobbySystem.listeners.PlayerInteractEvent;
import me.prouge.lobbySystem.listeners.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {
    private LobbySystem lobbySystem;


    public void onEnable() {
        lobbySystem = this;
        registerListener();
        registerCommands();
        //Config
        getConfig().options().copyDefaults(true);
        saveConfig();
        checkPerms();
    }

    public void onDisable() {


    }

    public void checkPerms(){
        if(getConfig().get("SetCommandPermission") == null){
            getConfig().set("SetSpawnPermission", "lobbySystem.spawn");
            saveConfig();
        }
    }

    public void registerListener(){
        getServer().getPluginManager().registerEvents(new InventoryClickEvent(lobbySystem), this);
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(lobbySystem), this);
    }

    public void registerCommands() {
        getCommand("setspawn").setExecutor(new SetSpawn(lobbySystem));

    }

}
