<H1>GKNAP: Genetic Algorithm - 0/1 Multi-Constraint (Multidimensional) Knapsack Problem</H1>
<i><h3>Shalin Shah</h3></i>
<a href="https://zenodo.org/badge/latestdoi/134312370"><img src="https://zenodo.org/badge/134312370.svg" alt="DOI"></a>
<br>
<P>A genetic algorithm implementation for the multidimensional knapsack problem. The multi-constraint (or multidimensional) knapsack problem is a generalization of the 0/1 knapsack problem. The multi-constraint knapsack problem has m constraints and one objective function to be maximized while all the m constraints are satisfied.<P>The implementation is similar to the one described in [Chu98], but its <i>significantly different</i>. It uses Lagrangian multipliers as constraint weights and compared to the paper, it finds close to optimum solutions much faster. (Convergence can be controlled using the parameters).</p>
<p><b>There is a C++ and a Java implementation. The Java implementation is the preferred way of using the algorithm.</b></p>
<p>Please see <a href="https://arxiv.org/abs/1908.08022">this paper</a> for a detailed description of the algorithm.</p>
<b>Cited By:</b><ul><li>Jovanovic, Dragana, "Solution of multidimensional problems by application of genetic algorithm" (2012).</li><li>Yoon, Yourim, Yong-Hyuk Kim, and Byung-Ro Moon. "A theoretical and empirical investigation on the Lagrangian capacities of the 0-1 multidimensional knapsack problem." European Journal of Operational Research 218.2 (2012): 366-376.</li></ul></li>

<pre>
<b>Usage</b>
The usage of this code base is to just compile the code and run it on the command line.
The code will output the solution found, the value of the objective function and 
the chosen items for the knapsack. The code requires a <b>weing</b> formatted file or an <b>orlib</b> formatted file.
The <b>weing</b> formatted files are available <a href="http://people.brunel.ac.uk/~mastjjb/jeb/orlib/files/mknap2.txt">here</a>.
The <b>orlib</b> formatted files are available <a href="http://people.brunel.ac.uk/~mastjjb/jeb/orlib/mknapinfo.html">here</a>.

<b>Java implementation</b>
I tested the code using JDK 1.8, but any JDK should work fine. If the code does not compile, please open an issue.
Compile the Java code and then run GeneticAlgorithm.

javac *.java
java GeneticAlgorithm filename format

(The file name contains the instance in weing or orlib format)
(The format is either weing or orlib)
Example: 
java GeneticAlgorithm data.DAT weing

<b>C++ implementation</b>
The code was tested on a Mac with gcc version 8, downloaded using homebrew. 
If the code does not compile, please open an issue.
Compile the C++ code and then run the executable.

g++ cmultiknapsack.cpp
./a.out filename format

(The file name contains the instance in weing or orlib format)
(The format is either weing or orlib)
Example: 
./a.out data.DAT weing

(Please remove all comments and other extraneous text from data.DAT)
(See the tests directory for <b>testcpp.sh and testjava.sh</b> for an example run)

<b>Dependencies</b>
The code has no other dependencies. A JDK or a gcc compiler is all that is required.

<b>Using the code as an API</b>
If you want to use the code as an API call from your own code:
<b>Java:</b> In GeneticAlgorithm.java, please see the main method.
<b>C++:</b> In the C++ code, please see the main method.
</pre>

The benchmark instances are available <a href="http://people.brunel.ac.uk/~mastjjb/jeb/orlib/files/mknap2.txt">here</a>. They have the following format:
<pre>
 //This is the WEING1.DAT data file plus some comments, that are NOT part of the problem instance.
 
 2 28 // 2 knapsacks, 28 objects
 1898 440 22507 270 14148 3100 4650 30800 615 4975
 1160 4225 510 11880 479 440 490 330 110 560
 24355 2885 11748 4550 750 3720 1950 10500 // 28 weights
 600 600 // 2 knapsack capacities
 45 0 85 150 65 95 30 0 170 0
 40 25 20 0 0 25 0 0 25 0
 165 0 85 0 0 0 0 100 // #1 constr.
 30 20 125 5 80 25 35 73 12 15
 15 40 5 10 10 12 10 9 0 20
 60 40 50 36 49 40 19 150 // #2 constr.
 
 141278 // optimum value
