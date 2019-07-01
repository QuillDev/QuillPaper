package me.quillpaper.quillpaperv1.priest;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;
import java.util.List;


public class bookEffects implements Listener {
    //PRIEST CONFIGURATION.
    //HEAL RADIUS
    int radius = 5;

    //HEAL AMOUNT IN HEARTS
    int healing = 1 * 2;

    @EventHandler
    public void checkForPlayers(PlayerInteractEvent e) {
        //Get Player holding the book
        Player player = e.getPlayer();

        if((player.getScoreboardTags().contains("priest"))){

            double radiusSquared = radius*radius;

            List<Entity> entities = player.getNearbyEntities(radius, radius, radius); // All entities withing a box

            if(!entities.isEmpty()) {
                for (Entity entity : entities) {

                    if (entity.getLocation().distanceSquared(player.getLocation()) > radiusSquared)
                        continue; // All entities within a sphere

                    if (entity instanceof Player) {

                        Player p = ((Player) entity);

                        //Get Custom item display name
                        String itemname = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

                        //If Priest is holding the Book of Healing
                        if (itemname.equalsIgnoreCase(ChatColor.GREEN + "Book of Healing")) {
                            if (p.getHealth() + healing <= 20) {
                                p.setHealth(p.getHealth() + healing);
                                p.sendMessage(ChatColor.GREEN + "A priest has blessed you with their gift of healing!");
                                player.sendMessage(ChatColor.GREEN + "You've Rejuvenated your companions!");
                            } else if(p.getHealth() + healing >= 20 && p.getHealth() < 20) {
                                p.setHealth(20);
                                p.sendMessage(ChatColor.GREEN + "A priest has blessed you with their gift of healing!");
                                player.sendMessage(ChatColor.GREEN + "You've Rejuvenated your companions!");
                            } else {
                                //Nothing
                            }

                        }

                        if(itemname.equalsIgnoreCase(ChatColor.RED + "Book of Strength")){
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50, 1));p.sendMessage(ChatColor.RED + player.getDisplayName() + " blesses you with strength!");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50, 1)); player.sendMessage(ChatColor.RED + "You summon strength!");
                        }

                        //More Books....

                    }

                }
            }
        }


    }
}
