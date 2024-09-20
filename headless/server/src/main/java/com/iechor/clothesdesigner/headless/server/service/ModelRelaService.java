package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.ModelRela;

import java.util.List;

public interface ModelRelaService {
    void save(ModelRela modelRela, User user);

    void update(ModelRela modelRela, User user);

    List<ModelRela> getModelRelaList(Long domainId);

    List<ModelRela> getModelRela(List<Long> modelIds);

    void delete(Long id);
}
