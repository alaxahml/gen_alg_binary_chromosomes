package com.cherkasov.gen_alg;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initialization of classes that will be used
        Scanner in = new Scanner(System.in);
        Recombination recombination = new Recombination();
        Individuals_Selection selection = new Individuals_Selection();
        Stop_Checking stop_checking = new Stop_Checking();
        Convert convertor = new Convert();
        Mutation mutation = new Mutation();
        /*Initialization of two lists:one for input population in the way of
        decimal system and another one for convert population into the binary system to worl with
        it during the entire programm
        */
        List<Integer> intpopulation=new ArrayList<Integer>();
        List<String> population=new ArrayList<>();
        int size;
        //Input of initial population
        System.out.println("Number of chromosomes: ");
        size=in.nextInt();
        System.out.println("Enter initial population: ");
        for (int i = 0; i < size; ++i) {
            intpopulation.add(in.nextInt());
        }
        while(!new Rules_Checking().check(intpopulation)){
            System.out.println("Wrong parameters!");
            System.out.println("Enter initial population: ");
            for (int i = 0; i < size; ++i) {
                intpopulation.set(i,in.nextInt());
            }
        }


        convertor.convert(intpopulation,population);
        population = recombination.crossover(population);
        population = mutation.operate(population);
        population = selection.select(size,population);
        int k = 1;
        for(int i = 0;i<size;++i){
            System.out.println(Integer.parseInt(population.get(i),2));
        }
        System.out.println("NEW");
        while(/*!stop_checking.checking(population) &&*/ k!=300){
            population = recombination.crossover(population);
            population = mutation.operate(population);
            population = selection.select(size,population);
            ++k;
            for(int i = 0;i<size;++i){
                System.out.println(Integer.parseInt(population.get(i),2));
            }
            System.out.println("NEW");
        }

        //System.out.println(Integer.parseInt(a,2));

    }
}