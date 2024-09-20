package com.iechor.clothesdesigner.headless;

import com.google.common.collect.Lists;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.common.pojo.enums.AuthType;
import com.iechor.clothesdesigner.headless.api.pojo.response.DataSetResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.DomainResp;
import com.iechor.clothesdesigner.headless.api.pojo.response.ModelResp;
import com.iechor.clothesdesigner.headless.server.service.DataSetService;
import com.iechor.clothesdesigner.headless.server.service.DomainService;
import com.iechor.clothesdesigner.headless.server.service.ModelService;
import com.iechor.clothesdesigner.util.DataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SchemaAuthTest extends BaseTest {

    @Autowired private DomainService domainService;

    @Autowired private DataSetService dataSetService;

    @Autowired private ModelService modelService;

    @Test
    public void test_getDomainList_alice() {
        User user = DataUtils.getUserAlice();
        setDomainNotOpenToAll();
        List<DomainResp> domainResps = domainService.getDomainListWithAdminAuth(user);
        List<String> expectedDomainBizNames = Lists.newArrayList("clothesdesigner", "singer");
        Assertions.assertEquals(
                expectedDomainBizNames,
                domainResps.stream().map(DomainResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getModelList_alice() {
        User user = DataUtils.getUserAlice();
        List<ModelResp> modelResps = modelService.getModelListWithAuth(user, null, AuthType.ADMIN);
        List<String> expectedModelBizNames = Lists.newArrayList("user_department", "singer");
        Assertions.assertEquals(
                expectedModelBizNames,
                modelResps.stream().map(ModelResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getVisibleModelList_alice() {
        User user = DataUtils.getUserAlice();
        List<ModelResp> modelResps =
                modelService.getModelListWithAuth(user, null, AuthType.VISIBLE);
        List<String> expectedModelBizNames = Lists.newArrayList("user_department", "singer");
        Assertions.assertEquals(
                expectedModelBizNames,
                modelResps.stream().map(ModelResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getDataSetList_alice() {
        User user = DataUtils.getUserAlice();
        List<DataSetResp> dataSetResps = dataSetService.getDataSetsInheritAuth(user, 0L);
        List<String> expectedDataSetBizNames = Lists.newArrayList("singer");
        Assertions.assertEquals(
                expectedDataSetBizNames,
                dataSetResps.stream().map(DataSetResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getDomainList_jack() {
        User user = DataUtils.getUserJack();
        List<DomainResp> domainResps = domainService.getDomainListWithAdminAuth(user);
        List<String> expectedDomainBizNames = Lists.newArrayList("clothesdesigner");
        Assertions.assertEquals(
                expectedDomainBizNames,
                domainResps.stream().map(DomainResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getModelList_jack() {
        User user = DataUtils.getUserJack();
        List<ModelResp> modelResps = modelService.getModelListWithAuth(user, null, AuthType.ADMIN);
        List<String> expectedModelBizNames =
                Lists.newArrayList("user_department", "s2_pv_uv_statis", "s2_stay_time_statis");
        Assertions.assertEquals(
                expectedModelBizNames,
                modelResps.stream().map(ModelResp::getBizName).collect(Collectors.toList()));
    }

    @Test
    public void test_getDataSetList_jack() {
        User user = DataUtils.getUserJack();
        List<DataSetResp> dataSetResps = dataSetService.getDataSetsInheritAuth(user, 0L);
        List<String> expectedDataSetBizNames = Lists.newArrayList("s2", "singer");
        Assertions.assertEquals(
                expectedDataSetBizNames,
                dataSetResps.stream().map(DataSetResp::getBizName).collect(Collectors.toList()));
    }
}
