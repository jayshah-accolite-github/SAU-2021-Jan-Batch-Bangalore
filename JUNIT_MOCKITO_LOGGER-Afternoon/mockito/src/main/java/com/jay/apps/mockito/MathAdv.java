package com.jay.apps.mockito;

public class MathAdv {
    Math math;
    public MathAdv() {
    }

    public MathAdv(Math math) {
        this.math = math;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }
    public int div(int num1, int num2) {
        return num1 / num2;
    }
    public int AddNMultiplyBy10(int num1,int num2){
        return math.add(num1,num2)*10;
    }


    public int SubNDivBy10(int num1,int num2){
        return math.sub(num1,num2)/10;
    }


}
