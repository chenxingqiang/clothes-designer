package com.iechor.clothesdesigner.headless.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.DataEvent;
import com.iechor.clothesdesigner.common.pojo.enums.EventType;
import com.iechor.clothesdesigner.headless.api.pojo.DimValueMap;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.DimensionReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.MetaBatchReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.PageDimensionReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DimensionResp;
import com.iechor.clothesdesigner.headless.server.pojo.DimensionsFilter;

import java.util.List;

public interface DimensionService {
    List<DimensionResp> getDimensions(MetaFilter metaFilter);

    DimensionResp getDimension(String bizName, Long modelId);

    DimensionResp getDimension(Long id);

    void batchUpdateStatus(MetaBatchReq metaBatchReq, User user);

    DimensionResp createDimension(DimensionReq dimensionReq, User user) throws Exception;

    void createDimensionBatch(List<DimensionReq> dimensionReqs, User user) throws Exception;

    void updateDimension(DimensionReq dimensionReq, User user) throws Exception;

    PageInfo<DimensionResp> queryDimension(PageDimensionReq pageDimensionReq);

    List<DimensionResp> queryDimensions(DimensionsFilter dimensionsFilter);

    void batchUpdateSensitiveLevel(MetaBatchReq metaBatchReq, User user);

    void deleteDimension(Long id, User user);

    List<DimensionResp> getDimensionInModelCluster(Long modelId);

    List<String> mockAlias(DimensionReq dimensionReq, String mockType, User user);

    List<DimValueMap> mockDimensionValueAlias(DimensionReq dimensionReq, User user);

    void sendDimensionEventBatch(List<Long> modelIds, EventType eventType);

    DataEvent getDataEvent();
}
