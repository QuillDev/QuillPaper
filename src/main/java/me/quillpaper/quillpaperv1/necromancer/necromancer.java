//TODO maybe limit the amount of guardian spawns to 2?
//TODO add custom mobs to be usable

package me.quillpaper.quillpaperv1.necromancer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class necromancer implements Listener {

    List<String> list = new ArrayList();

    //Necromancer Summon Mechanics
    @EventHandler
    public void onSummonAttempt(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(!list.contains(p.getName())) {
            //Check if the player is holding an iron shovel
            if ((p.getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL) && (p.getScoreboardTags().contains("necromancer"))) {
                //Create With Special Properties
                EntityType mygolem = EntityType.IRON_GOLEM;

                //Shoots the golem out from the shovel.
                IronGolem golem = (IronGolem) p.getWorld().spawn(p.getEyeLocation(), mygolem.getEntityClass());
                golem.setVelocity(p.getEyeLocation().getDirection().multiply(2));
                golem.setCustomName(p.getName() + "'s Guardian");
                golem.setPlayerCreated(true);
                golem.setGlowing(true);
                list.add(p.getName());

                p.sendMessage("You've summoned an Iron Golem and and paid the price...");
                p.spawnParticle(Particle.PORTAL, p.getLocation().getX(), p.getLocation().getY() + 2, p.getLocation().getZ(), 128);
                p.spawnParticle(Particle.DRAGON_BREATH, p.getLocation().getX(), p.getLocation().getY() + 2, p.getLocation().getZ(), 128);
                p.damage(8);
                p.setSaturation(10);
            }
        }
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent e) {

        //Get name of the Golem
        if(e.getEntity().getCustomName() != null) {
            String ename = e.getEntity().getCustomName();
            //Loop Through online players
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (ename.contains(p.getName())) {
                    Bukkit.broadcastMessage(p.getDisplayName() + "'s Guardian was slain!");
                    list.remove(p.getName());
                } else {
                    //Do nothing
                }
            }
        }

    }
}
