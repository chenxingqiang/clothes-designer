package com.iechor.clothesdesigner.chat.server.processor.parse;

import com.iechor.clothesdesigner.chat.server.pojo.ParseContext;
import com.iechor.clothesdesigner.headless.api.pojo.response.ParseResp;
import lombok.extern.slf4j.Slf4j;

/** TimeCostProcessor adds time cost of parsing. */
@Slf4j
public class TimeCostProcessor implements ParseResultProcessor {

    @Override
    public void process(ParseContext parseContext, ParseResp parseResp) {
        long parseStartTime = parseResp.getParseTimeCost().getParseStartTime();
        parseResp
                .getParseTimeCost()
                .setParseTime(
                        System.currentTimeMillis()
                                - parseStartTime
                                - parseResp.getParseTimeCost().getSqlTime());
    }
}
