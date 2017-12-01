package com.company;
import java.util.*;


public class Main{
    Scanner sc = new Scanner(System.in);
    double parameter;
    int capacity;
    int callList;
    int nodes;
    int taxi;
    int training;
    int waitingtime;
    int lines;
    int[][] array ;
    int[] amount;
    int[] usefull;
    Random randomGenerator = new Random();
    int number;
    int z;
    int[] checker;

    public void info(){
        System.out.println("Type in parameter, waitingtime, taxi, capacity, nodes, training, calllist");
        parameter = sc.nextDouble();
        waitingtime = sc.nextInt();
        taxi = sc.nextInt();
        capacity = sc.nextInt();
        nodes = sc.nextInt();
        training = sc.nextInt();
        callList = sc.nextInt();
        lines = nodes + 5;


    }

    public void result(){
        System.out.println(lines);
        System.out.println(parameter);
        System.out.println(taxi);
        System.out.println(capacity);
        System.out.println(nodes);
        System.out.print(training + " ");
        System.out.println(callList);
        for (int i = 0; i < nodes; i++){
            System.out.print(amount[i] + " ");
            for(int n = 0; n <amount[i]; n++){
                System.out.print(array[i][n] + " ");
            }
            System.out.println(" ");
        }
    }

    public void fill() {
        for (int i = 0; i < nodes; i++) {
            amount[i] = 0;
            usefull[i] = 0;

        }
    }

    public void graph() {

        for (int i = 0; i < nodes; i++) {//eerste node
            int n = amount[i];
            number = randomGenerator.nextInt(10);
            while (n <= 10) {
                if (amount[i] == 0) {
                    while (amount[i] == 0) {
                        number = randomGenerator.nextInt(nodes);
                        while (i == number) {
                            number = randomGenerator.nextInt(nodes);
                        }

                        if (i == 0) {
                            array[i][n] = number;
                            usefull[i] = 1;
                            amount[i] = 1;

                            z = amount[number];
                            array[number][z] = i;
                            amount[number] = z + 1;
                            usefull[number] = 1;
                            //   amount[i]= amount[i]+1;

                        } else if (usefull[number] == 1) {
                            array[i][n] = number;
                            usefull[i] = 1;
                            amount[i] = 1;

                            z = amount[number];
                            array[number][z] = i;
                            amount[number] = z + 1;
                            usefull[number] = 1;
                            //  amount[i]= amount[i]+1;
                        }
                    }
                    number = randomGenerator.nextInt(10);
                    n = n + 1;
                }

                while (number < 5) {
                    number = randomGenerator.nextInt(nodes);
                    while (i == number) {
                        number = randomGenerator.nextInt(nodes);
                    }
                    array[i][n] = number;
                    n++;
                    z = amount[number];
                    array[number][z] = i;
                    amount[number] = z + 1;
                    usefull[number] = 1;
                    amount[i] = amount[i] + 1;
                    number = randomGenerator.nextInt(10);
                    if (n == 10) {
                        number = 9;
                    }
                }

                n = 11;

            }
        }
    }

    public void check(){
        for (int i = 0; i < nodes; i++) {//eerste node
            int n = amount[i];
            number = randomGenerator.nextInt(10);
            while (n <= 10) {
                if (amount[i] == 0) {
                    while (amount[i] == 0) {
                        number = randomGenerator.nextInt(nodes);
                        while (i == number) {
                            number = randomGenerator.nextInt(nodes);
                        }

                        if (i == 0) {
                            array[i][n] = number;
                            usefull[i] = 1;
                            amount[i] = 1;

                            z = amount[number];
                            array[number][z] = i;
                            amount[number] = z + 1;
                            usefull[number] = 1;
                            //   amount[i]= amount[i]+1;

                        } else if (usefull[number] == 1) {
                            array[i][n] = number;
                            usefull[i] = 1;
                            amount[i] = 1;

                            z = amount[number];
                            array[number][z] = i;
                            amount[number] = z + 1;
                            usefull[number] = 1;
                            //  amount[i]= amount[i]+1;
                        }
                    }
                    number = randomGenerator.nextInt(10);
                    n = n + 1;
                }

                while (number < 5) {
                    number = randomGenerator.nextInt(nodes);
                    while (i == number) {
                        number = randomGenerator.nextInt(nodes);
                    }
                    array[i][n] = number;
                    n++;
                    z = amount[number];
                    array[number][z] = i;
                    amount[number] = z + 1;
                    usefull[number] = 1;
                    amount[i] = amount[i] + 1;
                    number = randomGenerator.nextInt(10);
                    if (n == 10) {
                        number = 9;
                    }
                }

                n = 11;

            }
        }
    }

    public void run(){
        info();
        array = new int[nodes][10];
        amount= new int[nodes];
        usefull = new int[nodes];
        fill();
        graph();
        result();
    }

    public static void main (String[] args){
        (new Main()).run();
    }
}
