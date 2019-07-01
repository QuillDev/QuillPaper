package me.quillpaper.quillpaperv1.berserker;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ZerkVamp implements Listener {

    @EventHandler
    public void lifeSteal(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player p = ((Player) e.getDamager()).getPlayer();
            if(p.getScoreboardTags().contains("berserker")){
                double health = p.getHealth();
                if(health > 8){
                    if(health <= 19){p.setHealth(p.getHealth()+.5);}
                    if(health%2 == 0){p.sendMessage(ChatColor.RED + "You satiate your bloodlust. " + p.getDisplayName());}
                }
                else {
                    //Apply Strength and Resistance effects to a "Berserk Player"
                    p.sendMessage(ChatColor.DARK_RED + "You've gone BERSERK");
                    if(health <= 19){p.setHealth(p.getHealth()+1);}
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 1));
                }



            }
        }
    }
}
