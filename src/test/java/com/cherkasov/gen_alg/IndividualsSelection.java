package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class IndividualsSelection {
      public List select(int size,List<String> population){
          //Initializing some helping lists
          List<String> newpopulation = new ArrayList<>();
          List<Integer> intpopulation = new ArrayList<>();
          List<Integer> newintpopulation = new ArrayList<>();

          Function function = new Function();
          for(int i = 0;i < population.size();++i){
              intpopulation.add(Integer.parseInt(population.get(i),2));
          }
          //Sorting of intpopulation list according to the value of the function
          for(int i = 0;i < population.size()-1;++i){
              double min = function.value(intpopulation.get(0));
              int minind = 0;
              for(int j = 1;j < population.size()-i;++j){
                  if(function.value(intpopulation.get(j))<min){
                      min = function.value(intpopulation.get(j));
                      minind = j;
                  }
              }
              newintpopulation.add(intpopulation.get(minind));
              intpopulation.remove(minind);
          }
          newintpopulation.add(intpopulation.get(0));//notice that the maximum element was not added in the cycle
          for(int i = 0;i < newintpopulation.size();++i){
              population.remove(0);
          }

          Convert convertor = new Convert();
          population = convertor.convert(newintpopulation,population);
          newpopulation.add(population.get(0));//this operation is performed in order not to lose the best solution
          int k;
          for(int i = 0;i < size-1;++i){
              k = (int)(Math.random()*(population.size()/2));
              newpopulation.add(population.get(k));
          }
          return newpopulation;
      }
}
