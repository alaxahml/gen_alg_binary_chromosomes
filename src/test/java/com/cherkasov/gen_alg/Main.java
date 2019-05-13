package com.cherkasov.gen_alg;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initialization of classes that will be used
        Scanner in = new Scanner(System.in);
        Recombination recombination = new Recombination();
        IndividualsSelection selection = new IndividualsSelection();
        RulesChecking rulesChecking = new RulesChecking();
        Convert convertor = new Convert();
        Mutation mutation = new Mutation();
        /*Initialization of two lists:one for input population in the way of
        decimal system and another one for convert population into the binary system to work with
        it during the entire programm
        */
        List<Integer> intpopulation = new ArrayList<Integer>();
        List<String> population = new ArrayList<>();
        int size;
        //Input of initial population
        System.out.println("Number of chromosomes: ");
        size=in.nextInt();
        System.out.println("Enter initial population: ");
        for (int i = 0; i < size; ++i) {
            intpopulation.add(in.nextInt());
        }
        while(!rulesChecking.check(intpopulation)){
            System.out.println("Wrong parameters!");
            System.out.println("Enter initial population: ");
            for (int i = 0; i < size; ++i) {
                intpopulation.set(i,in.nextInt());
            }
        }

        //the algorythm itself. It uses classes initialized before
        convertor.convert(intpopulation,population);
        int k = 0;
        while(k != 300){
            population = recombination.crossover(population);
            population = mutation.operate(population);
            population = selection.select(size,population);
            ++k;
            for(int i = 0;i<size;++i){
                System.out.println(Integer.parseInt(population.get(i),2));
            }
            System.out.println("NEW");
        }
        //Output of initial population
        System.out.println("FINAL POPULATION:");
        for(int i = 0;i<size;++i){
            System.out.println(Integer.parseInt(population.get(i),2));
        }

    }
}