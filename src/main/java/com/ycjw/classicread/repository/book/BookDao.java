package com.ycjw.classicread.repository.book;


import com.ycjw.classicread.model.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends ElasticsearchCrudRepository<Book,String> {
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
    Page<Book> findByBookAuthorLike(String bookAuthor, Pageable pageable);

    /**
     * 通过书名和作者模糊查询
     * @param BookName 书名
     * @param bookAuthor 作者
     * @return 查询结果
     */
    Page<Book> findByBookNameLikeOrBookAuthorLike(String BookName, String bookAuthor, Pageable pageable);

    /**
     * 查询用户在哪些书籍下面发布过评论
     * @param userId 用户id
     * @return 查询结果
     */
//    @Query(nativeQuery = true,value = "SELECT * FROM book WHERE book_id IN (SELECT book_id FROM community WHERE community_id IN (SELECT community_id FROM discuss WHERE user_id = ?1))")
//    List<BookE> findBooksByPublish(String userId);
}
