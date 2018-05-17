package com.franck.javabase.thread.demo.race;

/**
 * Created by Franck on 2018/5/17.
 */
public class Rabbit implements Runnable{


    @Override
    public void run() {
        System.out.println("兔子开始开始跑步");

        double whole = 0;
        int second = 0;

        try {
            while (!Race.isOver){

                if(whole>=2 && whole % 2 ==0){
                    second +=10;
                    System.out.println("-->兔子休息10秒");
                    Thread.sleep(1000*10);


                }else if(whole == Race.whole){
                    System.out.println("=====>比赛结束。兔子跑完了整个赛程，用了"+whole+"秒");
                    Race.isOver = true;
                    break;
                }

                Thread.sleep(1000);
                whole += 0.5;
                second++;
                System.out.println("-->兔子跑了0.5米，用了1秒。总共跑了" + whole + "米");

            }

            System.out.println("-->兔子跑了"+second+"秒，跑了"+whole+"米");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }




}
