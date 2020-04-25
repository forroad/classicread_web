package com.ycjw.classicread.repository.community;

import com.ycjw.classicread.model.community.CAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CAdminDao extends JpaRepository<CAdmin,String> {
}
