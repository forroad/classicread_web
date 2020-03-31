package com.ycjw.classicread.repository;

import com.ycjw.classicread.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,String> {
    User findByPhoneNum(String phoneNum);
}
