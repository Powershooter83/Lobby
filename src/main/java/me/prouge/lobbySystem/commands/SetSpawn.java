package me.prouge.lobbySystem.commands;

import me.prouge.lobbySystem.LobbySystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    private LobbySystem lobbySystem;

    public SetSpawn(LobbySystem lobbySystem) {
        this.lobbySystem = lobbySystem;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission((String) lobbySystem.getConfig().get("SetSpawnPermission"))) {
                if (args.length == 0) {
                    player.sendMessage("Bitte benutze: /setspawn NAME");
                    player.sendMessage("BedWars, SkyWars, CityBuild, Spawn, Community");
                }
                if (args.length > 1) {
                    player.sendMessage("Bitte benutze: /setspawn NAME");
                    player.sendMessage("BedWars, SkyWars, CityBuild, Spawn, Community");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("bedwars")){
                        saveConfig("BedWars", player);
                    }
                    if (args[0].equalsIgnoreCase("skywars")){
                        saveConfig("SkyWars", player);
                    }
                    if (args[0].equalsIgnoreCase("community")){
                        saveConfig("Community", player);
                    }
                    if (args[0].equalsIgnoreCase("citybuild")){
                        saveConfig("CityBuild", player);
                    }
                    if (args[0].equalsIgnoreCase("spawn")){
                        saveConfig("Spawn", player);
                    }
                }

            }

        }


        return false;
    }

    public void saveConfig(String location, Player player) {
        lobbySystem.getConfig().set(location, player.getLocation());
        lobbySystem.saveConfig();
        player.sendMessage("§8» §7Der " + location + "-Spawn wurde erfolgreich gespeichert!");
    }

}
