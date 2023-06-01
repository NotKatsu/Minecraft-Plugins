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

        if (command.getName().equals("freeze")) {
            if (commandSender instanceof Player) {
                Player commandExecutor = (Player) commandSender;

                if (strings.length == 1) {
                    Player player = Bukkit.getPlayer(strings[0]);

                    if (player == null) {
                        commandExecutor.sendMessage(ChatColor.RED + " that player does not exist.. Please try again.");

                    } else {
                        if (commandExecutor.isOp()) {
                            if (frozenPlayers.contains(player.getUniqueId())) {
                                commandExecutor.sendMessage(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " Is already frozen..");
                            } else {
                                frozenPlayers.add(player.getUniqueId());

                                commandExecutor.sendMessage(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " Has been frozen successfully.");
                                player.sendMessage(ChatColor.RED + "You have been frozen by staff.. Please wait.");
                            }
                        } else {
                            commandExecutor.sendMessage(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " only Players with OP can run this command..");
                        }
                    }
                }
            } else {
                System.out.println("/freeze can only be used by Players not the Console.");
            }
        } else if (command.getName().equals("unfreeze")) {
           if (commandSender instanceof Player) {
                Player commandExecutor = (Player) commandSender;

                if (commandExecutor.isOp()) {
                    if (strings.length == 1) {
                        Player player = Bukkit.getPlayer(strings[0]);

                        if (player == null) {
                            commandExecutor.sendMessage(ChatColor.RED + " that player does not exist.. Please try again.");
                        } else {
                            if (frozenPlayers.contains(player.getUniqueId())) {
                                frozenPlayers.remove(player.getUniqueId());

                                commandExecutor.sendMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " has been unfrozen and can now move.");
                                player.sendMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " You have been unfrozen and can now move.");
                            } else {
                                commandExecutor.sendMessage(ChatColor.RED + " that player is not frozen..");

                            }
                        }

                    }
                } else {
                    commandExecutor.sendMessage(ChatColor.RED + commandExecutor.getDisplayName() + ChatColor.WHITE + " only Players with OP can run this command..");
                }
           } else {
               System.out.println("/unfreeze can only be used by Players not the Console.");
           }
        }

        return false;
    }
}
