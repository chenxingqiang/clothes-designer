package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.ItemDateResp;
import com.iechor.clothesdesigner.common.pojo.enums.AuthType;
import com.iechor.clothesdesigner.headless.api.pojo.ItemDateFilter;
import com.iechor.clothesdesigner.headless.api.pojo.MetaFilter;
import com.iechor.clothesdesigner.headless.api.pojo.request.FieldRemovedReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.MetaBatchReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.ModelReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.DatabaseResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ModelResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.UnAvailableItemResp;
import com.iechor.clothesdesigner.headless.server.pojo.ModelFilter;

import java.util.List;
import java.util.Map;

public interface ModelService {
    ModelResp createModel(ModelReq datasourceReq, User user) throws Exception;

    ModelResp updateModel(ModelReq datasourceReq, User user) throws Exception;

    List<ModelResp> getModelList(MetaFilter metaFilter);

    Map<Long, ModelResp> getModelMap(ModelFilter modelFilter);

    void deleteModel(Long id, User user);

    ItemDateResp getItemDate(ItemDateFilter dimension, ItemDateFilter metric);

    UnAvailableItemResp getUnAvailableItem(FieldRemovedReq fieldRemovedReq);

    List<ModelResp> getModelListWithAuth(User user, Long domainId, AuthType authType);

    List<ModelResp> getModelAuthList(User user, Long domainId, AuthType authTypeEnum);

    List<ModelResp> getModelByDomainIds(List<Long> domainIds);

    List<ModelResp> getAllModelByDomainIds(List<Long> domainIds);

    ModelResp getModel(Long id);

    List<String> getModelAdmin(Long id);

    DatabaseResp getDatabaseByModelId(Long modelId);

    void batchUpdateStatus(MetaBatchReq metaBatchReq, User user);
}
