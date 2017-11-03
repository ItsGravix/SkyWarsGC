package com.gravix.skywars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {

    public void sendMessage(Player p, String s) {
        p.sendMessage(s.replaceAll("&", "§"));

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (!p.hasPermission("gskywars.*")) {
            sendMessage(p, MessageUtil.noperms);
            return true;

        }
        return true;
    }
}
