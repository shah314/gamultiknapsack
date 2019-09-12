---
title: 'GKNAP: A Java and C++ package for solving the multidimensional knapsack problem'
tags:
  - Java
  - C++
  - knapsack
  - multidimensional knapsack
  - solver
  - lagrangian multipliers
  - utility ratio
authors:
  - name: Shalin Shah
    orcid: 0000-0002-3770-1391
    affiliation: 1
affiliations:
 - name: Johns Hopkins University
   index: 1
date: 12 September 2019
bibliography: paper.bib
---

# Summary
The 0/1 multidimensional (multi-constraint) knapsack problem is the 0/1 knapsack problem with m constraints. We present a genetic algorithm for the multidimensional knapsack problem with Java and C++ code that is able to solve publicly available instances in a very short computational duration. Our algorithm uses iteratively computed Lagrangian multipliers as constraint weights to augment the greedy algorithm for the multidimensional knapsack problem and uses that information in a greedy crossover in a genetic algorithm. The algorithm uses several other hyperparameters which can be set in the code to control convergence. Our algorithm improves upon the algorithm by Chu and Beasley [@chu1998genetic] in that it converges to optimum or near optimum solutions much faster.

It is possible to use the greedy algorithm as part of a genetic algorithm, and our results show that it works really well. Not only is our algorithm able to exceed the greedy estimate, but for most problem instances, it is able to find the optimum solution. Our algorithm is similar to [@shah2019genetic] which uses greedy crossover for the 0/1 knapsack problem. Since the multidimensional knapsack problem has multiple constraints, we assign a weight to each constraint using iteratively computed Lagrangian multipliers. This is similar to the approach in [@chu1998genetic] which uses surrogate multipliers. The difference is that we use the multipliers in a greedy crossover which is highly constructive and can find optimum solutions much quicker.

# Mathematics
We use Lagrangian multipliers to augment the utility ratio for the multidimensional knapsack problem according to the following steps:

For each object and for each constraint (for that object) the weight (constraint) value is multiplied with the corresponding Lagrangian multiplier the sum of these values is obtained. The value obtained is then divided by the number of constraints. Then, the ratio of the value (profit) and the value obtained in the previous step is obtained which is the profit-weight ratio for that object.

$ratio_i = v_i / ((sum_{j=1}^{m} l_j * w_{ij}) / m)$

Where m is the number of constraints, $l_j$ is the $j^{th}$ Lagrangian multiplier. The greedy crossover simply takes objects from the two parents in non-increasing order of the ratio and constructs one offspring such that it satisfies all constraints.

Our method, as applied to the 0/1 knapsack problem, is described in [@shah2019genetic]. We use techniques like simulated annealing [@kirkpatrick1983optimization] in our work to handle constraints. More details on constraint handling techniques is presented in [@coello2002theoretical]. We generate the initial population with a probability of 0.5. More on this is given in [@hill1999monte].

Traditional evolutionary algorithms are more suitable for problems in which domain specific knowledge is not available. For problems with partial knowledge of the domain, a genetic algorithm, which uses this domain knowledge, is more likely to succeed, as the results clearly indicate. A good search algorithm should be global in nature with a heuristic introduced to give constructive direction to the algorithm. We introduced a new technique of greedy crossover; it forms the core of our genetic algorithm. As table-1 shows, our algorithm is able to solve to optimality, all of the instances in a short amount of time. Some problems like Weing7 are harder. Future work could be to run the algorithm on larger instances for which optimum solutions are available. Our algorithm is trivially parallelizable and future work could be to implement the algorithm on Apache Spark or Map-Reduce.

The Java and C++ code are available here: <https://github.com/shah314/gamultiknapsack>. The problem instances are available here: <http://people.brunel.ac.uk/~mastjjb/jeb/orlib/files/mknap2.txt>.

# References
