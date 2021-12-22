package de.jomlua.utils;

import de.jomlua.core;
import de.jomlua.listener.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class getListener {

    public static  void setUp(){
        loadListeners();
    }

    private static void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        core r = core.plugin;
        pm.registerEvents(new ChatListener(),r);
        //pm.registerEvents(new PermissionPicker(),r);
    }
}