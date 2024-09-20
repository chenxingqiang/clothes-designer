package com.iechor.clothesdesigner.headless.server.service;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.enums.TagDefineType;
import com.iechor.clothesdesigner.headless.api.pojo.request.TagDeleteReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.TagFilterPageReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.TagReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.TagItem;
import com.iechor.clothesdesigner.headless.api.pojo.response.TagResp;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.TagDO;
import com.iechor.clothesdesigner.headless.server.pojo.TagFilter;

import java.util.List;

public interface TagMetaService {
    TagResp create(TagReq tagReq, User user);

    Integer createBatch(List<TagReq> tagReqList, User user);

    Boolean delete(Long id, User user);

    Boolean deleteBatch(List<TagDeleteReq> tagDeleteReqList, User user);

    TagResp getTag(Long id, User user);

    List<TagResp> getTags(TagFilter tagFilter);

    List<TagDO> getTagDOList(TagFilter tagFilter);

    PageInfo<TagResp> queryTagMarketPage(TagFilterPageReq tagMarketPageReq, User user);

    List<TagItem> getTagItems(List<Long> itemIds, TagDefineType tagDefineType);
}
