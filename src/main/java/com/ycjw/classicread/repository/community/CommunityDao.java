package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityDao extends JpaRepository<Community,String> {
    Community findByBookId(String bookId);

    @Query(nativeQuery = true,value = "SELECT book_id FROM community WHERE community_id IN (SELECT community_id FROM discuss WHERE user_id = ?1)")
    List<String> findBookIdsByPublish(String userId);
}
