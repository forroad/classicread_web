package com.ycjw.classicread.controller;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.Chapter;
import com.ycjw.classicread.model.response.Response;
import com.ycjw.classicread.repository.book.ChapterDao;
import com.ycjw.classicread.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("findall")
    public Response findAllBook(Pageable pageable){
        return new Response("查询成功",bookService.findAllBook(pageable).getContent());
    }

    /**
     * 查询某本书
     * @param bookId 书籍id
     * @return 书籍实体
     */
    @GetMapping("findOneBook")
    public Response findOneBook(String bookId){
        return new Response("查询成功",bookService.findOneBook(bookId));
    }

    @PostMapping("findAllChapter")
    public List<Chapter> findAllChapter(@RequestParam("bookId") String bookId) throws ExceptionZyc {
        return bookService.findAllChapter(bookId);
    }

    /**
     * 查询章节
     */
    @GetMapping("findOneChapter")
    public Response findOneChapter(String chapterId){
        return new Response("查询成功",bookService.findOneChapter(chapterId));
    }

    /**
     * 模糊查询书籍
     * @param bookName 书籍名字
     * @return 查询结果
     */
    @GetMapping("findBookByNameLike")
    public Response findBookByNameLike(String bookName, Pageable pageable){
        return new Response("查询成功",bookService.findBookByNameLike(bookName,pageable).getContent());
    }

    /**
     * 通过作者模糊查询书籍
     * @param author 作者名字
     * @return 查询结果
     */
    @GetMapping("findBookByAuthorLike")
    public Response findBookByAuthorLike(String author,Pageable pageable){
        return new Response("查询成功",bookService.findBookByAuthorLike(author,pageable).getContent());
    }

    /**
     * 通过书籍名字和作者模糊查询书籍
     * @param query_info 查询内容
     * @return 查询结果
     */
    @GetMapping("findBookByNameLikeOrAuthorLike")
    public Response findBookByNameLikeOrAuthorLike(String query_info,Pageable pageable){
        return new Response("查询成功",bookService.findBookByNameLikeOrAuthorLike(query_info,pageable).getContent());
    }
}
