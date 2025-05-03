package com.java.practice.designpattern.creational.builder;

class Computer {

    private final String processor;
    private final int ram;
    private final int storage;
    private final String graphicsCard;

    // Private constructor to enforce usage of builder
    private Computer(String processor, int ram, int storage, String graphicsCard) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }

    // Getters
    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }

    // Builder class
    public static class ComputerBuilder {
        private String processor;
        private int ram;
        private int storage;
        private String graphicsCard;

        public ComputerBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(processor, ram, storage, graphicsCard);
        }
    }
}