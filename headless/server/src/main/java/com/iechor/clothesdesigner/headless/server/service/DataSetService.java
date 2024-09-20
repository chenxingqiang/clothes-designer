package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.DataSetReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryDataSetReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.SemanticQueryReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DataSetResp;

import java.util.List;
import java.util.Map;

public interface DataSetService {
    DataSetResp save(DataSetReq dataSetReq, User user);

    DataSetResp update(DataSetReq dataSetReq, User user);

    DataSetResp getDataSet(Long id);

    List<DataSetResp> getDataSetList(MetaFilter metaFilter);

    void delete(Long id, User user);

    Map<Long, List<Long>> getModelIdToDataSetIds(List<Long> dataSetIds, User user);

    Map<Long, List<Long>> getModelIdToDataSetIds();

    List<DataSetResp> getDataSets(String dataSetName, User user);

    List<DataSetResp> getDataSets(List<String> dataSetNames, User user);

    List<DataSetResp> getDataSetsInheritAuth(User user, Long domainId);

    SemanticQueryReq convert(QueryDataSetReq queryDataSetReq);

    Long getDataSetIdFromSql(String sql, User user);
}
