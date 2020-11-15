package com.pclogo.demo.repository;

import com.pclogo.demo.entity.User;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select count(*) from user where user.phone=?1", nativeQuery = true)
    Integer lookup(String phone);

    @Nullable
    @Query(value="select * from user where user.phone=?1 and user.password=?2", nativeQuery = true)
    User login(String phone, String password);
}