</pre>

The comments beginning with "//" are only for the purpose of explaining the format. <b>Please remove all comments before running the algorithm</b>.

<p>The algorithm was run on a few <a href="http://people.brunel.ac.uk/~mastjjb/jeb/orlib/files/mknap2.txt">benchmark
instances</a>:</p>
<div align="left">
  <table>
    <tr>
      <td   ><b>Instance</b></td>
      <td   ><b>Optimum</b></td>
      <td   ><b>Found - Best</b></td>
      <td   ><b>Found - Worst</b></td>
      <td   ><b>Time (s)</b></td>
    </tr>
    <tr>
      <td  >Weing1</td>
      <td  >141278</td>
      <td  >141278</td>
      <td  >141278</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weing2</td>
      <td  >130883</td>
      <td  >130883</td>
      <td  >130883</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weing3</td>
      <td  >95677</td>
      <td  >95677</td>
      <td  >95677</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weing4</td>
      <td  >119337</td>
      <td  >119337</td>
      <td  >119337</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weing5</td>
      <td  >98796</td>
      <td  >98796</td>
      <td  >98796</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weing6</td>
      <td  >130623</td>
      <td  >130623</td>
      <td  >130623</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weing7</td>
      <td  >1095445</td>
      <td  >1095445</td>
      <td  >1095445</td>
      <td  >2</td>
    </tr>
    <tr>
      <td  >Weing8</td>
      <td  >624319</td>
      <td  >624319</td>
      <td  >624319</td>
      <td  >4</td>
    </tr>
    <tr>
      <td  >Sento1</td>
      <td  >7772</td>
      <td  >7772</td>
      <td  >7772</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Sento2</td>
      <td  >8722</td>
      <td  >8722</td>
      <td  >8722</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish01</td>
      <td  >4554</td>
      <td  >4554</td>
      <td  >4554</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish02</td>
      <td  >4536</td>
      <td  >4536</td>
      <td  >4536</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  height="25">Weish03</td>
      <td  height="25">4115</td>
      <td  height="25">4115</td>
      <td  height="25">4115</td>
      <td  height="25">0</td>
    </tr>
    <tr>
      <td  >Weish04</td>
      <td  >4561</td>
      <td  >4561</td>
      <td  >4561</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish05</td>
      <td  >4514</td>
      <td  >4514</td>
      <td  >4514</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish06</td>
      <td  >5557</td>
      <td  >5557</td>
      <td  >5557</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish07</td>
      <td  >5567</td>
      <td  >5567</td>
      <td  >5567</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish08</td>
      <td  >5605</td>
      <td  >5605</td>
      <td  >5605</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish09</td>
      <td  >5246</td>
      <td  >5246</td>
      <td  >5246</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish10</td>
      <td  >6339</td>
      <td  >6339</td>
      <td  >6339</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish11</td>
      <td  >5643</td>
      <td  >5643</td>
      <td  >5643</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish12</td>
      <td  >6339</td>
      <td  >6339</td>
      <td  >6339</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish13</td>
      <td  >6159</td>
      <td  >6159</td>
      <td  >6159</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish14</td>
      <td  >6954</td>
      <td  >6954</td>
      <td  >6954</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish15</td>
      <td  >7486</td>
      <td  >7486</td>
      <td  >7486</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weish16</td>
      <td  >7289</td>
      <td  >7289</td>
      <td  >7289</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish17</td>
      <td  >8633</td>
      <td  >8633</td>
      <td  >8633</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish18</td>
      <td  >9580</td>
      <td  >9580</td>
      <td  >9580</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish19</td>
      <td  >7698</td>
      <td  >7698</td>
      <td  >7698</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish20</td>
      <td  >9450</td>
      <td  >9450</td>
      <td  >9450</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish21</td>
      <td  >9074</td>
      <td  >9074</td>
      <td  >9074</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weish22</td>
      <td  >8947</td>
      <td  >8947</td>
      <td  >8947</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weish23</td>
      <td  >8344</td>
      <td  >8344</td>
      <td  >8344</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish24</td>
      <td  >10220</td>
      <td  >10220</td>
      <td  >10220</td>
      <td  >2</td>
    </tr>
    <tr>
      <td  >Weish25</td>
      <td  >9939</td>
      <td  >9939</td>
      <td  >9939</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >Weish26</td>
      <td  >9584</td>
      <td  >9584</td>
      <td  >9584</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish27</td>
      <td  >9819</td>
      <td  >9819</td>
      <td  >9819</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish28</td>
      <td  >9492</td>
      <td  >9492</td>
      <td  >9492</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish29</td>
      <td  >9410</td>
      <td  >9410</td>
      <td  >9410</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >Weish30</td>
      <td  >11191</td>
      <td  >11191</td>
      <td  >11191</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >PB1</td>
      <td  >3090</td>
      <td  >3090</td>
      <td  >3076</td>
      <td  >9</td>
    </tr>
    <tr>
      <td  >PB2</td>
      <td  >3186</td>
      <td  >3186</td>
      <td  >3186</td>
      <td  >2</td>
    </tr>
    <tr>
      <td  >PB4</td>
      <td  >95168</td>
      <td  >95168</td>
      <td  >95168</td>
      <td  >1</td>
    </tr>
    <tr>
      <td  >PB5</td>
      <td  >2139</td>
      <td  >2139</td>
      <td  >2139</td>
      <td  >2</td>
    </tr>
    <tr>
      <td  >PB6</td>
      <td  >776</td>
      <td  >776</td>
      <td  >776</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >PB7</td>
      <td  >1035</td>
      <td  >1035</td>
      <td  >1035</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >HP1</td>
      <td  >3418</td>
      <td  >3404</td>
      <td  >3404</td>
      <td  >0</td>
    </tr>
    <tr>
      <td  >HP2</td>
      <td  >3186</td>
      <td  >3186</td>
      <td  >3186</td>
      <td  >4</td>
    </tr>
  </table>
