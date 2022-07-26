package com.sparta.myblogsparta.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {  // JpaRepo 인터페이스, DB에 접근, 기본 CRUD 메소 생성
}
