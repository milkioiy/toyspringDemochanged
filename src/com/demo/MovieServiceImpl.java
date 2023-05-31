package com.demo;


import com.spring.Service;

import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService {
    private ArrayList<MovieDto> db = new ArrayList<>();

    public MovieServiceImpl() {
        System.out.println("baseballServiceImpl 객체 생성");
        db.add(new MovieDto(1, "SSG", "kbologo/SK.png", "team/lgslogan.png", "landers.html"));
        db.add(new MovieDto(2, "LG", "kbologo/LG.png", "team/lgslogan.png", "member/twins.png"));
        db.add(new MovieDto(3, "두산", "kbologo/OB.png", "team/doosanslogan.png", "member/doosanmember.png"));
        db.add(new MovieDto(4, "키움", "kbologo/WO.png", "team/kiwoomslogan.png", "member/heroes.png"));
        db.add(new MovieDto(5, "KIA", "kbologo/HT.png", "team/kiaslogan.png", "member/tigers.png"));
        db.add(new MovieDto(6, "삼성", "kbologo/SS.png", "team/samsungslogan.png", "member/lions.png"));
        db.add(new MovieDto(7, "롯데", "kbologo/LT.png", "team/lotteslogan.png", "member/giants.png"));
        db.add(new MovieDto(8, "NC", "kbologo/NC.png", "team/ncslogan.png", "src/main/resources/templates/member/dinos.html"));
        db.add(new MovieDto(9, "KT", "kbologo/KT.png", "team/ktslogan.png", "member/wiz.png"));
        db.add(new MovieDto(10, "한화", "kbologo/HH.png", "team/hanwhaslogan.png", "member/egles.png"));
    }

    @Override
    public ArrayList<MovieDto> select() {
        return db;
    }

    @Override
    public MovieDto read(int idx) {
        MovieDto ret = db.stream().filter(m -> m.getIdx() == idx).findAny().get();
        return ret;
    }

    @Override
    public int count() {
        return db.size();
    }

    @Override
    public boolean delete(int idx) {
        return false;
    }

    @Override
    public boolean insert(MovieDto base) {
        return false;
    }

    @Override
    public boolean update(MovieDto base) {
        return false;
    }
}

