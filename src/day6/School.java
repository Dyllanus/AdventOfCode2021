package day6;

import java.util.ArrayList;
import java.util.List;

public class School {
    long amount0;
    long amount1;
    long amount2;
    long amount3;
    long amount4;
    long amount5;
    long amount6=0;
    long amount7=0;
    long amount8=0;

    public School(long amount0, long amount1, long amount2, long amount3, long amount4, long amount5, long amount6, long amount7, long amount8) {
        this.amount0 = amount0;
        this.amount1 = amount1;
        this.amount2 = amount2;
        this.amount3 = amount3;
        this.amount4 = amount4;
        this.amount5 = amount5;
        this.amount6 = amount6;
        this.amount7 = amount7;
        this.amount8 = amount8;
    }


    public void newDay(){
        long newCycleFish = amount0;
        amount0 = amount1;
        amount1 = amount2;
        amount2 = amount3;
        amount3 = amount4;
        amount4 = amount5;
        amount5 = amount6;
        amount6 = amount7;
        amount7 = amount8;
        amount8 = newCycleFish;
        amount6 += newCycleFish;
    }
    public void getTotalFish(){
        System.out.println(amount0+amount1+amount2+amount3+amount4+amount5+amount6+amount7+amount8);
    }








}
