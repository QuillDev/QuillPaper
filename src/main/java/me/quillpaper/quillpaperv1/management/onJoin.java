package me.quillpaper.quillpaperv1.management;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.RED + ">>>" + ChatColor.GREEN  + " WELCOME TO THE SERVER " + player.getDisplayName() + ChatColor.RED + " <<<");

    }
}
