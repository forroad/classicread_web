package com.ycjw.classicread.controller;

import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.community.Collections;
import com.ycjw.classicread.model.community.Comment;
import com.ycjw.classicread.model.community.Community;
import com.ycjw.classicread.model.community.Discuss;
import com.ycjw.classicread.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("community")
public class CommunityConstroller {
    private CommunityService communityService;

    @Autowired
    public CommunityConstroller(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("findOneCommunity")
    public Community findOneCommunity(String bookId){
        return communityService.findOneCommunity(bookId);
    }

    @PostMapping("publishOneDiscuss")
    Discuss publishOneDiscuss(String userId, String communityId, String discussInfo){
        return communityService.publishOneDiscuss(userId, communityId, discussInfo);
    }

    @PostMapping("addDiscussAppreciate")
    Discuss addDiscussAppreciate(String discussId){
        return communityService.addDiscussAppreciate(discussId);
    }

    @PostMapping("findAllDiscuss")
    List<Discuss> findAllDIscuss(String communityId){
        return communityService.findAllDIscuss(communityId);
    }

    @PostMapping("findAllDiscussByBookId")
    List<Discuss> findAllDiscussByBookId(String bookId){
        return communityService.findAllDiscussByBookId(bookId);
    }

    @PostMapping("findAllComment")
    List<Comment> findAllComment(String discussId){
        return communityService.findAllComment(discussId);
    }

    @PostMapping("publishOneComment")
    Comment publishOneComment(String userId, String discussId, String commentInfo){
        return communityService.publishOneComment(userId, discussId, commentInfo);
    }

    @PostMapping("addCommentAppreciate")
    Comment addCommentAppreciate(String commentId){
        return communityService.addCommentAppreciate(commentId);
    }

    @PostMapping("addCollection")
    Collections addCollection(String userId, String discussId){
        return communityService.addCollection(userId, discussId);
    }

    @PostMapping("findOneCollection")
    Collections findOneCollection(String userId){
        return communityService.findOneCollection(userId);
    }

    @PostMapping("findOneDiscuss")
    Discuss findOneDiscuss(String discussId){
        return communityService.findOneDiscuss(discussId);
    }

    @PostMapping("findAllCommentByUserDiscuss")
    List<Comment> findAllCommentByUserDiscuss(String userId){
        return communityService.findAllCommentByUserDiscuss(userId);
    }

    @PostMapping("findPublishNum")
    Integer findPublishNum(String userId,String bookId){
        return communityService.findPublishNum(userId,bookId);
    }

    @PostMapping("findAllPublishBook")
    List<Book> findAllPublishBook(String userId){
        return communityService.findAllPublishBook(userId);
    }

    @PostMapping("findAllDiscussByCollection")
    List<Discuss> findAllDiscussByCollection(String userId){
        return communityService.findAllDiscussByCollection(userId);
    }
}
