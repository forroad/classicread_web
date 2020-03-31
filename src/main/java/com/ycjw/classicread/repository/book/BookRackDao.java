package com.ycjw.classicread.repository.book;

import com.ycjw.classicread.model.book.BookRack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRackDao extends JpaRepository<BookRack,String> {
    BookRack findByUserId(String user_id);
}
