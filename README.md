<H1>Genetic Algorithm - 0/1 Multi-Constraint (Multidimensional) Knapsack Problem</H1>
<i><h3>Shalin Shah</h3></i>
<P>A genetic algorithm implementation for the multidimensional knapsack problem. The multi-constraint (or multidimensional) knapsack problem is a generalization of the 0/1 knapsack problem. The multi-constraint knapsack problem has m constraints and one objective function to be maximized while all the m constraints are satisfied.<P>The implementation is similar to the one described in this paper "<i>A Genetic Algorithm for the Multiconstraint Knapsack Problem" by Beasley and Chu</i>, but its <i>significantly different</i>. It uses Lagrangian multipliers as constraint weights and compared to the paper, it finds close to optimum solutions much faster. (Convergence can be controlled using the parameters).</p>
<p>A description of the algorithm (slightly different), as applied to the 0/1 knapsack problem, can be found in <a href="https://github.com/shah314/hard-knapsack-problems/raw/master/gaknapsack.pdf">my paper</a>.</p>
<b>Cited By:</b><ul><li>Jovanovic, Dragana, "Solution of multidimensional problems by application of genetic algorithm" (2012).</li><li>Yoon, Yourim, Yong-Hyuk Kim, and Byung-Ro Moon. "A theoretical and empirical investigation on the Lagrangian capacities of the 0-1 multidimensional knapsack problem." European Journal of Operational Research 218.2 (2012): 366-376.</li></ul></li>

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
