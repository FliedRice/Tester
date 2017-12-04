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
	int maxTime;
	int lines;
	int[][] conNodes;
	int[] conAmount;
	boolean[] isConnected;
	Random randomGenerator = new Random();
	int number;
	int z;
	int[] display;
	int x, y;
	int minutes;

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
		maxTime = sc.nextInt();
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
		System.out.println(maxTime);
		System.out.println(taxi + " " + capacity);
		System.out.println(nodes);
		for (int i = 0; i < nodes; i++) {
			System.out.print(display[i] + " ");
			for (int n = 0; n < conAmount[i]; n++) {
				if (conNodes[i][n] != -1) {
					System.out.print(conNodes[i][n] + " ");
				}
			}
			System.out.println();
		}
		System.out.println(training + " " + callList);
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

			while (n < 10) {
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

	public void asickGraph() {
		for (int i = 0; i < nodes; i++) {
			int n = conAmount[i];
			number = randomGenerator.nextInt(10);

			while (n < 10) {
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
					if (conAmount[number] < 10 && isConnected[number] == false) {
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
	
	public void sickGraph() {
		for (int i = 0; i < nodes; i++) {
			int n = conAmount[i];
			number = randomGenerator.nextInt(10);

			while (n < 10) {
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
				if (conAmount[i]== 1) {
					while (conAmount[i] == 1) {
						number = randomGenerator.nextInt(nodes);
						while (i == number || number == conNodes[i][0]){
							number = randomGenerator.nextInt(nodes);
						}
						if (conAmount[number] < 10) {
						conNodes[i][n] = number;
						conAmount[i] = 2;
						z = conAmount[number];
						conNodes[number][z] = i;
						conAmount[number] = z + 1;
						isConnected[number] = true;
						}
					}
				}

				while (number < 5) {
					number = randomGenerator.nextInt(nodes);
					while (i == number) {
						number = randomGenerator.nextInt(nodes);
					}
					if (conAmount[number] < 10 && isConnected[number] == false) {
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

	public void customerSpawn() {
		number = randomGenerator.nextInt(5);
		System.out.print(number + " ");
		for (int i = 0; i < number; i++) {
			x = randomGenerator.nextInt(nodes);
			y = randomGenerator.nextInt(nodes);
			while (!edgeCheck() || x == y) {
				x = randomGenerator.nextInt(nodes);
				y = randomGenerator.nextInt(nodes);
			}
			;
			System.out.print(x + " " + y + " ");
		}
		System.out.println();
	}

	public boolean edgeCheck() {
		int p = 0, q = 0;
		for (int k = 0; k < conAmount[x]; k++) {
			if (conNodes[x][k] != -1) {
				q = conNodes[x][k];
			}
			if (q == y) {
				return false;
			}

			for (int l = 0; l < conAmount[q]; l++) {
				if (conNodes[q][l] != -1) {
					p = conNodes[q][l];
				}
				if (p == y) {
					return false;
				}
				for (int m = 0; m < conAmount[p]; m++) {
					if (conNodes[p][m] == y) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void run() {
		info();
		conNodes = new int[nodes][10];
		conAmount = new int[nodes];
		display = new int[nodes];
		isConnected = new boolean[nodes];
		fill();
		sickGraph();
		//asickGraph();
		// graph();
		removeDup();
		result();
		for (int i = 0; i < callList; i++) {
			customerSpawn();
		}
	}

	public static void main(String[] args) {
		(new Main()).run();
	}

}