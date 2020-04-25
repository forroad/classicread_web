package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussDao extends JpaRepository<Discuss,String> {
    List<Discuss> findByCommunityId(String communityId);

    int countAllByUserIdAndCommunityId(String userId,String communityId);
}
