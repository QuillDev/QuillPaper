package me.quillpaper.quillpaperv1;
import me.quillpaper.quillpaperv1.archer.BowMan;
import me.quillpaper.quillpaperv1.arsonist.arsonBuffs;
import me.quillpaper.quillpaperv1.berserker.ZerkVamp;
import me.quillpaper.quillpaperv1.necromancer.necromancer;
import me.quillpaper.quillpaperv1.commands.GUICommand;
import me.quillpaper.quillpaperv1.events.guiClick;
import me.quillpaper.quillpaperv1.lore.lore;
import me.quillpaper.quillpaperv1.management.onJoin;
import me.quillpaper.quillpaperv1.management.onLeave;
import me.quillpaper.quillpaperv1.priest.bookEffects;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public final class QuillPaperv1 extends JavaPlugin implements Listener {

    //Add HP on Scoreboard
    private Scoreboard board;
    private Objective o;
    private Score s;

    @Override
    public void onEnable() {
        //Setup HP Scoreboard
        board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        o = board.registerNewObjective("hearts", "health");
        o.setDisplayName("HP");
        o.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        //Logs plugin start
        //Lore Based Plugins
        getServer().getPluginManager().registerEvents(new lore(), this);

        // IO management based plugins.
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onLeave(), this);
        getServer().getPluginManager().registerEvents(new necromancer(), this);
        getServer().getPluginManager().registerEvents(new guiClick(), this);
        getServer().getPluginManager().registerEvents(new arsonBuffs(), this);
        getServer().getPluginManager().registerEvents(new ZerkVamp(), this);
        getServer().getPluginManager().registerEvents(new BowMan(), this);
        getServer().getPluginManager().registerEvents(new bookEffects(), this);
        getCommand("class").setExecutor(new GUICommand());


    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        //Add player to scoreboard upon joining
        Player p = e.getPlayer();
        p.setScoreboard(board);
    }


}
