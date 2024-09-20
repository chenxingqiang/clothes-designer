package com.iechor.clothesdesigner.headless.chat.query.rule.metric;

import com.iechor.clothesdesigner.common.pojo.Constants;
import com.iechor.clothesdesigner.common.pojo.Order;
import com.iechor.clothesdesigner.common.pojo.enums.AggregateTypeEnum;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElement;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElementMatch;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.iechor.clothesdesigner.headless.api.pojo.SchemaElementType.DIMENSION;
import static com.iechor.clothesdesigner.headless.api.pojo.SchemaElementType.VALUE;
import static com.iechor.clothesdesigner.headless.chat.query.rule.QueryMatchOption.OptionType.OPTIONAL;
import static com.iechor.clothesdesigner.headless.chat.query.rule.QueryMatchOption.OptionType.REQUIRED;
import static com.iechor.clothesdesigner.headless.chat.query.rule.QueryMatchOption.RequireNumberType.AT_LEAST;

@Component
public class MetricTopNQuery extends MetricSemanticQuery {

    public static final String QUERY_MODE = "METRIC_ORDERBY";
    private static final Long ORDERBY_MAX_RESULTS = 3L;
    private static final Pattern INTENT_PATTERN = Pattern.compile("(.*)(最大|最高|最多)(.*)");

    public MetricTopNQuery() {
        super();
        queryMatcher.addOption(DIMENSION, REQUIRED, AT_LEAST, 1);
        queryMatcher.addOption(VALUE, OPTIONAL, AT_LEAST, 0);
        queryMatcher.setSupportOrderBy(true);
    }

    @Override
    public List<SchemaElementMatch> match(
            List<SchemaElementMatch> candidateElementMatches, ChatQueryContext queryCtx) {
        Matcher matcher = INTENT_PATTERN.matcher(queryCtx.getQueryText());
        if (matcher.matches()) {
            return super.match(candidateElementMatches, queryCtx);
        }
        return new ArrayList<>();
    }

    @Override
    public String getQueryMode() {
        return QUERY_MODE;
    }

    @Override
    public void fillParseInfo(ChatQueryContext chatQueryContext) {
        super.fillParseInfo(chatQueryContext);

        parseInfo.setLimit(ORDERBY_MAX_RESULTS);
        parseInfo.setScore(parseInfo.getScore() + 2.0);
        parseInfo.setAggType(AggregateTypeEnum.SUM);

        SchemaElement metric = parseInfo.getMetrics().iterator().next();
        parseInfo.getOrders().add(new Order(metric.getBizName(), Constants.DESC_UPPER));
    }
}
