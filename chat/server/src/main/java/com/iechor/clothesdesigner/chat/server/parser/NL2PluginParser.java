package com.iechor.clothesdesigner.chat.server.parser;

import com.iechor.clothesdesigner.chat.server.plugin.recognize.PluginRecognizer;
import com.iechor.clothesdesigner.chat.server.pojo.ParseContext;
import com.iechor.clothesdesigner.chat.server.util.ComponentFactory;
import com.iechor.clothesdesigner.common.util.JsonUtil;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NL2PluginParser implements ChatQueryParser {

    private final List<PluginRecognizer> pluginRecognizers =
            ComponentFactory.getPluginRecognizers();

    @Override
    public void parse(ParseContext parseContext, ParseResp parseResp) {
        if (!parseContext.getAgent().containsPluginTool()) {
            return;
        }

        pluginRecognizers.forEach(
                pluginRecognizer -> {
                    pluginRecognizer.recognize(parseContext, parseResp);
                    log.info(
                            "{} recallResult:{}",
                            pluginRecognizer.getClass().getSimpleName(),
                            JsonUtil.toString(parseResp));
                });
    }
}
