package com.example.pressplayvideo.repositories;

import com.example.pressplayvideo.entities.FilmCategoryEntity;
import com.example.pressplayvideo.entities.FilmCategoryEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategoryEntity, FilmCategoryEntityPK> {
}
