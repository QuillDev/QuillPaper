package me.quillpaper.quillpaperv1.arsonist;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class arsonBuffs implements Listener {
    @EventHandler
    public void checkDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                Player p = (Player) event.getEntity();
                if(p.getScoreboardTags().contains("arsonist")){
                    p.sendMessage(ChatColor.GOLD +" The flames engulf you, you welcome them.");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 2));
            }
        }
    }
}
}
