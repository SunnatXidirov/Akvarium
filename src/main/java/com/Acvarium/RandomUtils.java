package com.Acvarium;

import java.util.Random;

public class RandomUtils {
    public static final int maxFishes = new Random().nextInt(150, 250);
    public static final int firstFishesCount = new Random().nextInt(50, 80);
    public static long fishId = 1;
    {
        fishId++;
    }
    public Gender getGender() {
        return new Random().nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }
    public int getAge(){
        return new Random().nextInt(10,25);
    }
    public int getX() {
        return new Random().nextInt(80, 100);
    }
    public int getY() {
        return new Random().nextInt(70, 120);
    }
    public int getDeadTime() {
        return new Random().nextInt(30,50);
    }
}
