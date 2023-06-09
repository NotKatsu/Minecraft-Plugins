package com.notkatsu.freezeplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Freeze_Plugin extends JavaPlugin implements Listener {

    FreezeCommands freezeCommands = new FreezeCommands();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        try {
            getCommand("freeze").setExecutor(freezeCommands);
            getCommand("unfreeze").setExecutor(freezeCommands);

        } catch (NullPointerException err) {
            err.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (freezeCommands.frozenPlayers.contains(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (freezeCommands.frozenPlayers.contains(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }

}
