package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class RulesChecking {
    public boolean check(List<Integer> population) {
        //Checking for belonging to the domain of the definition
        for(int i = 0;i < population.size();++i){
            if(population.get(i) < 0 || population.get(i) > 15){
                return false;
            }
        }
        return true;
    }
}