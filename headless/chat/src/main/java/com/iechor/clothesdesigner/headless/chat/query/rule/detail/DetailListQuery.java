package com.iechor.clothesdesigner.headless.chat.query.rule.detail;

import com.iechor.clothesdesigner.common.pojo.Constants;
import com.iechor.clothesdesigner.common.pojo.Order;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElement;
import com.iechor.clothesdesigner.headless.api.pojo.SchemaElementType;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.TagTypeDefaultConfig;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class DetailListQuery extends DetailSemanticQuery {

    @Override
    public void fillParseInfo(ChatQueryContext chatQueryContext) {
        super.fillParseInfo(chatQueryContext);
        this.addEntityDetailAndOrderByMetric(chatQueryContext, parseInfo);
    }

    private void addEntityDetailAndOrderByMetric(
            ChatQueryContext chatQueryContext, SemanticParseInfo parseInfo) {
        Long dataSetId = parseInfo.getDataSetId();
        if (Objects.isNull(dataSetId) || dataSetId <= 0L) {
            return;
        }
        DataSetSchema dataSetSchema =
                chatQueryContext.getSemanticSchema().getDataSetSchemaMap().get(dataSetId);
        if (dataSetSchema != null && Objects.nonNull(dataSetSchema.getEntity())) {
            Set<SchemaElement> dimensions = new LinkedHashSet<>();
            Set<SchemaElement> metrics = new LinkedHashSet<>();
            Set<Order> orders = new LinkedHashSet<>();
            TagTypeDefaultConfig tagTypeDefaultConfig = dataSetSchema.getTagTypeDefaultConfig();
            if (tagTypeDefaultConfig != null
                    && tagTypeDefaultConfig.getDefaultDisplayInfo() != null) {
                if (CollectionUtils.isNotEmpty(
                        tagTypeDefaultConfig.getDefaultDisplayInfo().getMetricIds())) {
                    metrics =
                            tagTypeDefaultConfig.getDefaultDisplayInfo().getMetricIds().stream()
                                    .map(
                                            id -> {
                                                SchemaElement metric =
                                                        dataSetSchema.getElement(
                                                                SchemaElementType.METRIC, id);
                                                if (metric != null) {
                                                    orders.add(
                                                            new Order(
                                                                    metric.getBizName(),
                                                                    Constants.DESC_UPPER));
                                                }
                                                return metric;
                                            })
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toSet());
                }
                if (CollectionUtils.isNotEmpty(
                        tagTypeDefaultConfig.getDefaultDisplayInfo().getDimensionIds())) {
                    dimensions =
                            tagTypeDefaultConfig.getDefaultDisplayInfo().getDimensionIds().stream()
                                    .map(
                                            id ->
                                                    dataSetSchema.getElement(
                                                            SchemaElementType.DIMENSION, id))
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toSet());
                }
            }
            parseInfo.setDimensions(dimensions);
            parseInfo.setMetrics(metrics);
            parseInfo.setOrders(orders);
        }
    }
}
