package com.franck.javabase.base;

/**
 * Created by Franck on 2018/5/22.
 */
public class intTest {

//    int i ;
//    Integer i1;



    public static void main(String[] args) {

        int i1= 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);


        //true 因为i2会被自己拆箱成1
        System.out.println( i1 == i2);

        //true 因为i3会被自己拆箱成1
        System.out.println( i1 == i3);

        //false 因为Integer会自动在类加载的时候，自动生成一个Integer数组，保存着 -128 ~ 127 的对象
        //i2 会被编译成 i2= Integer.valueOf(1); valueOf方法会去获取预先缓存的 -128 ~ 127 对象。
        // 所以这里判断的是 i2(这个在加载阶段就创建的Integer对象) 和 i3(在执行阶段才创建的对象) 是否同一个对象，当然不是同一个对象。
        System.out.println( i2 == i3);


        Integer i4 = 2;
        Integer i5 = 2;

        //true 因为i4 和 i5 都是Integer类缓存的对象。
        System.out.println(i4 == i5);


        Integer i6 = 128;
        Integer i7 = 128;

        //false ，因为i6 和 i7都大于127。所以是new出来的对象，而不是缓存的对象。
        System.out.println(i6 == i7 );


        Integer i8 = new Integer(3);
        Integer i9 = new Integer(3);
        //false i8 和 i9都是new出来的对象，是不同的引用。所以是false
        System.out.println(i6 == i7 );

        //true  equals方法是获取int值进行对比。 他们的值都是3 所以是true
        System.out.println(i8.equals(i9));


    }


}
