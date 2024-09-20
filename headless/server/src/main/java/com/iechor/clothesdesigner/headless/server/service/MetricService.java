package com.iechor.clothesdesigner.headless.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.DataEvent;
import com.iechor.clothesdesigner.common.pojo.enums.EventType;
import com.iechor.clothesdesigner.headless.api.pojo.DrillDownDimension;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.MetricQueryDefaultConfig;
import com.iechor.clothesdesigner.headless.api.pojo.request.MetaBatchReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.MetricBaseReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.MetricReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.PageMetricReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryMetricReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryStructReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.MetricResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ModelResp;
import com.iechor.clothesdesigner.headless.server.pojo.MetricsFilter;

import java.util.List;
import java.util.Set;

public interface MetricService {
    MetricResp createMetric(MetricReq metricReq, User user) throws Exception;

    void createMetricBatch(List<MetricReq> metricReqs, User user) throws Exception;

    MetricResp updateMetric(MetricReq metricReq, User user) throws Exception;

    void batchUpdateStatus(MetaBatchReq metaBatchReq, User user);

    void batchPublish(List<Long> metricIds, User user);

    void batchUnPublish(List<Long> metricIds, User user);

    void batchUpdateClassifications(MetaBatchReq metaBatchReq, User user);

    void batchUpdateSensitiveLevel(MetaBatchReq metaBatchReq, User user);

    void deleteMetric(Long id, User user) throws Exception;

    PageInfo<MetricResp> queryMetricMarket(PageMetricReq pageMetricReq, User user);

    PageInfo<MetricResp> queryMetric(PageMetricReq pageMetricReq, User user);

    List<MetricResp> getMetrics(MetaFilter metaFilter);

    List<MetricResp> getMetricsToCreateNewMetric(Long modelId);

    MetricResp getMetric(Long modelId, String bizName);

    MetricResp getMetric(Long id, User user);

    MetricResp getMetric(Long id);

    List<String> mockAlias(MetricBaseReq metricReq, String mockType, User user);

    Set<String> getMetricTags();

    List<DrillDownDimension> getDrillDownDimension(Long metricId);

    void saveMetricQueryDefaultConfig(MetricQueryDefaultConfig defaultConfig, User user);

    MetricQueryDefaultConfig getMetricQueryDefaultConfig(Long metricId, User user);

    void sendMetricEventBatch(List<Long> modelIds, EventType eventType);

    List<MetricResp> queryMetrics(MetricsFilter metricsFilter);

    void batchFillMetricDefaultAgg(List<MetricResp> metricResps, List<ModelResp> modelResps);

    QueryStructReq convert(QueryMetricReq queryMetricReq);

    DataEvent getDataEvent();
}
