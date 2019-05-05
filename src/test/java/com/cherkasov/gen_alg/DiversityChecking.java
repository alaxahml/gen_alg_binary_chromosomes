package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class DiversityChecking {
    public boolean checking(List<String> population){
        Function function = new Function();
        //Checking for the diversity of the population
        for(int i = 0;i < population.size()-1;++i){
            for(int j = i+1;j < population.size();++j){
                if(Math.abs(function.value(Integer.parseInt(population.get(i),2))-function.value(Integer.parseInt(population.get(j),2)))>=1){
                    return  false;
                }
            }
        }
        return true;
    }
}