</div>

<h2>References</h2>

[Ahuja00] “A greedy genetic algorithm for the quadratic assignment problem”, R. Ahuja, J. Orlin, A. Tiwari, Computers and Operations Research, vol. 27, issue 10 (Sept. 2000), 917--934, ACM (2000)

[Angeline95] “Adaptive and self-adaptive evolutionary computations”, P. Angeline, Computational Intelligence: A Dynamic Systems Perspective, IEEE press, 152—163 (1995)

[Coello02] “Theoretical and Numerical Constraint Handling Techniques used with Evolutionary Algorithms: A Survey of the State of the Art”, C. Coello, Computer Methods in Applied Mechanics and Engineering, 191 (11--12), 1245-1287, January 2002 (2002)

[Chu98] “A Genetic Algorithm for the Multidimensional Knapsack Problem”, PC Chu, JE Beasley, Journal of Heuristics, vol. 4, 6 —86 (1998)

[DeJong93] “On the state of evolutionary computation” K. De Jong and W. Spears, Proceedings of the Fifth ICGA, 618--623. Kaufmann, San Mateo, CA. (1993)

[Eshelman91] “The CHC adaptive search algorithm: How to have safe search when engaging in non-traditional genetic recombination”, L. Eshelman, Foundations of Genetic Algorithms, Morgan Kaufmann (1991)

[Goldberg89] “Genetic Algorithm in Search, Optimization and Machine Learning”, D. E. Goldberg, Addison Wesley publishing company, Massachusetts (1989)

[Gordon94] “A note on the performance of genetic algorithms on zero-one knapsack problems”, V. Gordon, A.P. Böhm, D. Whitley, Proceedings of the 1994 ACM symposium on Applied computing, 194--195 (1994)

[Greene00] “Partitioning sets with genetic algorithms”, W. Greene, Proceedings of the Thirteenth International Florida Artificial Intelligence Research Society Conference, 2000, AAAI press, 102—105 (2000)

