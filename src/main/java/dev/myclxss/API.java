package dev.myclxss;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import dev.myclxss.components.Files;
import dev.myclxss.components.Items;
import dev.myclxss.event.ChatEvent;

public class API {

    private static API instance;
    private Emojis main;

    private Files lang;

    public API(Emojis plugin) {

        instance = this;
        main = plugin;

        Items.init();

        lang = new Files(plugin, "lang");

        loadCommands();
        loadEvents();

    }

    public void loadEvents() {

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ChatEvent(), main);

    }

    public void loadCommands() {

        main.getCommand("emojis").setExecutor(new EmojiCommand());

    }

    public Emojis getMain() {
        return main;
    }

    public static API getInstance() {
        return instance;
    }

    public Files getLang() {
        return lang;
    }

}
