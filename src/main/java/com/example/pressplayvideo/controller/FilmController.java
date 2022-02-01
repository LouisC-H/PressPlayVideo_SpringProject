package com.example.pressplayvideo.controller;

import com.example.pressplayvideo.entities.FilmCategoryEntity;
import com.example.pressplayvideo.entities.FilmEntity;
import com.example.pressplayvideo.entities.UserEntity;
import com.example.pressplayvideo.repositories.FilmCategoryRepository;
import com.example.pressplayvideo.repositories.FilmRepository;
import com.example.pressplayvideo.repositories.UserRepository;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class FilmController {
    private final FilmRepository filmRepository;
    private final FilmCategoryRepository filmCategoryRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    Random random = new Random();

    @Autowired
    public FilmController(FilmRepository filmRepository, FilmCategoryRepository filmCategoryRepository, UserRepository userRepository) {
        this.filmRepository = filmRepository;
        this.filmCategoryRepository = filmCategoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/film-search")
    public String searchForFilms(){return "film-search";}

    @PostMapping("/film-search-title")
    public String getTitleSearchResults(@ModelAttribute("filmTitle") String filmTitle, Model model){
        ArrayList<FilmEntity> filmList = new ArrayList<>();
        for (FilmEntity filmEntity:filmRepository.findAll()){
            if (filmEntity.getTitle().contains(filmTitle.toUpperCase(Locale.ROOT))){
                filmList.add(filmEntity);
            }
        }
        Collections.shuffle(filmList);
        model.addAttribute("films", filmList);
        return "homepage-films";
    }

    @PostMapping("/film-search-category")
    public String getCategorySearchResults(@ModelAttribute("filmCategory") Integer filmCategory, Model model){
        ArrayList<FilmEntity> filmList = new ArrayList<>();
        for (FilmCategoryEntity filmCategoryEntity: filmCategoryRepository.findAll()){
            if (filmCategoryEntity.getCategoryId().equals(filmCategory)){
                filmList.add(filmRepository.getById(filmCategoryEntity.getFilmId()));
            }
        }
        Collections.shuffle(filmList);
        model.addAttribute("films", filmList);
        return "homepage-films";
    }

    @GetMapping("/random")
    public String getHomepageRandomised(Model model){
        ArrayList<FilmEntity> filmListRandom5 = new ArrayList<>();
        ArrayList<FilmEntity> filmList = new ArrayList<>(filmRepository.findAll());
        Collections.shuffle(filmList);
        for (int i = 0; i < 5; i++) {
            filmListRandom5.add(filmList.get(i));
        }
        model.addAttribute("films", filmListRandom5);
        return "homepage-films";
    }

    @GetMapping("/film-database")
    public String getAllFilms(Model model){
        model.addAttribute("films", filmRepository.findAll());
        return "film-database";
    }

    @GetMapping("/login")
    public String goToLogin(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "login";
    }

    @PostMapping("/save-user")
    public String saveCustomer(@ModelAttribute("user") UserEntity entity){
        entity.setUserID(random.nextInt(Integer.MAX_VALUE));
        entity.setUserRole("CUSTOMER");
        entity.setUserEnabled(1);
        entity.setUserPassword(encoder.encode(entity.getUserPassword()));
        userRepository.save(entity);
        return "index";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage(){
        return "access-denied";
    }

    @GetMapping("/login-account-explanation")
    public String getExplanationPage(){
        return "login-account-explanation";
    }

    @GetMapping("/home")
    public String returnHome(){return "index";}
}
