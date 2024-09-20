package com.iechor.clothesdesigner.chat.server.plugin.event;

import com.iechor.clothesdesigner.chat.server.plugin.ChatPlugin;
import org.springframework.context.ApplicationEvent;

public class PluginAddEvent extends ApplicationEvent {

    private ChatPlugin plugin;

    public PluginAddEvent(Object source, ChatPlugin plugin) {
        super(source);
        this.plugin = plugin;
    }

    public ChatPlugin getPlugin() {
        return plugin;
    }
}
