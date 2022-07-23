package es.marcos.privatemessaging;

import org.bukkit.plugin.java.JavaPlugin;

public final class PrivateMessaging extends JavaPlugin {

        @Override
        public void onEnable() {
            //get a pipeline so we can create an instance
            //of our manager in each command
            getCommand("dm").setExecutor(new dmCommand());
        }

        @Override
        public void onDisable() {
            // Plugin shutdown logic
        }
    }
