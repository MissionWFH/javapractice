package com.java.practice.designpattern.structural.facade;

public class Client {

    public static void main(String[] args) {

        MediaPlayerFacade player = new MediaPlayerFacade();
        player.playMedia("song.mp3", "audio");
        player.playMedia("movie.mp4", "video");
        player.playMedia("picture.jpg", "image");
    }
}