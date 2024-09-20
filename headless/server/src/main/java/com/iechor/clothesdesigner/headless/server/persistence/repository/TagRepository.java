package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.api.pojo.request.TagDeleteReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.TagResp;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.TagDO;
import com.iechor.clothesdesigner.headless.server.pojo.TagFilter;

import java.util.List;

public interface TagRepository {
    Long create(TagDO tagDO);

    void update(TagDO tagDO);

    TagDO getTagById(Long id);

    List<TagDO> getTagDOList(TagFilter tagFilter);

    List<TagResp> queryTagRespList(TagFilter tagFilter);

    Boolean delete(Long id);

    void deleteBatch(TagDeleteReq tagDeleteReq);
}
