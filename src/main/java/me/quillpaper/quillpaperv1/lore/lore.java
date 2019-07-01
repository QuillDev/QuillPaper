package  me.quillpaper.quillpaperv1.lore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;


public class lore implements Listener {

    @EventHandler
    public void onSleep(PlayerBedLeaveEvent e){
        e.getPlayer().sendMessage(ChatColor.GREEN + e.getPlayer().getDisplayName() + " you feel rejuvenated.");
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity() instanceof Player) {

            Player p = e.getEntity();
            Bukkit.broadcastMessage(p.getDisplayName() + "was slain ruthlessly.");
        }
    }
}

