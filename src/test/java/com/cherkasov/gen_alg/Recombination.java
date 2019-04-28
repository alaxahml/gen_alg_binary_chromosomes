package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class Recombination {
    public List crossover(List<String> population){
        List<String> temp_parent=new ArrayList<>();
        int k;
        int size=population.size();
        for(int i=0;i<population.size();i++){
           k=(int)(Math.random()*(population.size()));
            temp_parent.add(population.get(k));
        }

         for(int i=0;i<size;i++){
            population.add(population.get(i).substring(0,2)+temp_parent.get(i).substring(2));
            if(population.get(population.size()-1).equals(population.get(i)) ||
                    population.get(population.size()-1).equals(temp_parent.get(i))){
                population.remove(population.size()-1);
            }
            population.add(temp_parent.get(i).substring(0,2)+population.get(i).substring(2));
             if(population.get(population.size()-1).equals(population.get(i)) ||
                     population.get(population.size()-1).equals(temp_parent.get(i))){
                 population.remove(population.size()-1);
             }
        }

          return  population;
    }

}
