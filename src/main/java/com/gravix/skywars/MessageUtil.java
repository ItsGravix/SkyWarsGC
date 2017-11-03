package com.gravix.skywars;


import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil {

    public MessageUtil(){
        init();
    }

    public static String noperms;


    public void init() {
        noperms = getLang("messages.noperms");
    }

    public String getLang(String msg){
        return ChatColor.translateAlternateColorCodes('&',Principal.plugin.getLang().getString(msg));
    }

    public List<String> getListColorized(String msg){
        List<String> list = new ArrayList<>();
        for(String s : Principal.getLang().getStringList(msg)){
            s = ChatColor.translateAlternateColorCodes('&',s);
            list.add(s);
        }
        return list;
    }
}
// wait