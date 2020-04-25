package com.ycjw.classicread.service.impl;

import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.community.Collections;
import com.ycjw.classicread.model.community.Comment;
import com.ycjw.classicread.model.community.Community;
import com.ycjw.classicread.model.community.Discuss;
import com.ycjw.classicread.repository.book.BookDao;
import com.ycjw.classicread.repository.book.BookEMDao;
import com.ycjw.classicread.repository.community.*;
import com.ycjw.classicread.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    private CommunityDao communityDao;
    private DiscussDao discussDao;
    private CommentDao commentDao;
    private CollectionsDao collectionsDao;
    private CAdminDao cAdminDao;
    private BookDao bookDao;

    @Autowired
    public CommunityServiceImpl(CommunityDao communityDao, DiscussDao discussDao, CommentDao commentDao, CollectionsDao collectionsDao, CAdminDao cAdminDao, BookDao bookDao) {
        this.communityDao = communityDao;
        this.discussDao = discussDao;
        this.commentDao = commentDao;
        this.collectionsDao = collectionsDao;
        this.cAdminDao = cAdminDao;
        this.bookDao = bookDao;
    }

    @Override
    public Community findOneCommunity(String bookId) {
        Community community = communityDao.findByBookId(bookId);
        if (community == null){
            community = communityDao.save(new Community(System.currentTimeMillis() + "",bookId));
        }
        return community;
    }

    @Override
    public Discuss publishOneDiscuss(String userId, String communityId, String discussInfo) {
        Discuss discuss = new Discuss();
        discuss.setDiscussId(System.currentTimeMillis() + "");
        discuss.setUserId(userId);
        discuss.setCommunityId(communityId);
        discuss.setPublishDate(new Date());
        discuss.setDiscussInfo(discussInfo);
        discuss.setAppreciateNum(0);
        return discussDao.save(discuss);
    }

    @Override
    public Discuss addDiscussAppreciate(String discussId) {
        Discuss discuss = discussDao.findById(discussId).orElse(null);
        if(discuss == null){
            return null;
        }
        discuss.setAppreciateNum(discuss.getAppreciateNum() + 1);
        return discussDao.save(discuss);
    }

    @Override
    public Comment publishOneComment(String userId, String discussId, String commentInfo) {
        Comment comment = new Comment(System.currentTimeMillis() + "",discussId,userId,commentInfo,0);
        return commentDao.save(comment);
    }

    @Override
    public Comment addCommentAppreciate(String commentId) {
        Comment comment = commentDao.findById(commentId).orElse(null);
        if (comment == null){
            return null;
        }
        comment.setAppreciateNum(comment.getAppreciateNum() + 1);
        return commentDao.save(comment);
    }

    @Override
    public Collections addCollection(String userId, String discussId) {
        Collections collections = collectionsDao.findByUserId(userId);
        if(collections == null){
            collections = collectionsDao.save(new Collections(System.currentTimeMillis() + "",userId,new ArrayList<String>()));
        }
        if(!collections.getCollectionsId().contains(discussId)){
            collections.addDiscussId(discussId);
        }
        return collectionsDao.save(collections);
    }

    @Override
    public Collections findOneCollection(String userId) {
        Collections collections = collectionsDao.findByUserId(userId);
        if(collections == null){
            collections = collectionsDao.save(new Collections(System.currentTimeMillis() + "",userId,new ArrayList<String>()));
        }
        return collections;
    }

    @Override
    public List<Discuss> findAllDIscuss(String communityId) {
        return discussDao.findByCommunityId(communityId);
    }

    @Override
    public List<Comment> findAllComment(String discussId) {
        return commentDao.findByDiscussId(discussId);
    }

    @Override
    public Discuss findOneDiscuss(String discussId) {
        return discussDao.findById(discussId).orElse(null);
    }

    @Override
    public List<Comment> findAllCommentByUserDiscuss(String userId) {
        return commentDao.findAllCommentByUserDiscuss(userId);
    }

    @Override
    public int findPublishNum(String userId, String bookId) {
        Community community = communityDao.findByBookId(bookId);
        return discussDao.countAllByUserIdAndCommunityId(userId,bookId);
    }

    @Override
    public List<Book> findAllPublishBook(String userId){
        BookEMDao bookEMDao = new BookEMDao(bookDao,communityDao);
        return bookEMDao.findBooksByPublish(userId);
    }

    @Override
    public List<Discuss> findAllDiscussByBookId(String bookId) {
        Community community = communityDao.findByBookId(bookId);
        return findAllDIscuss(community.getCommunityId());
    }

    @Override
    public List<Discuss> findAllDiscussByCollection(String userId) {
        Collections collections = collectionsDao.findByUserId(userId);
        List<String> ids = collections == null ? new ArrayList<>() : collections.getDiscussIds();
        return discussDao.findAllById(ids);
    }
}
