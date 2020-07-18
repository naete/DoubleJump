package io.github.naete.doublejump;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    PluginManager manager = getServer().getPluginManager();

    @Override
    public void onEnable() {

        plugin = this;

        // Events
        manager.registerEvents(new EventHandlers(this), this);

        this.saveDefaultConfig();
    }

}
