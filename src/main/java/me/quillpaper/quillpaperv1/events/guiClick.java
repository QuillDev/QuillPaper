package me.quillpaper.quillpaperv1.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class guiClick implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        //Get the player using the inventory
        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase("Classes")) {
            if (e.getClickedInventory() == e.getView().getTopInventory()) {
                //Check if an item is clicked of a certain type
                String[] classes = new String[]{"arsonist", "priest", "necromancer", "berserker", "archer"};

                switch (e.getCurrentItem().getType()){
                    case IRON_SHOVEL:
                        player.closeInventory();
                        for(int i = 0; i < classes.length; i++){
                            player.removeScoreboardTag(classes[i]);
                        }
                        player.addScoreboardTag("necromancer");
                        player.sendMessage(ChatColor.DARK_PURPLE + "You've chosen the path of a Necromancer!");
                        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + player.getDisplayName() + " has chosen the path of Necromancer!");

                        ItemStack itemnecro = new ItemStack(Material.IRON_SHOVEL, 1);

                        ItemMeta necrometa = itemnecro.getItemMeta();
                        necrometa.setDisplayName(ChatColor.DARK_PURPLE + "Spade of the Undead");
                        ArrayList<String> necrolore = new ArrayList<String>();
                        necrolore.add(ChatColor.DARK_PURPLE+ "A spade passed down by a mysterious mortician...");
                        necrometa.setLore(necrolore);

                        itemnecro.setItemMeta(necrometa);
                        player.getInventory().addItem(new ItemStack(itemnecro));
                        break;

                    case IRON_AXE:
                        player.closeInventory();
                        for(int i = 0; i < classes.length; i++){
                            player.removeScoreboardTag(classes[i]);
                        }
                        player.addScoreboardTag("berserker");
                        player.sendMessage(ChatColor.RED + "You've chosen the path of a Berserker!");
                        Bukkit.broadcastMessage(ChatColor.RED + player.getDisplayName() + " has chosen the path of Berserker!");
                        break;

                    case FLINT_AND_STEEL:
                        player.closeInventory();
                        for(int i = 0; i < classes.length; i++){
                            player.removeScoreboardTag(classes[i]);
                        }
                        player.addScoreboardTag("arsonist");
                        player.sendMessage(ChatColor.GOLD + "You've chosen the path of an Arsonist!");
                        Bukkit.broadcastMessage(ChatColor.GOLD + player.getDisplayName() + " has chosen the path of Arsonist!");
                        break;

                    case GOLDEN_APPLE:
                        player.closeInventory();
                        for(int i = 0; i < classes.length; i++){
                            player.removeScoreboardTag(classes[i]);
                        }
                        player.addScoreboardTag("priest");
                        player.sendMessage(ChatColor.YELLOW + "You've chosen the path of a Priest!");
                        Bukkit.broadcastMessage(ChatColor.YELLOW + player.getDisplayName() + " has chosen the path of Priest!");
                        ItemStack item = new ItemStack(Material.BOOK, 1);

                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(ChatColor.GREEN + "Book of Healing");
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add(ChatColor.YELLOW + "A book Blessed by a priest to provide allies with vitality...");
                        itemmeta.setLore(lore);

                        item.setItemMeta(itemmeta);
                        player.getInventory().addItem(new ItemStack(item));

                        ItemStack item2 = new ItemStack(Material.BOOK, 1);

                        ItemMeta itemmeta2 = item2.getItemMeta();
                        itemmeta2.setDisplayName(ChatColor.RED + "Book of Strength");
                        ArrayList<String> lore2 = new ArrayList<String>();
                        lore2.add(ChatColor.RED+ "A book blessed by a priest to provide allies with insurmountable strength...");
                        itemmeta.setLore(lore2);

                        item2.setItemMeta(itemmeta2);
                        player.getInventory().addItem(new ItemStack(item2));
                        break;

                    case BOW:
                        player.closeInventory();
                        for(int i = 0; i < classes.length; i++){
                            player.removeScoreboardTag(classes[i]);
                        }
                        player.addScoreboardTag("archer");
                        player.sendMessage(ChatColor.GREEN + "You've chosen the path of a Archer!");
                        Bukkit.broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " has chosen the path of Archer!");
                        break;
                }
                //Cancel taking of items.
                e.setCancelled(true);
            }
        }
    }
}
