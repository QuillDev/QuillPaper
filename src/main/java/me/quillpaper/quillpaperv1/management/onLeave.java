package me.quillpaper.quillpaperv1.management;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

//Called when player leaves the server
public class onLeave implements Listener {
    @EventHandler
    void onPlayerLeave(PlayerQuitEvent e) {

        //Expected Output [-] PlayerName
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.WHITE+ "[" + ChatColor.RED + "-" + ChatColor.WHITE + "] " + player.getDisplayName());
    }
}
