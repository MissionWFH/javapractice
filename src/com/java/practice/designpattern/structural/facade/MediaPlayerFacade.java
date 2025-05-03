package com.java.practice.designpattern.structural.facade;

public class MediaPlayerFacade {
    
    private final AudioPlayer audioPlayer;
    private final VideoPlayer videoPlayer;
    private final ImageLoader imageLoader;

    public MediaPlayerFacade() {
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
        this.imageLoader = new ImageLoader();
    }

    public void playMedia(String filename, String mediaType) {
    
        switch (mediaType) {
            case "audio" -> audioPlayer.playAudio(filename);
            case "video" -> videoPlayer.playVideo(filename);
            case "image" -> imageLoader.loadImage(filename);
            default -> throw new IllegalStateException("Unknown file name: " + filename);
        }
    }
}