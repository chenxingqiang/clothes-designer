package com.iechor.clothesdesigner.headless;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.DimensionValueReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.SemanticQueryResp;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QueryDimensionTest extends BaseTest {

    @Test
    public void testQueryDimValue() {
        DimensionValueReq queryDimValueReq = new DimensionValueReq();
        queryDimValueReq.setModelId(1L);
        queryDimValueReq.setBizName("department");

        SemanticQueryResp queryResp =
                semanticLayerService.queryDimensionValue(queryDimValueReq, User.getFakeUser());
        Assert.assertNotNull(queryResp.getResultList());
        Assert.assertEquals(4, queryResp.getResultList().size());
    }
}
