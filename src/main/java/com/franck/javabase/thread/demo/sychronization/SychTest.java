package com.franck.javabase.thread.demo.sychronization;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Franck on 2018/5/16.
 *
 * synchronized关键字的使用例子
 *
 * 测试同步的时候的锁。
 *
 * 每个对象都有一个对象锁。
 * 类也有一个类锁，其实类锁也是对象锁，就是自动生成的类对象。
 *
 * synchronized关键字用于同步，可以修饰方法和代码块。
 *
 * 修饰实例方法的时候，使用的是这个实例方法的对象的锁。
 *
 * 修饰静态方法的时候，使用的是这个静态方法的类的类锁。
 *
 * 修饰代码块的时候，需要指定用的是变量是锁还是类锁。
 *
 */
public class SychTest implements Runnable{






    /***
     * 不用synchrnized关键字修饰，属于异步方法，不做同步处理
     * 每个线程单独处理。
     */
    public void asych(){

        System.out.println(Thread.currentThread().getName()+
                " 异步实例方法启动:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+
                "--> 异步实例方法结束:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
    }


    /***
     * 修饰实例方法，同步的时候，使用的本实例的锁。
     * 每个线程只有获取到这个实例的锁才可以进入这个方法。
     */
    public synchronized void sych(){

        System.out.println(Thread.currentThread().getName()+
                " 同步实例方法启动:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+
                "--> 同步实例方法结束:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
    }


    /***
     * 通过代码块的方式来进行同步。同步代码块使用的锁是本实例的锁
     */
    public void sych1() throws InterruptedException {


        synchronized (this){


        System.out.println(Thread.currentThread().getName()+
                "    代码块同步实例方法启动:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName()+
                "--> 代码块同步实例方法结束:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
        }


    }

    /***
     * 通过代码块的方式来进行同步。同步代码块使用的锁是类锁，每个类只有一个锁。
     */
    public void sych2() throws InterruptedException {


        synchronized (SychTest.class){


        System.out.println(Thread.currentThread().getName()+
                "    代码块同步实例方法启动:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName()+
                "--> 代码块同步实例方法结束:"+new SimpleDateFormat("HH:mm:ss ssss").format(new Date()));
        }


    }





    @Override
    public void run() {
        try {
            sych2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SychTest sychTest= new SychTest();

        //这两个线程使用的是同一个对象，所以，同步的实例方法，使用的实例的锁也是同一个锁。
        //两个线程同时进入一个同步的实例方法的时候，后进的线程，需要等待前进去的线程执行完这个方法。
        //将run改为调用sych()方法
/*

        Thread threadA = new Thread(sychTest,"ThreadA");
        Thread threadB = new Thread(sychTest,"ThreadB");

        threadA.start();
        threadB.start();
*/



        //这两个线程使用的是2个不同的对象，所以这两个线程都有分配独立的内存空间。
        //进入同步方法的时候，由于使用的是不同的对象，所以同步方法使用的是不同的对象的锁
        //所以这两个线程的同步方法互不干扰，不会进行同步。
        //将run改为调用sych()方法
/*
        Thread threadC = new Thread(new SychTest(),"ThreadC");
        Thread threadD = new Thread(new SychTest(),"ThreadD");

        threadC.start();
        threadD.start();
*/



        //这2个线程使用的是同一个对象，所以 synchronized(对象)代码块 使用的对象锁同一个对象锁。
        //这两个线程一起执行sych1()方法的时候，会进行同步
        //将run改为调用sych1()方法
/*

        Thread threadE = new Thread(sychTest,"ThreadE");
        Thread threadF = new Thread(sychTest,"ThreadF");

        threadE.start();
        threadF.start();
*/


        //这2个线程使用的是独立的对象，所以 synchronized(对象)代码块 使用的锁不是同一个对象锁。
        //所以这两个线程执行sych1()方法的时候不会同步，互不影响。
        //将run改为调用sych1()方法
/*
        Thread threadG = new Thread(new SychTest(),"ThreadG");
        Thread threadH = new Thread(new SychTest(),"ThreadH");

        threadG.start();
        threadH.start();
*/



        //无论线程也是的是同一个对象还是不同的对象，类锁只有1个，同步代码块使用的是类锁。
        //所以 synchronized(类)代码块 使用的锁是同一个锁。
        //所以这两个线程执行sych2()方法的时候会同步。
        //将run改为调用sych2()方法
        Thread threadI = new Thread(new SychTest(),"ThreadI");
        Thread threadJ = new Thread(new SychTest(),"ThreadJ");
        Thread threadK = new Thread(sychTest,"ThreadK");
        Thread threadL = new Thread(sychTest,"ThreadL");


        threadI.start();
        threadJ.start();
        threadK.start();
        threadL.start();

    }



}
