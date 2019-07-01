package me.quillpaper.quillpaperv1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUICommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;

            //Gui Size
            Inventory gui = Bukkit.createInventory(player,9, "Classes");

            //Items in the Inventory
            ItemStack necromancer = new ItemStack(Material.IRON_SHOVEL);
            ItemStack arsonist = new ItemStack(Material.FLINT_AND_STEEL);
            ItemStack berserker = new ItemStack(Material.IRON_AXE);
            ItemStack priest = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack archer = new ItemStack(Material.BOW);

            //Necromancer Meta Editing
            ItemMeta necromancer_meta = necromancer.getItemMeta();
            necromancer_meta.setDisplayName(ChatColor.DARK_PURPLE +"Necromancer");
            necromancer.setItemMeta(necromancer_meta);

            //Arsonist Meta Editing
            ItemMeta arsonist_meta = arsonist.getItemMeta();
            arsonist_meta.setDisplayName(ChatColor.GOLD +"Arsonist");
            arsonist.setItemMeta(arsonist_meta);

            //Berserker Meta Editing
            ItemMeta berserker_meta = berserker.getItemMeta();
            berserker_meta.setDisplayName(ChatColor.RED +"Berserker");
            berserker.setItemMeta(berserker_meta);

            //Priest Meta Editing
            ItemMeta priest_meta = priest.getItemMeta();
            priest_meta.setDisplayName(ChatColor.YELLOW +"Priest");
            priest.setItemMeta(priest_meta);

            //Archer Meta Editing
            ItemMeta archer_meta = archer.getItemMeta();
            archer_meta.setDisplayName(ChatColor.GREEN +"Archer");
            archer.setItemMeta(archer_meta);


            //Put Items in the inventory
            ItemStack[] menu_items = {necromancer, arsonist, berserker, priest, archer};
            gui.setContents(menu_items);

            //Open the Inventory for the player
            player.openInventory(gui);
        }
        return true;
    }
}
