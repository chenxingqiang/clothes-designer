package com.iechor.clothesdesigner.headless.server.persistence.mapper;

import com.iechor.clothesdesigner.headless.api.pojo.response.TagResp;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.TagDO;
import com.iechor.clothesdesigner.headless.server.pojo.TagFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagCustomMapper {
    List<TagResp> queryTagRespList(TagFilter tagFilter);

    List<TagDO> getTagDOList(TagFilter tagFilter);

    Boolean deleteById(Long id);

    void deleteBatchByIds(List<Long> ids);

    void deleteBatchByType(List<Long> itemIds, String type);
}
