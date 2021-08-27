package de.derstandard.coinplugin.listeners;

import de.derstandard.coinplugin.api.CoinAPIImpl;
import de.derstandard.coinplugin.CoinPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onJoin(PlayerJoinEvent e) {
    CoinAPIImpl coinAPI = CoinPlugin.getInstance().getCoinAPI();
    if (!coinAPI.doesUserExist(e.getPlayer().getUniqueId())) {
      coinAPI.initPlayer(e.getPlayer().getUniqueId());
    }
  }
}
