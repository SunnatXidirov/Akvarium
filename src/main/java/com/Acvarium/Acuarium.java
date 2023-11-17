package com.Acvarium;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Acuarium {
    public static List<Fish> fishVector = new CopyOnWriteArrayList<>();

    public static synchronized void startAcuarium() {
        System.out.println(" ========================== akvarium =======================\n"
                + "\nAkvarium ishini boshladi"
                + "\nhozirda akvariumda baliqlar soni: " + RandomUtils.firstFishesCount + " ta"
                + "\nakvariumning baliqlar sig'imi: " + RandomUtils.maxFishes + " ta"
                + "\n============================================================");

        for (int i = 0; i < RandomUtils.firstFishesCount; i++) {
            Fish fish = BulidFish.buildFish();
            fishVector.add(fish);
        }

        for (Fish fish : fishVector) {
            fish.start();
        }
    }

    public static synchronized void birth(Fish fish) {

        if (fishVector.size() < RandomUtils.maxFishes) {
            Fish isBaby = null;
            for (Fish fish1 : fishVector) {
                if (fish1.getGender() != fish.getGender() && fish.getX() == fish1.getX() && fish.getY() == fish1.getY()) {
                    isBaby = BulidFish.buildFish();
                    fishVector.add(isBaby);
                    System.out.println("------------------------------------------"
                            + "\nYangi baliq tug'uldi jinsi " + fish1.getGender()
                            + "\n" + isBaby.getName() + " " + isBaby.getGender() + " "
                            + " [" + isBaby.getX() + ":" + isBaby.getY() + "]" + " maxAge: " + isBaby.getDeadTime() +
                            "\n" + "Baliqlar soni 1taga ko'paydi "
                            + "\nHozirda baliqlar soni :" + fishVector.size()
                            + "\nMaksimal baliqlar sig'imi :" + RandomUtils.maxFishes + "ta\n"
                            + "----------------------------------------------\n");
                    break;
                }
            }
            if (isBaby != null) {
                isBaby.start();
            }
        }
    }


    public static synchronized void remove(Fish fish) {
        fishVector.remove(fish);
        System.out.println("*******************************************" +
                "\n" + fish.getName() + " baliq " + (fish.getAge() - 1)
                + " yoshda oldi maxAge: " + fish.getDeadTime() +
                "\nAkvariumda baliqlar soni: " + fishVector.size()
                + "\n**********************************************"
        );


    }
}