[Grefen85] “Genetic algorithms for the traveling salesman problem”, J. Grefenstette, R. Gopal, B. Rosimaita, and D. V. Gucht, Proceedings of an International Conference on Genetic Algorithms and their Applications, pp. 160--168, Carnegie Mellon publishers (1985)

[Hill99] “A Monte-Carlo study of genetic algorithm initial population generation methods”, R. Hill, Proceedings of the 31st conference on winter simulation: Simulation---a bridge to the future - Volume 1, 1999, 543--547 (1999)

[Hinterding97] “Adaptation in Evolutionary Computation: A Survey”, R. Hinterding, Z. Michalewicz, A.E. Eiben, In Proc of the 4th IEEE Conf. on Evolutionary Computation (pp. 65-69) (1997)

[Holland75] “Adaptation in natural and artificial systems”, MIT press, Cambridge, Massachusetts (1975)

[Julstrom05] “Greedy, Genetic and Greedy Genetic Algorithms for the Quadratic Knapsack Problem”, B. Julstrom, Proceedings of the Genetic and Evolutionary Computation Conference (GECCO 2005) vol. 1, 607—614 (2005)

[Julstrom95] “Very greedy crossover in a genetic algorithm for the traveling salesman problem”, B. Julstrom, Proceedings of the 1995 ACM Symposium on Applied Computing, 324--328 (1995)

[Khuri94] “The Zero/One Multiple Knapsack Problem and Genetic Algorithms”, S. Khuri, T. Back and J. Heitkoetter, Proceedings of the 1994 ACM Symposium on Applied Computing, 188---193, March 1994 (1994)

[Kirkpatrick83] “Optimization by simulated annealing”, S. Kirkpatrick, Science, Number 4598, 13 May 1983, volume 220, 4598, 671--680 (1983)

[Kotta98] “A Hybrid Genetic Algorithm for the 0-1 Multiple Knapsack Problem”, C. Kotta and J.M. Troya, Artificial Neural Networks and Genetic Algorithms 3, 251--255, Springer-Verlag 1998 (1998)

[Martello90] “Knapsack Problems Algorithms and Computer Implementations”, S. Martello and P. Toth, John Wiley and Sons (1990)

[Melikhov96] “Some new features in genetic solution of the traveling salesman problem”, K. Melikhov, Proceedings of ACEDC '96 PEDC, University of Plymouth, UK (1996)

[Miller93] “An Evaluation of Local Improvement Operators for Genetic Algorithms”, J. Miller, W. Potter, R. Gandham, C. Lapena, IEEE Transactions on Systems, Man and Cybernetics, vol. 23, number 5, 1340—1351 (1993)

[Pisinger05] “Where are the hard knapsack problems?”, D. Pisinger, Computers and Operations Research, vol. 32, No. 9 (September 2005), 2271—2284 (2005)

[Raidl98] “An Improved Genetic Algorithm for the Multiconstrained 0-1 Knapsack Problem”, G.R. Raidl, Evolutionary Computation Proceedings, 1998. IEEE World Congress on Computational Intelligence, 207—211, May 1998 (1998)

[Simes01] “An Evolutionary Approach to the Zero/One Knapsack Problem: Testing Ideas from Biology”, A. Simes, E. Costa, 5th International Conference on Artificial Neural Networks and Genetic Algorithms (ICANNGA 2001), Prague, Czech Republic (2001)

[Smith96] “Self adaptation of mutation Rates in a Steady State Genetic Algorithm”, J. Smith, T. Fogarty, Proceedings of IEEE International Conference Evolutionary Computing ICEC ’96 (1996)

[Spears95] “Adapting Crossover in Evolutionary Algorithms”, W. Spears, Proceedings of 4th Annual Conf. on Evolutionary Computing, 367--384, (1995)

[Syswerda89] “Uniform crossover in genetic algorithms”, Proceedings of the 3rd international conference on genetic algorithms, Morgan Kaufman (1989)

[Whitley93] “Serial and Parallel Genetic Algorithms as Function Optimizers”, V. Gordon, L. Whitley, Proceedings of the 5th International Conference on Genetic Algorithms, 177--183, 1993 (1993)
