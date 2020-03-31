package com.ycjw.classicread.service;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.BookRack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRackService {
    /**
     * 获取用户所有的置顶书籍
     * @param user_id 用户id
     * @return 查询结果
     */
    List<Book> getAllImportantBooks(String user_id);

    /**
     * 获取用户未置顶书籍
     */
    List<Book> getAllNormalBooks(String user_id);

    /**
     * 查询用户书架实体
     * @param user_id 用户手机号
     * @return 查询结果
     */
    BookRack getOneBookRack(String user_id);

    /**
     * 用户将书添加书架
     */
    BookRack addBookRack(String user_id,String book_id) throws ExceptionZyc;

    /**
     * 用户将书架中的书籍置顶
     */
    BookRack setImportantBook(String user_id,String book_id) throws ExceptionZyc;

    /**
     * 取消置顶
     */
    BookRack setNormalBook(String user_id,String book_id) throws ExceptionZyc;

    /**
     * 置顶/取消置顶
     * @param user_id 用户id
     * @param book_id 书架实体
     * @return 修改后的书架实体
     * @throws ExceptionZyc possible exception
     */
    BookRack top_untop(String user_id,String book_id) throws ExceptionZyc;

    /**
     * 用户将书移除书架
     */
    BookRack deleteBookFromBookRack(String user_id,String book_id) throws ExceptionZyc;
}
