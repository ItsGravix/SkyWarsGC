package com.gravix.skywars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin
{

    public static Principal plugin;

    public void onEnable()
    {
        plugin = this;
        setup();
    }

    public void onDisable()
    {

    }

    public void setup()
    {

    }

    public static FileConfiguration getLang(){
        return MessageUtil;
    }
}

