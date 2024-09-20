package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.ItemDateResp;
import com.iechor.clothesdesigner.common.pojo.enums.AuthType;
import com.iechor.clothesdesigner.headless.api.pojo.DataSetSchema;
import com.iechor.clothesdesigner.headless.api.pojo.ItemDateFilter;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.SemanticSchema;
import com.iechor.clothesdesigner.headless.api.pojo.request.ItemUseReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.SchemaFilterReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DatabaseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.DimensionResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.DomainResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ItemResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ItemUseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.MetricResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ModelResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ModelSchemaResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticSchemaResp;
import com.iechor.clothesdesigner.headless.server.pojo.yaml.DataModelYamlTpl;
import com.iechor.clothesdesigner.headless.server.pojo.yaml.DimensionYamlTpl;
import com.iechor.clothesdesigner.headless.server.pojo.yaml.MetricYamlTpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface SchemaService {
    DataSetSchema getDataSetSchema(Long dataSetId);

    SemanticSchema getSemanticSchema();

    SemanticSchema getSemanticSchema(Set<Long> dataSetIds);

    SemanticSchemaResp fetchSemanticSchema(SchemaFilterReq schemaFilterReq);

    List<ModelSchemaResp> fetchModelSchemaResps(List<Long> modelIds);

    List<DimensionResp> getDimensions(MetaFilter metaFilter);

    DimensionResp getDimension(String bizName, Long modelId);

    DimensionResp getDimension(Long id);

    List<MetricResp> getMetrics(MetaFilter metaFilter);

    List<DomainResp> getDomainList(User user);

    List<ModelResp> getModelList(User user, AuthType authType, Long domainId);

    List<ModelResp> getModelList(List<Long> modelIds);

    List<ItemUseResp> getStatInfo(ItemUseReq itemUseReq) throws ExecutionException;

    List<ItemResp> getDomainDataSetTree();

    void getSchemaYamlTpl(
            SemanticSchemaResp semanticSchemaResp,
            Map<String, List<DimensionYamlTpl>> dimensionYamlMap,
            List<DataModelYamlTpl> dataModelYamlTplList,
            List<MetricYamlTpl> metricYamlTplList,
            Map<Long, String> modelIdName);

    ItemDateResp getItemDate(ItemDateFilter dimension, ItemDateFilter metric);

    DatabaseResp getDatabase(Long id);
}
