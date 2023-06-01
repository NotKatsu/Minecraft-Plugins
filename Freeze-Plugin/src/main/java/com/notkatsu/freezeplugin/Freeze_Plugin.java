package com.notkatsu.freezeplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Freeze_Plugin extends JavaPlugin implements Listener {

    FreezeCommands freezeCommands = new FreezeCommands();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("freeze").setExecutor(freezeCommands);
    }

}
