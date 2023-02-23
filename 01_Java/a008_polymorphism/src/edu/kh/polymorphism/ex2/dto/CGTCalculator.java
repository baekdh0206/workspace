package edu.kh.polymorphism.ex2.dto;


//계산기 구현
public class CGTCalculator implements Calculator{

   @Override
   public int plus(int a, int b) {
      return a+b;
   }

   @Override
   public int minus(int a, int b) {
      return a-b;
   }

   @Override
   public int multiple(int a, int b) {
      return a*b;
   }

   @Override
   public int divide(int a, int b) {
      
      int num = 0;
      if(b != 0) {
         num = a / b;
      }
      
      return num;
   }

   @Override
   public double divide2(int a, int b) {
      double num = 0;
      if(b != 0) {
         num = a / (double)b;
      }
      return num;
   }

   @Override
   public double areaOfCircle(double r) {
      double result = Math.pow(r, 2);
//      return Calculator.PI * result;  <<정석
      return PI * result;
   }

   @Override
   public int square(int a, int x) {
      return (int)Math.pow(a, x);
   }

   
   
   
}