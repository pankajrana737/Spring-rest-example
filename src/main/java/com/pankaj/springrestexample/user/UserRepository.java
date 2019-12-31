package com.pankaj.springrestexample.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pankaj.springrestexample.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{

}
