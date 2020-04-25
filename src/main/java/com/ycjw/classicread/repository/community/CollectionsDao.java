package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.Collections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionsDao extends JpaRepository<Collections,String> {
    Collections findByUserId(String userId);
}
