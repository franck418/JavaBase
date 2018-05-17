package com.franck.javabase.thread.demo.race;

/**
 * Created by Franck on 2018/5/17.
 *
 * 龟兔赛跑例子。
 *
 * 兔子每秒跑0.5米。 每跑2米休息10秒
 *
 * 乌龟每秒跑0.1米，不用休息。
 *
 */
public class Race {

    public static double whole = 1.0;

    public static boolean isOver = false;


    public static void main(String[] args) throws InterruptedException {

        Thread tortoise = new Thread(new Tortoise());
        Thread rabbit= new Thread(new Rabbit());


        tortoise.start();
        rabbit.start();


    }




}
