package com.iechor.clothesdesigner.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iechor.clothesdesigner.common.config.SystemConfig;
import com.iechor.clothesdesigner.common.persistence.dataobject.SystemConfigDO;

public interface SystemConfigService extends IService<SystemConfigDO> {
    SystemConfig getSystemConfig();

    void save(SystemConfig systemConfig);
}
