package com.franck.javabase.thread.demo.race;

/**
 * Created by Franck on 2018/5/17.
 */
public class Tortoise implements Runnable{


    @Override
    public void run() {

        System.out.println("乌龟开始开始跑步");

        double whole = 0;
        int second = 0;

    try {
        while (!Race.isOver){
                Thread.sleep(1000);
            whole+=0.1;
            second++;

            System.out.println("乌龟跑了0.1米，用了"+second+"秒,总共跑了"+whole+"米");

            if(whole == Race.whole){
                Race.isOver = true;

            }
        }

        System.out.println("乌龟跑了"+second+"秒，跑了"+whole+"米");

    } catch (InterruptedException e) {
        e.printStackTrace();
    }


    }
}
