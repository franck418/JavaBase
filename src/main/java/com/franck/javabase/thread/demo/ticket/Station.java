package com.franck.javabase.thread.demo.ticket;

/**
 * Created by Franck on 2018/5/16.
 * 站台类，站台售票。
 * 多个站台同时在卖票， 锁定票的总数。
 */
public class Station extends Thread  {

    private String name ;
    public Station(String name){
        this.name = name;
    }

     static Integer ticket = 20;
//    public static Integer ticket = 20;
     static Integer ticket1 = 2;

    static Object ob = "1";

    private static synchronized void sell(){
        if(ticket>0){
        System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"张票");
        ticket --;

        }else{
            System.out.println("卖完了");
        }


    }



    @Override
    public void run() {

//        System.out.println(name+" 开始执行。 ");
            while (ticket>0){
                sell();
            }

//        System.out.println(name+" 结束执行。 ");




    }


    public static void main(String[] args) {

        Station stationA = new Station("A");
        Station stationB = new Station("B");
        Station stationC = new Station("C");

        stationA.start();
        stationB.start();
        stationC.start();

    }


}
