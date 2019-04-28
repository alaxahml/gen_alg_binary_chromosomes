package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class Rules_Checking {
    public boolean check(List<Integer> population) {
        for(int i=0;i<population.size();i++){
            if(population.get(i)<0 || population.get(i)>15){
                return false;
            }
        }
        return true;
    }
}