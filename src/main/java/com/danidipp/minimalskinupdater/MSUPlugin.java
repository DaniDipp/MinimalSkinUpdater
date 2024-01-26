package com.danidipp.minimalskinupdater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MSUPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getCommandMap().register("skin", new SkinCommand());
    }

}