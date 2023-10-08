package dev.myclxss;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import dev.myclxss.components.Color;
public class EmojiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        API.getInstance().getLang().reload();

        ConfigurationSection emojisConfig = API.getInstance().getLang().getConfigurationSection("EMOJIS");
        sender.sendMessage(API.getInstance().getLang().getString("TITLE", true));

        for (String emoji : emojisConfig.getKeys(false)) {
            String text = emojisConfig.getString(emoji + ".TEXT");
            String replace = emojisConfig.getString(emoji + ".REPLACE");

            sender.sendMessage(Color.set("&e" + emoji + " &8» " + "&f" + text + " &8» " + replace));
        }
        return false;
    }
}