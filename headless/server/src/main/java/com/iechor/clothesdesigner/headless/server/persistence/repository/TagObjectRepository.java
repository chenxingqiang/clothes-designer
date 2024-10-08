package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.server.persistence.dataobject.TagObjectDO;
import com.iechor.clothesdesigner.headless.server.pojo.TagObjectFilter;

import java.util.List;

public interface TagObjectRepository {
    Integer create(TagObjectDO tagObjectDO);

    Integer update(TagObjectDO tagObjectDO);

    TagObjectDO getTagObjectById(Long id);

    List<TagObjectDO> query(TagObjectFilter filter);
}
