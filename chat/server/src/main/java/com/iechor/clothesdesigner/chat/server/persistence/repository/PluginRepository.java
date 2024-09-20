package com.iechor.clothesdesigner.chat.server.persistence.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.PluginDO;

import java.util.List;

public interface PluginRepository {
    List<PluginDO> getPlugins();

    List<PluginDO> fetchPluginDOs(String queryText, String type);

    void createPlugin(PluginDO pluginDO);

    void updatePlugin(PluginDO pluginDO);

    PluginDO getPlugin(Long id);

    List<PluginDO> query(QueryWrapper<PluginDO> queryWrapper);

    void deletePlugin(Long id);
}
