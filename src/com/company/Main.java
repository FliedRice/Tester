package com.company;

import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);
    double parameter;
    int capacity;
    int callList;
    int nodes;
    int taxi;
    int training;
    int waitingtime;
    int lines;
    int[][] conNodes;
    int[] conAmount;
    boolean[] isConnected;
    Random randomGenerator = new Random();
    int number;
    int z;
    int[] display;
    int[] amountTaxi;


    void start() {
        number = sc.nextInt();
        if (number == 1) {
            test1();
        }
    }

    public void test1() {
        nodes = sc.nextInt();
        taxi = sc.nextInt();
        capacity = sc.nextInt();

    }

    public void info() {
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

    public void result() {
        System.out.println(lines);
        System.out.println(parameter);
        System.out.println(taxi);
        System.out.println(capacity);
        System.out.println(nodes);
        for (int i = 0; i < nodes; i++) {
            System.out.print(display[i] + " ");
            for (int n = 0; n < conAmount[i]; n++) {
                if (conNodes[i][n] != -1) {
                    System.out.print(conNodes[i][n] + " ");
                }
            }
            System.out.println(" ");
        }
        System.out.print(training + " ");
        System.out.println(callList);
    }


    public void fill() {
        for (int i = 0; i < nodes; i++) {
            conAmount[i] = 0;
            isConnected[i] = false;

        }
    }

    public void graph() {

        // Go through all nodes
        for (int i = 0; i < nodes; i++) {
            int n = conAmount[i];
            number = randomGenerator.nextInt(10);

            while (n <= 10) {
                if (conAmount[i] == 0) {
                    while (conAmount[i] == 0) {
                        number = randomGenerator.nextInt(nodes);
                        while (i == number) {
                            number = randomGenerator.nextInt(nodes);
                        }

                        if (i == 0 || (isConnected[number] == true && conAmount[number] < 10)) {

                            conNodes[i][n] = number;
                            isConnected[i] = true;
                            conAmount[i] = 1;

                            z = conAmount[number];
                            conNodes[number][z] = i;
                            conAmount[number] = z + 1;
                            isConnected[number] = true;
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
                    if (conAmount[number] < 10) {
                        conNodes[i][n] = number;
                        n++;
                        z = conAmount[number];
                        conNodes[number][z] = i;
                        conAmount[number] = z + 1;
                        isConnected[number] = true;
                        conAmount[i] = conAmount[i] + 1;
                        number = randomGenerator.nextInt(10);
                        if (n == 10) {
                            number = 9;
                        }
                    }
                }
                n = 11;
            }

        }

    }

    public void removeDup() {
        for (int i = 0; i < nodes; i++) {
            display[i] = conAmount[i];
            for (int n = 0; n < conAmount[i]; n++) {
                for (int x = 0; x < conAmount[i]; x++) {
                    if (conNodes[i][n] == conNodes[i][x] && x != n) {
                        conNodes[i][n] = -1;
                        display[i]--;
                    }
                }
            }
        }
    }

    public void run() {
        info();
        conNodes = new int[nodes][10];
        conAmount = new int[nodes];
        display = new int[nodes];
        isConnected = new boolean[nodes];
        amountTaxi = new int[1000];
        fill();
        graph();
        removeDup();
        result();
        resultTaxi();
    }

    public void resultTaxi() {
        for(int i = 0; i <= callList; i++) {
            int p = 0;
            //chance of call
            number = randomGenerator.nextInt(100);
            if (number > 50) {
                p = p + 1;
                amountTaxi[i] = p;
                number = randomGenerator.nextInt(100);
                //chance for guy in place
                while(number > 70 ) {
                    p = p + 1;
                    amountTaxi[i] = p;
                    number = randomGenerator.nextInt(100);
                }
                System.out.print(amountTaxi[i]+" ");
                for(int k = 1; k < amountTaxi[i]; k++) {
                    number = randomGenerator.nextInt(nodes);
                    z = randomGenerator.nextInt(nodes);
                    while (number == z) {
                        z = randomGenerator.nextInt(nodes);
                        System.out.print(number + " ");
                        System.out.println(z + " ");
                    }
                }
            }else{
                System.out.println("0");
            }


        }
    }

    public void getStraalCustomers(){

    }


    public static void main(String[] args) {
        (new Main()).run();
    }
}