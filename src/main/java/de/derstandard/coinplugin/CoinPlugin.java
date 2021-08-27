package de.derstandard.coinplugin;

import de.derstandard.coinplugin.api.CoinAPIImpl;
import de.derstandard.coinplugin.listeners.JoinListener;
import de.derstandard.coinplugin.api.CoinAPI;
import de.derstandard.coinplugin.database.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CoinPlugin extends JavaPlugin {
  private static CoinPlugin instance;
  private MySQL mySQL;
  private CoinAPIImpl coinAPI;

  @Override
  public void onLoad() {
    instance = this;
    this.mySQL = MySQL.newBuilder()
            .withUrl("Your Url")
            .withPort(3306)
            .withDatabase("Your Database")
            .withUser("Your User")
            .withPassword("Your Password")
            .create();
  }

  @Override
  public void onEnable() {
    coinAPI = new CoinAPIImpl();
    coinAPI.createTables();
    CoinAPI.setApi(coinAPI);
    Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
  }

  public static CoinPlugin getInstance() {
    return instance;
  }

  public MySQL getMySQL() {
    return mySQL;
  }

  public CoinAPIImpl getCoinAPI() {
    return coinAPI;
  }

}
