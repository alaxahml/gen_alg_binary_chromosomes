package com.cherkasov.gen_alg;

public class Function {
     public double value(int x){
         //return 5.0-(24*x)+(17*Math.pow(x,2))-((11.0/3.0)*Math.pow(x,3))+((1.0/4.0)*Math.pow(x,4));
         double k = (Math.pow(x,3))-(9*Math.pow(x,2))+(15*x)+45.0;
         return k;
     }
}
