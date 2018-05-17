package com.franck.javabase.thread.demo.bank;

/**
 * Created by Franck on 2018/5/17.
 */
public class Bank implements Runnable{

    private static Double balance=1000.0;




    private synchronized void withdrawalOfCounter(){
        System.out.println("柜台取款前余额:"+balance);
        if(balance>=100){
            balance -=100;
            System.out.println("柜台取款100，取款后余额:"+balance);
        }else{
            System.out.println("柜台发现余额不足100，不能取款，余额:"+balance);
        }
    }



    private synchronized void withdrawalOfATM(){
        System.out.println("ATM取款前余额:"+balance);
        if(balance>=200){
            balance -=200;
            System.out.println("ATM取款200，取款后余额:"+balance);
        }else{
            System.out.println("ATM发现余额不足200，ATM不能取款，余额:"+balance);
        }
    }


    @Override
    public void run() {

        while (balance>0){


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当先线程是"+Thread.currentThread().getName()+"当前余额是："+balance);

            if(Thread.currentThread().getName().startsWith("A")){
            withdrawalOfATM();
        }else{
            withdrawalOfCounter();
        }
        }
    }


    public static void main(String[] args) {

        Bank bank = new Bank();

        Thread APersion = new Thread(bank,"APersion");
        Thread BPersion = new Thread(bank,"BPersion");

        APersion.start();
        BPersion.start();

    }

}
