package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityDao extends JpaRepository<Community,String> {
    Community findByBookId(String bookId);
}
