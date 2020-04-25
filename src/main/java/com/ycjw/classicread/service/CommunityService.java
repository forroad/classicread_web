package com.ycjw.classicread.service;

import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.community.*;

import java.util.List;

public interface CommunityService {
    Community findOneCommunity(String bookId);

    Discuss findOneDiscuss(String discussId);

    Discuss publishOneDiscuss(String userId, String communityId, String discussInfo);

    Discuss addDiscussAppreciate(String discussId);

    List<Discuss> findAllDIscuss(String communityId);

    List<Comment> findAllComment(String discussId);

    Comment publishOneComment(String userId, String discussId, String commentInfo);

    Comment addCommentAppreciate(String commentId);

    Collections addCollection(String userId,String discussId);

    Collections findOneCollection(String userId);

    List<Comment> findAllCommentByUserDiscuss(String userId);

    int findPublishNum(String userId,String bookId);

    List<Book> findAllPublishBook(String userId);

    List<Discuss> findAllDiscussByBookId(String bookId);

    List<Discuss> findAllDiscussByCollection(String userId);
}