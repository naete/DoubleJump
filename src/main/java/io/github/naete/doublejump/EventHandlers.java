package io.github.naete.doublejump;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class EventHandlers implements Listener {

    public EventHandlers(Main main) {

    }

    @EventHandler
    public void onFlightToggle (PlayerToggleFlightEvent event) {

        String player = event.getPlayer().getName();
        Location location = event.getPlayer().getLocation();
        Vector playerDirection = location.getDirection();
        double configMultiplier = Main.plugin.getConfig().getDouble("multiplier");

        event.setCancelled(true);

        event.getPlayer().setVelocity(playerDirection.setY(Math.abs(playerDirection.getY())).multiply(configMultiplier));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(location, Sound.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
        }

        event.getPlayer().setAllowFlight(false);

    }

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {

            if (event.getPlayer().isOnGround()) {
                event.getPlayer().setAllowFlight(true);
            }

    }

}
