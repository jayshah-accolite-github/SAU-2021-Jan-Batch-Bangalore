package com.jay.apps.mockito;

public class Math {

    MathAdv mathAdv;

    public Math() {
    }

    public Math(MathAdv mathAdv) {
        this.mathAdv = mathAdv;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
    public int sub(int num1, int num2) {
        return num1 - num2;
    }
    public int multiplyAndTriple(int num1,int num2)
    {
        return mathAdv.mul(num1,num2)*3;
    }
    public int divideAndDouble(int num1,int num2)
    {
        return mathAdv.div(num1,num2)*2;
    }

}
