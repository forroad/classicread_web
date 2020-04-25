package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment,String> {
    List<Comment> findByDiscussId(String discussId);
    @Query(nativeQuery = true,value = "SELECT * from comment WHERE discuss_id IN (SELECT discuss_id from discuss WHERE user_id = ?1);")
    List<Comment> findAllCommentByUserDiscuss(String userId);
}
