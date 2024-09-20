package com.iechor.clothesdesigner.headless.server.facade.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.EntityInfo;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.api.pojo.request.DimensionValueReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.SemanticQueryReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DimensionResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ItemResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.MetricResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticTranslateResp;

import java.util.List;

/** This interface abstracts functionalities provided by a semantic layer. */
public interface SemanticLayerService {
    DataSetSchema getDataSetSchema(Long id);

    SemanticTranslateResp translate(SemanticQueryReq queryReq, User user) throws Exception;

    SemanticQueryResp queryByReq(SemanticQueryReq queryReq, User user) throws Exception;

    SemanticQueryResp queryDimensionValue(DimensionValueReq dimensionValueReq, User user);

    EntityInfo getEntityInfo(SemanticParseInfo parseInfo, DataSetSchema dataSetSchema, User user);

    List<ItemResp> getDomainDataSetTree();

    List<DimensionResp> getDimensions(MetaFilter metaFilter);

    List<MetricResp> getMetrics(MetaFilter metaFilter);
}
