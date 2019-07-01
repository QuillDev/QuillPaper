//BOWMAN / ARCHER CLASS
package me.quillpaper.quillpaperv1.archer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class BowMan implements Listener {

    @EventHandler //Handle the event
    public void bowMan(EntityDamageByEntityEvent event)
    {
        Entity damager = event.getDamager(); //Get who's damaging the Entity.

        if(damager instanceof Arrow) { // check if the damage was done with an Arrow.

            Arrow arrow = (Arrow) damager;

            if(arrow.getShooter() instanceof Player) {
                // the arrow.getShooter() here is the player who fired the arrow
                Player p = ((Player) arrow.getShooter());

                int random = (int)(Math.random() * 10 + 1);
                if(random == 10){
                    //Double Damage
                    event.setDamage(event.getDamage()*2);
                    p.sendMessage(ChatColor.DARK_RED + "Your arrow fly's directly into the foes heart.");
                } else{
                    event.setDamage(event.getDamage()*1.5);
                    p.sendMessage(ChatColor.GREEN + "Your arrow strikes it's target.");
                }

                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
            }




        }
    }
}
