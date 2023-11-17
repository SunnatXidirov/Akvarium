package com.Acvarium;

public class BulidFish {
    public static Fish buildFish() {
        RandomUtils random = new RandomUtils();

        int x = random.getX();
        int y = random.getY();
        Gender gender = random.getGender();
        int age = random.getAge();
        int deadTime = random.getDeadTime();

        return new Fish(x,y,gender,age,deadTime);
    }

}
