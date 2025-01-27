package com.spring.spring_boot_restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.spring_boot_restapi.entities.Posts;

public interface Post_repo extends JpaRepository<Posts, Long> {

}