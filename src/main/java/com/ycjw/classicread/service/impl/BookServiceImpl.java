package com.ycjw.classicread.service.impl;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.Chapter;
import com.ycjw.classicread.repository.book.BookDao;
import com.ycjw.classicread.repository.book.ChapterDao;
import com.ycjw.classicread.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private ChapterDao chapterDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao, ChapterDao chapterDao) {
        this.bookDao = bookDao;
        this.chapterDao = chapterDao;
    }

    @Override
    public Page<Book> findAllBook(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    @Override
    public Book findOneBook(String bookId) {
        return bookDao.findById(bookId).orElse(null);
    }

    @Override
    public Chapter findOneChapter(String chapterId) {
        return chapterDao.findById(chapterId).orElse(null);
    }

    @Override
    public List<Chapter> findAllChapter(String bookId) throws ExceptionZyc {
        List<String> nameList = chapterDao.findAllNameByChapterId(bookId);
        List<String> idList = chapterDao.findAllIdByBookId(bookId);
        List<Chapter> chapters = new ArrayList<>();
        for (int i = 0;i < nameList.size();i++){
            Chapter chapter = new Chapter();
            chapter.setChapterId(idList.get(i));
            chapter.setChapterName(nameList.get(i));
            chapters.add(chapter);
        }
        return chapters;
    }

    @Override
    public Page<Book> findBookByNameLike(String bookName, Pageable pageable) {
        return bookDao.findByBookNameLike(addLikeSymnol(bookName),pageable);
    }

    @Override
    public Page<Book> findBookByAuthorLike(String author, Pageable pageable) {
        return bookDao.findByBookAuthorLike(addLikeSymnol(author),pageable);
    }

    @Override
    public Page<Book> findBookByNameLikeOrAuthorLike(String query_info, Pageable pageable) {
        return bookDao.findByBookNameLikeOrBookAuthorLike(addLikeSymnol(query_info),addLikeSymnol(query_info),pageable);
    }

    private String addLikeSymnol(String text){
        return "%" + text + "%";
    }
}
