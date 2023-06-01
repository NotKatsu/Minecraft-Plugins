package com.notkatsu.freezeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FreezeCommands implements CommandExecutor {

    public List<UUID> frozenPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player command_author = (Player) commandSender;

            if (strings.length == 1) {
                Player player = Bukkit.getPlayer(strings[0]);

                if (player == null) {
                    command_author.sendMessage(ChatColor.RED + " that player does not exist.. Please try again.");

                } else {
                    if (command_author.isOp()) {
                        if frozenPlayers.contains(player.)
                    } else {
                        command_author.sendMessage(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " only Players with OP can run this command..");
                    }
                }

            }
        } else {
            System.out.println("/freeze can only be used by Players not the Console.");
        }
        return false;
    }
}
