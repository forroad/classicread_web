package com.ycjw.classicread.controller;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.response.Response;
import com.ycjw.classicread.service.BookRackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("bookrack")
public class BookRackController {
    private BookRackService bookRackService;

    @Autowired
    public BookRackController(BookRackService bookRackService) {
        this.bookRackService = bookRackService;
    }

    @PostMapping("getBookRakBook")
    @ApiOperation("获取用户的书架书籍")
    public Response getBookRakBook(String user_id){
        HashMap<String,Object> result = new HashMap<>();
        result.put("userId",user_id);
        result.put("importantBooks",bookRackService.getAllImportantBooks(user_id));
        result.put("normalBooks",bookRackService.getAllNormalBooks(user_id));
        return new Response("查询成功",result);
    }

    @PostMapping("getOneBookRack")
    @ApiOperation("查询用户书架实体")
    public Response getOneBookRack(String user_id){
        return new Response("查询成功",bookRackService.getOneBookRack(user_id));
    }

    @PostMapping("addBookRack")
    @ApiOperation("用户将书添加书架")
    public Response addBookRack(String user_id,String book_id) throws ExceptionZyc{
        return new Response("添加成功",bookRackService.addBookRack(user_id,book_id));
    }

    @PostMapping("setImportantBook")
    @ApiOperation("用户将书架中的书籍置顶")
    public Response setImportantBook(String user_id,String book_id) throws ExceptionZyc{
        return new Response("置顶成功",bookRackService.setImportantBook(user_id,book_id));
    }

    @PostMapping("setNormalBook")
    @ApiOperation("取消置顶")
    public Response setNormalBook(String user_id,String book_id) throws ExceptionZyc{
        return new Response("取消置顶成功",bookRackService.setNormalBook(user_id,book_id));
    }

    @PostMapping("deleteBookFromBookRack")
    @ApiOperation("用户将书移除书架")
    public Response deleteBookFromBookRack(String user_id,String book_id) throws ExceptionZyc{
        return new Response("移除书架成功",bookRackService.deleteBookFromBookRack(user_id,book_id));
    }

    @PostMapping("top_untop")
    @ApiOperation("top or untop book")
    public Response top_untop(String user_id,String book_id) throws ExceptionZyc{
        return new Response("top or untop success",bookRackService.top_untop(user_id,book_id));
    }
}
