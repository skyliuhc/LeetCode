package com.weekTest;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);

    int n;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        try{
            for(int i=0;i<n;i++){
                zero.acquire();
                printNumber.accept(0);
                if((i&1)==0){
                    odd.release();
                }else{
                    even.release();
                }
            }
        }catch (Exception e){

        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        try{
            for(int i=2;i<=n;i+=2){
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }catch (Exception  e){

        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        try{
            for(int i=1;i<=n;i+=2){
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }catch (Exception e){

        }
    }


}