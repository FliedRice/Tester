package com.company;

import java.util.*;

public class Main {
	double parameter;
	int capacity, callList, nodes, taxi, training, maxTime, lines, number, minutes, number2;
	int[][] conNodes;
	int[] conAmount, route, display;
	boolean[] isConnected;
	int x, y, z;
	int o = 100;
	Random randomGenerator = new Random();
	Scanner sc = new Scanner(System.in);

	/*
	 * User inputs numbers on a single line to specify what kind of graph to
	 * generate
	 */
	public void info() {
		System.out.println(
				"Enter seperated by spaces: parameter, waiting time, taxi, capacity, nodes, training, call list");
		parameter = sc.nextDouble();
		maxTime = sc.nextInt();
		taxi = sc.nextInt();
		capacity = sc.nextInt();
		nodes = sc.nextInt();
		training = sc.nextInt();
		callList = sc.nextInt();
		lines = nodes + 5;
	}

	/*
	 * Prints the generated input graph except the passenger spawns/destinations
	 */
	public void result() {
		System.out.println(lines);
		System.out.println(parameter);
		System.out.println(maxTime);
		System.out.println(taxi + " " + capacity);
		System.out.println(nodes);
		
		for (int i = 0; i < nodes; i++) {
			System.out.print(display[i] + " "); // Print the amount of connected nodes
			for (int n = 0; n < conAmount[i]; n++) {
				if (conNodes[i][n] != -1) {	// If the connected node is not listed more than once (duplicate)
					System.out.print(conNodes[i][n] + " "); // Print the number of the node that is directly connected
				}
			}
			System.out.println();
		}
		
		System.out.println(training + " " + callList);
	}

	/*
	 * Fills the arrays with 0, so they are not NULL
	 */
	public void fill() {
		for (int i = 0; i < nodes; i++) {
			conAmount[i] = 0;
			isConnected[i] = false;
		}
	}

	/*
	 * Creates the graph by filling in conNodes
	 */
	public void randomGraph() {
		// Go through all nodes
		for (int i = 0; i < nodes; i++) {
			int n = conAmount[i];	// Save the amount of connected nodes in n
			number = randomGenerator.nextInt(10);

			while (n < 10) {
				if (conAmount[i] == 0) {	// If the node is not connected to any node
					while (conAmount[i] == 0) {
						number = randomGenerator.nextInt(nodes);
						while (i == number) {	// Repeat until number is different than the current node
							number = randomGenerator.nextInt(nodes);
						}
						if (i == 0 || (isConnected[number] == true && conAmount[number] < 10)) {
							conNodes[i][n] = number;	// Add number as a connected node
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
				n = 11;	// To exit the while loop
			}
		}
	}

	/* 
	 * Creates an acyclic graph
	 */
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
				n = 11;	// To exit the while loop
			}
		}
	}

	/*
	 * Creates a cyclic graph
	 */
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
				if (conAmount[i] == 1) {
					while (conAmount[i] == 1) {
						number = randomGenerator.nextInt(nodes);
						while (i == number || number == conNodes[i][0]) {
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
				n = 11;	// To exit the while loop
			}

		}

	}

	/* 
	 * conNodes contains duplicate node connections, which will be marked to ignore it during output
	 */
	public void removeDup() {
		// Go through all nodes
		for (int i = 0; i < nodes; i++) {
			display[i] = conAmount[i];	//Replicate conAmount as display array
			for (int n = 0; n < conAmount[i]; n++) {
				for (int x = 0; x < conAmount[i]; x++) {
					if (conNodes[i][n] == conNodes[i][x] && x != n) {	// Check for duplicates on every node to which the current is connected for duplicates
						conNodes[i][n] = -1;	// Save this duplicate as -1 instead
						display[i]--;	// Decrease the amount of connected nodes of the current node to display by 1
					}
				}
			}
		}
	}

	/* 
	 * Generate an output line with a random amount of customers along with their destination
	 */
	public void customerSpawn() {
		number = randomGenerator.nextInt(5);	// Max amount of customers is 4
		System.out.print(number + " ");
		for (int i = 0; i < number; i++) {
			x = randomGenerator.nextInt(nodes);
			y = randomGenerator.nextInt(nodes);
			while (!edgeCheck() || x == y) {	// Repeat as long as the travel distance is < 4 nodes
				x = randomGenerator.nextInt(nodes);
				y = randomGenerator.nextInt(nodes);
			}
			;
			System.out.print(x + " " + y + " ");
		}
		System.out.println();
	}

