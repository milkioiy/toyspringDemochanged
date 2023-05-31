package com.demo;

public class MovieDto {

    private int idx;
    private String team;
    private String image;
    private String slogan;
    private String member;

    public MovieDto() {}

    public MovieDto(int idx, String team, String image, String slogan, String member) {
        this.idx = idx;
        this.team = team;
        this.image = image;
        this.slogan = slogan;
        this.member = member;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "baseballDto{" +
                "idx=" + idx +
                ", team='" + team + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

