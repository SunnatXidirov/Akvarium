package com.Acvarium;

import lombok.*;

@Getter
@Setter
public class Fish extends Thread {
    private int x;
    private int y;
    private int age;
    private int deadTime;
    private Gender gender;


    public Fish(int x, int y, Gender gender, int age, int deadTime) {
        this.age = age;
        this.x = x;
        this.y = y;
        this.gender = gender;
        this.deadTime = deadTime;
    }


    @Override
    public void run() {
        RandomUtils random = new RandomUtils();

        while (this.age <= this.deadTime){

            setX(random.getX());
            setY(random.getY());
            System.out.println(this.getName() +" age:"+this.age+ "  [" + this.x + ":" + this.y + "]" + " maxAge=" + this.deadTime);
            try {
                Thread.sleep(2000);
                ++this.age;
                Acuarium.birth(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Acuarium.remove(this);
    }
}

enum Gender {
    MALE,
    FEMALE
}

