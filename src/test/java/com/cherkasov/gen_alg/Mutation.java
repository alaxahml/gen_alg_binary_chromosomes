package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class Mutation {
    public List operate(List<String> population){
        List<Integer> intpopulation = new ArrayList<>();
        DiversityChecking diversityChecking = new DiversityChecking();
        Function function = new Function();
        double chance;
        if(diversityChecking.checking(population)){
            chance = 1.0;
        }
        else {
            chance = 0.1;
        }
        double chance1 = Math.random()*1;
        int ind_num = 0;
        int gen_num;
        //Mutation of the random gen of worst the worst individual
        if(chance1 <= chance){
            for(int i = 0;i < population.size();++i){
                intpopulation.add(Integer.parseInt(population.get(i),2));
            }
            for(int i = 1;i < population.size();++i){
                if(function.value(intpopulation.get(i))>function.value(intpopulation.get(ind_num))){
                    ind_num = i;
                }
            }
            gen_num = (int)(Math.random()*population.get(ind_num).length());
            if (population.get(ind_num).charAt(gen_num) == '0') {
                population.set(ind_num,population.get(ind_num).substring(0,gen_num) + '1'
                        + population.get(ind_num).substring(gen_num+1));
            }
            else{
                population.set(ind_num,population.get(ind_num).substring(0,gen_num) + '0'
                        + population.get(ind_num).substring(gen_num+1));
            }
        }
      return population;
    }
}
