package com.gravix.skywars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    public static Config instance;
    private File directory;
    private File configFile;
    private FileConfiguration config;
    private File kitsFile;
    private FileConfiguration kits;
    private File chestsFile;
    private FileConfiguration chests;


    public void setup(final Plugin p) {

        this.directory = p.getDataFolder();
        this.configFile = new File(this.directory, "config.yml");
        if (!this.configFile.exists()) {
            p.saveResource("config.yml", true);
        }
        this.kitsFile = new File(this.directory, "kits.yml");
        if (!this.kitsFile.exists()) {
            p.saveResource("kits.yml", true);
        }
        this.chestsFile = new File(this.directory, "chests.yml");
        if (!this.chestsFile.exists()) {
            p.saveResource("chests.yml", true);
        }
        this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.configFile);
        this.kits = (FileConfiguration) YamlConfiguration.loadConfiguration(this.kitsFile);
        this.chests = (FileConfiguration) YamlConfiguration.loadConfiguration(this.chestsFile);
    }

    public File getConfigFile() {
        return this.configFile;
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public File getKitsFile() {
        return this.kitsFile;
    }

    public FileConfiguration getKits() {
        return this.kits;
    }

    public File getChestsFile() {
        return this.chestsFile;
    }

    public FileConfiguration getChests() {
        return this.chests;
    }

    public void SaveConfig() {
        try {
            this.config.save(this.configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveKits() {
        try {
            this.kits.save(this.kitsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveChests() {
        try {
            this.chests.save(this.chestsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config get() {
        if (Config.instance == null) {
            Config.instance = new Config();
        }
        return Config.instance;
    }
}