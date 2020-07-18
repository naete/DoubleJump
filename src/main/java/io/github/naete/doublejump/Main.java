package io.github.naete.doublejump;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    PluginManager manger = getServer().getPluginManager();

    @Override
    public void onEnable() {
        manger.registerEvents(new EventHandlers(), this);
    }

}
