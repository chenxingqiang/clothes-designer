package com.iechor.clothesdesigner.chat.server.agent;

import lombok.Data;

import java.util.List;

@Data
public class PluginTool extends AgentTool {

    private List<Long> plugins;
}
