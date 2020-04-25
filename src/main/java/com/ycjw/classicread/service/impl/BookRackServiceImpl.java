package com.ycjw.classicread.service.impl;

import com.ycjw.classicread.exception.ExceptionZyc;
import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.BookRack;
import com.ycjw.classicread.model.response.Response;
import com.ycjw.classicread.repository.book.BookDao;
import com.ycjw.classicread.repository.book.BookRackDao;
import com.ycjw.classicread.service.BookRackService;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookRackServiceImpl implements BookRackService {
    private BookRackDao bookRackDao;
    private BookDao bookDao;

    @Autowired
    public BookRackServiceImpl(BookRackDao bookRackDao, BookDao bookDao) {
        this.bookRackDao = bookRackDao;
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllImportantBooks(String user_id) {
        BookRack bookRack = getBookRack(user_id);
        List<String> specialBookIds = new ArrayList<>();
        if(bookRack.getSpecialBookIds() != null){
            specialBookIds.addAll(bookRack.getSpecialBookIds());
        }
        try {
            return IteratorUtils.toList(bookDao.findAllById(specialBookIds).iterator());
        }catch (Exception e){
            return new ArrayList<>();
        }

    }

    @Override
    public List<Book> getAllNormalBooks(String user_id) {
        BookRack bookRack = getBookRack(user_id);
        List<String> normalBookIds = new ArrayList<>();
        if(bookRack.getNormalBookIds() != null){
            normalBookIds.addAll(bookRack.getNormalBookIds());
        }
        try {
            return IteratorUtils.toList(bookDao.findAllById(normalBookIds).iterator());
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public BookRack getOneBookRack(String user_id) {
        return bookRackDao.findByUserId(user_id);
    }

    @Override
    public BookRack addBookRack(String user_id, String book_id)  throws ExceptionZyc{
        Book book = bookDao.findById(book_id).orElse(null);
        if(book == null){
            throw new ExceptionZyc(new Response("书籍不存在",null));
        }
        BookRack bookRack = getBookRack(user_id);
        if(bookRack.getNormalBookIds().contains(book_id) || bookRack.getSpecialBookIds().contains(book_id)){
            throw new ExceptionZyc(new Response("该书籍已在书架",null));
        }
        List<String> normal_book_ids = bookRack.getNormalBookIds();
        normal_book_ids.add(book_id);
        bookRack.setNormalBookIds(normal_book_ids);
        bookRack = bookRackDao.save(bookRack);
        //收藏数+1
        book.setCollectionNum(book.getCollectionNum() + 1);
        bookDao.save(book);
        return bookRack;
    }

    @Override
    public BookRack setImportantBook(String user_id, String book_id) throws ExceptionZyc {
        Book book = bookDao.findById(book_id).orElse(null);
        if(book == null){
            throw new ExceptionZyc(new Response("书籍不存在",null));
        }
        BookRack bookRack = getBookRack(user_id);
        List<String> normal_book_ids = bookRack.getNormalBookIds();
        List<String> special_book_ids = bookRack.getSpecialBookIds();
        for (int i = 0;i < normal_book_ids.size();i++){
            if(book_id.equals(normal_book_ids.get(i))){
                special_book_ids.add(book_id);
                normal_book_ids.remove(book_id);
                bookRack.setNormalBookIds(normal_book_ids);
                bookRack.setSpecialBookIds(special_book_ids);
                return bookRackDao.save(bookRack);
            }
        }
        throw new ExceptionZyc(new Response("置顶错误",null));
    }

    @Override
    public BookRack setNormalBook(String user_id, String book_id) throws ExceptionZyc {
        Book book = bookDao.findById(book_id).orElse(null);
        if(book == null){
            throw new ExceptionZyc(new Response("书籍不存在",null));
        }
        BookRack bookRack = getBookRack(user_id);
        List<String> normal_book_ids = bookRack.getNormalBookIds();
        List<String> special_book_ids = bookRack.getSpecialBookIds();
        for (int i = 0;i < special_book_ids.size();i++){
            if(book_id.equals(special_book_ids.get(i))){
                normal_book_ids.add(book_id);
                special_book_ids.remove(book_id);
                bookRack.setNormalBookIds(normal_book_ids);
                bookRack.setSpecialBookIds(special_book_ids);
                return bookRackDao.save(bookRack);
            }
        }
        throw new ExceptionZyc(new Response("取消置顶错误",null));
    }

    @Override
    public BookRack top_untop(String user_id, String book_id) throws ExceptionZyc {
        Book book = bookDao.findById(book_id).orElse(null);
        if(book == null){
            throw new ExceptionZyc(new Response("书籍不存在",null));
        }
        BookRack bookRack = getBookRack(user_id);
        List<String> normal_book_ids = bookRack.getNormalBookIds();
        List<String> special_book_ids = bookRack.getSpecialBookIds();
        for (int i = 0;i < special_book_ids.size();i++){
            if(book_id.equals(special_book_ids.get(i))){
                normal_book_ids.add(book_id);
                special_book_ids.remove(book_id);
                bookRack.setNormalBookIds(normal_book_ids);
                bookRack.setSpecialBookIds(special_book_ids);
                return bookRackDao.save(bookRack);
            }
        }
        for (int i = 0;i < normal_book_ids.size();i++){
            if(book_id.equals(normal_book_ids.get(i))){
                special_book_ids.add(book_id);
                normal_book_ids.remove(book_id);
                bookRack.setNormalBookIds(normal_book_ids);
                bookRack.setSpecialBookIds(special_book_ids);
                return bookRackDao.save(bookRack);
            }
        }
        throw new ExceptionZyc(new Response("top or untop error",null));
    }

    @Override
    public BookRack deleteBookFromBookRack(String user_id, String book_id) throws ExceptionZyc {
        Book book = bookDao.findById(book_id).orElse(null);
        if(book == null){
            throw new ExceptionZyc(new Response("书籍不存在",null));
        }
        BookRack bookRack = getBookRack(user_id);
        List<String> normal_book_ids = bookRack.getNormalBookIds();
        List<String> special_book_ids = bookRack.getSpecialBookIds();
        for(String id:normal_book_ids){
            if(id.equals(book_id)){
                normal_book_ids.remove(id);
                bookRack.setNormalBookIds(normal_book_ids);
                book.setCollectionNum(book.getCollectionNum() - 1);
                bookDao.save(book);
                return bookRackDao.save(bookRack);
            }
        }
        for (String id:special_book_ids){
            if(id.equals(book_id)){
                special_book_ids.remove(id);
                bookRack.setSpecialBookIds(special_book_ids);
                book.setCollectionNum(book.getCollectionNum() - 1);
                bookDao.save(book);
                return bookRackDao.save(bookRack);
            }
        }
        throw new ExceptionZyc(new Response("该书籍已不在书架",null));
    }

    private BookRack getBookRack(String user_id){
        BookRack bookRack = bookRackDao.findByUserId(user_id);
        if(bookRack == null){
            bookRack = new BookRack();
            bookRack.setUserId(user_id);
            bookRack.setBookRackId(System.currentTimeMillis() + "");
            bookRack = bookRackDao.save(bookRack);
        }
        return bookRack;
    }
}
