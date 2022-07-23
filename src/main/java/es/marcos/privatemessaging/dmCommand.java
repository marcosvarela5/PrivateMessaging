package es.marcos.privatemessaging;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class dmCommand implements CommandExecutor {

    public dmCommand() {
    }

    // /dm <player_name> <message>
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender; //get the player instance which is the command sender
            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (Bukkit.getOnlinePlayers().contains(target)) { //You can't message an offline player

                    //What I do here is ensured that strings with spaces are treated as a single argument
                    //using a simple StringBuilder structure
                    //For loop starts at i = 1 because we don't need to work over the player's name
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        builder.append(args[i]).append(" "); //so we don't loop infinitely
                    }

                    assert target != null;
                    target.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " -> " +
                            ChatColor.YELLOW + "Tú" + ChatColor.RED + "] " + ChatColor.WHITE + builder);
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "Tú" + ChatColor.GRAY + " -> " +
                            target.getDisplayName() + ChatColor.RED + "] " + ChatColor.WHITE + builder);
                } else {
                    p.sendMessage(ChatColor.RED + "Este jugador no existe o se encuentra desconectado.");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Uso incorrecto. Utiliza /dm <nombre> <mensaje>");
            }
        }
        return false;
    }
}
