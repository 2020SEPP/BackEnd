package com.pclogo.demo.repository;

import com.pclogo.demo.entity.User;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select count(*) from user where user.phone=?1", nativeQuery = true)
    Integer lookup(String phone);

    @Query(value="select count(*) from user where user.name=?1", nativeQuery = true)
    Integer lookupname(String name);

    @Nullable
    @Query(value="select * from user where user.phone=?1 and user.password=?2", nativeQuery = true)
    User login(String phone, String password);

    @Nullable
    @Query(value = "select * from user where user.phone = ?1", nativeQuery = true)
    User search(String phone);
}
