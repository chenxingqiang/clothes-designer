package com.iechor.clothesdesigner.chat.server.service;

import com.iechor.clothesdesigner.chat.server.persistence.dataobject.StatisticsDO;

import java.util.List;

public interface StatisticsService {
    void batchSaveStatistics(List<StatisticsDO> list);
}
