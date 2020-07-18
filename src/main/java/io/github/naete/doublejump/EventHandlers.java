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

    @EventHandler
    public void onFlightToggle (PlayerToggleFlightEvent event) {

        event.setCancelled(true);
        Location location = event.getPlayer().getLocation();
        Vector playerDirection = location.getDirection();

        event.getPlayer().setVelocity(playerDirection.setY(Math.abs(playerDirection.getY())).multiply(1.5));
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