	/*
	 * Checks whether the travel distance is larger than 3 edges/nodes
	 * by looking at every single connected node and the nodes that are connected to that one
	 * three times, if by then the node has not been seen the travel distance is at least 3 edges
	 */
	public boolean edgeCheck() {
		int p = 0, q = 0;
		for (int k = 0; k < conAmount[x]; k++) {
			if (conNodes[x][k] != -1) {	// If the connected node is not a duplicate
				q = conNodes[x][k];
			}
			if (q == y) { // Distance is 1
				return false;
			}
			for (int l = 0; l < conAmount[q]; l++) {
				if (conNodes[q][l] != -1) {
					p = conNodes[q][l];
				}
				if (p == y) {	// Distance is 2
					return false;
				}
				for (int m = 0; m < conAmount[p]; m++) {
					if (conNodes[p][m] == y) {
						return false;	// Distance is 3
					}
				}
			}
		}
		return true;	// Else the distance is larger than 3
	}

	public boolean edgeCheckTree() {
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
		if (display[x] != 1 || display[y] != 1) {
			return false;
		}
		return true;
	}

	/*
	 * customerSpawn version where the amount of customers generally decreases over time
	 */
	public void customerSpawnDecline() {
		number = randomGenerator.nextInt(100);
		if (o < 29) {
			o = 29;
		}
		if (number < o) {
			o--;
			number = randomGenerator.nextInt(5);
			while (number == 0) {
				number = randomGenerator.nextInt(5);
			}
			System.out.print(number + " ");
			for (int i = 0; i < number; i++) {
				x = randomGenerator.nextInt(nodes);
				y = randomGenerator.nextInt(nodes);
				while (!edgeCheckTree() || x == y) {
					x = randomGenerator.nextInt(nodes);
					y = randomGenerator.nextInt(nodes);
				}
				o--;
				System.out.print(x + " " + y + " ");
			}
			System.out.println();
		} else {
			System.out.println("0");
		}
	}

	public void customerSpawnTree() {
		number = randomGenerator.nextInt(5);
		System.out.print(number + " ");
		for (int i = 0; i < number; i++) {
			x = randomGenerator.nextInt(nodes);
			y = randomGenerator.nextInt(nodes);
			while (!edgeCheckTree() || x == y) {
				x = randomGenerator.nextInt(nodes);
				y = randomGenerator.nextInt(nodes);
			}
			;
			System.out.print(x + " " + y + " ");
		}
		System.out.println();
	}

	public void customerSpawnRoute() {
		number = randomGenerator.nextInt(100);
		if (number < 19) {
			number = randomGenerator.nextInt(5);
			while (number == 0) {	// Random number cannot be 0
				number = randomGenerator.nextInt(5);
			}
			System.out.print(number + " ");
			for (int i = 0; i < number; i++) {
				int l = randomGenerator.nextInt(100);
				if (l < 29 || number2 == 0 || number2 == 1) {
					x = randomGenerator.nextInt(nodes);
					y = randomGenerator.nextInt(nodes);
					while (!edgeCheck() || x == y) {
						x = randomGenerator.nextInt(nodes);
						y = randomGenerator.nextInt(nodes);
					}
				} else {
					int z = randomGenerator.nextInt(number2 - 1);
					x = route[2 * z];
					y = route[(2 * z) + 1];
				}
				route[2 * number2] = x;
				route[(2 * number2) + 1] = y;
				number2++;
				System.out.print(x + " " + y + " ");
			}
			System.out.println();
		} else {
			System.out.println("0");
		}
	}

	/*
	 * Runs all methods that are required by the user, change this at will
	 */
	public void run() {
		info();
		conNodes = new int[nodes][10];
		conAmount = new int[nodes];
		display = new int[nodes];
		isConnected = new boolean[nodes];
		number2 = callList * 10;
		route = new int[number2];
		number2 = 0;
		fill();
		// sickGraph();
		// asickGraph();
		randomGraph();
		removeDup();
		result();
		for (int i = 0; i < callList; i++) {
			// customerSpawn();
			// customerSpawnTree();
			if (training == i) { // if only when customerSpawnDecline();
				o = 100;
				number2 = 0;
			}
			customerSpawnRoute();
			// customerSpawnDecline();
		}
		System.out.println("finito");
	}

	public static void main(String[] args) {
		(new Main()).run();
	}

}