package com.cherkasov.gen_alg;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public List convert(List<Integer> intpopulation,List<String> population){
        //Converting of the int population into the binary. adding of the zeros to the left when necessary
        for(int i = 0;i < intpopulation.size();++i){
            int current_bits = Integer.toBinaryString(intpopulation.get(i)).length();
            String current = Integer.toBinaryString(intpopulation.get(i));
            if(4>current_bits){
                for(int j = 0;j < 4-current_bits;++j){
                    current='0' + current;
                }
            }
            population.add(current);
        }
        return population;
    }
}
