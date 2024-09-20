package com.iechor.clothesdesigner.headless.server.utils;

import com.iechor.clothesdesigner.common.pojo.Aggregator;
import com.iechor.clothesdesigner.common.pojo.DateConf;
import com.iechor.clothesdesigner.common.pojo.DateConf.DateMode;
import com.iechor.clothesdesigner.common.pojo.Order;
import com.iechor.clothesdesigner.common.pojo.enums.AggOperatorEnum;
import com.iechor.clothesdesigner.common.pojo.enums.QueryType;
import com.iechor.clothesdesigner.common.util.ContextUtils;
import com.iechor.clothesdesigner.common.util.DateModeUtils;
import com.iechor.clothesdesigner.common.util.SqlFilterUtils;
import com.iechor.clothesdesigner.headless.api.pojo.request.QuerySqlReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryStructReq;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** QueryNLReqBuilderTest */
class QueryNLReqBuilderTest {

    @Test
    void buildS2SQLReq() {
        init();
        QueryStructReq queryStructReq = new QueryStructReq();
        queryStructReq.setDataSetId(1L);
        queryStructReq.setDataSetName("内容库");
        queryStructReq.setQueryType(QueryType.METRIC);

        Aggregator aggregator = new Aggregator();
        aggregator.setFunc(AggOperatorEnum.UNKNOWN);
        aggregator.setColumn("pv");
        queryStructReq.setAggregators(Arrays.asList(aggregator));

        queryStructReq.setGroups(Arrays.asList("department"));

        DateConf dateConf = new DateConf();
        dateConf.setDateMode(DateMode.LIST);
        dateConf.setDateList(Arrays.asList("2023-08-01"));
        queryStructReq.setDateInfo(dateConf);

        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setColumn("uv");
        orders.add(order);
        queryStructReq.setOrders(orders);

        QuerySqlReq querySQLReq = queryStructReq.convert();
        Assert.assertEquals(
                "SELECT department, SUM(pv) AS pv FROM 内容库 "
                        + "WHERE (sys_imp_date IN ('2023-08-01')) GROUP "
                        + "BY department ORDER BY uv LIMIT 2000",
                querySQLReq.getSql());

        queryStructReq.setQueryType(QueryType.DETAIL);
        querySQLReq = queryStructReq.convert();
        Assert.assertEquals(
                "SELECT department, pv FROM 内容库 WHERE (sys_imp_date IN ('2023-08-01')) "
                        + "ORDER BY uv LIMIT 2000",
                querySQLReq.getSql());
    }

    private void init() {
        MockedStatic<ContextUtils> mockContextUtils = Mockito.mockStatic(ContextUtils.class);
        SqlFilterUtils sqlFilterUtils = new SqlFilterUtils();
        mockContextUtils
                .when(() -> ContextUtils.getBean(SqlFilterUtils.class))
                .thenReturn(sqlFilterUtils);
        DateModeUtils dateModeUtils = new DateModeUtils();
        mockContextUtils
                .when(() -> ContextUtils.getBean(DateModeUtils.class))
                .thenReturn(dateModeUtils);
        dateModeUtils.setSysDateCol("sys_imp_date");
        dateModeUtils.setSysDateWeekCol("sys_imp_week");
        dateModeUtils.setSysDateMonthCol("sys_imp_month");
    }
}
