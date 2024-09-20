package com.iechor.clothesdesigner.headless.server.persistence.repository;

import com.iechor.clothesdesigner.headless.server.persistence.dataobject.ClassDO;
import com.iechor.clothesdesigner.headless.server.pojo.ClassFilter;

import java.util.List;

public interface ClassRepository {
    Long create(ClassDO classDO);

    Long update(ClassDO classDO);

    Integer delete(List<Long> ids);

    ClassDO getClassById(Long id);

    List<ClassDO> getClassDOList(ClassFilter filter);

    List<ClassDO> getAllClassDOList();
}
