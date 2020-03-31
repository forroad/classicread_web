package com.ycjw.classicread.repository.book;

import com.ycjw.classicread.model.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,String> {
    /**
     * 通过书名直接查询书籍
     * @param bookName 书名
     * @return 查询结果
     */
    Book findByBookName(String bookName);

    /**
     *  通过书名模糊查询书籍
     * @param bookName 书名
     */
    Page<Book> findByBookNameLike(String bookName, Pageable pageable);

    /**
     * 通过作者模糊查询书籍
     * @param bookAuthor 作者
     * @return 查询结果
     */
    Page<Book> findByBookAuthorLike(String bookAuthor,Pageable pageable);

    /**
     * 通过书名和作者模糊查询
     * @param BookName 书名
     * @param bookAuthor 作者
     * @return 查询结果
     */
    Page<Book> findByBookNameLikeOrBookAuthorLike(String BookName,String bookAuthor,Pageable pageable);
}
