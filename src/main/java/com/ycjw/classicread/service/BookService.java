package com.ycjw.classicread.service;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    /**
     * 查询所有数据
     * @return
     */
    Page<Book> findAllBook(Pageable pageable);

    /**
     * 查询某本书
     * @param bookId 书籍id
     * @return 书籍实体
     */
    Book findOneBook(String bookId);

    /**
     * 查询章节
     */
    Chapter findOneChapter(String chapterId);

    List<Chapter> findAllChapter(String bookId) throws ExceptionZyc;

    /**
     * 模糊查询书籍
     * @param bookName 书籍名字
     * @return 查询结果
     */
    Page<Book> findBookByNameLike(String bookName,Pageable pageable);

    /**
     * 通过作者模糊查询书籍
     * @param author 作者名字
     * @return 查询结果
     */
    Page<Book> findBookByAuthorLike(String author,Pageable pageable);

    /**
     * 通过书籍名字和作者模糊查询书籍
     * @param query_info 查询内容
     * @return 查询结果
     */
    Page<Book> findBookByNameLikeOrAuthorLike(String query_info,Pageable pageable);
}
