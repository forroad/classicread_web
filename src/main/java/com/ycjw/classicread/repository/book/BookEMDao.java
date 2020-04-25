package com.ycjw.classicread.repository.book;

import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.repository.community.CommunityDao;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class BookEMDao {
    private BookDao bookDao;
    private CommunityDao communityDao;

    public BookEMDao(BookDao bookDao, CommunityDao communityDao) {
        this.bookDao = bookDao;
        this.communityDao = communityDao;
    }

    public List<Book> findBooksByPublish(String userId){
        List<String> bookIds = communityDao.findBookIdsByPublish(userId);
        if(bookIds == null){
            return new ArrayList<>();
        }
        return (List<Book>) bookDao.findAllById(bookIds);
    }

}
