package dev.myclxss.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.myclxss.API;
import dev.myclxss.components.Color;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        for (String emoji : API.getInstance().getLang().getConfigurationSection("EMOJIS").getKeys(false)) {
            String text = API.getInstance().getLang().getString("EMOJIS." + emoji + ".TEXT");
            String replace = API.getInstance().getLang().getString("EMOJIS." + emoji + ".REPLACE");

            if (message.contains(text)) {
                message = message.replace(text, replace);
            }
        }
        message = Color.set(message + "&r");

        event.setMessage(message);
    }
}
