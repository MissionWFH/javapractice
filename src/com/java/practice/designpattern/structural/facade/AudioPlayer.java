package com.java.practice.designpattern.structural.facade;

// Subsystem classes
class AudioPlayer {

    public void playAudio(String filename) {
        System.out.println("Playing audio: " + filename);
    }
}

class VideoPlayer {

    public void playVideo(String filename) {
        System.out.println("Playing video: " + filename);
    }
}

class ImageLoader {

    public void loadImage(String filename) {
        System.out.println("Loading image: " + filename);
    }
}