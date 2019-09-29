import java.util.*;
import java.io.*;

/**
 * Implementation of the greedy crossover.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class GreedyCrossover 
{
    /**
     * Implementation of the Greedy Crossover
     */
    public static KNode [] greedyCrossover(KNode node1, KNode node2)
    {
        BitSet set1 = node1.getKnapsackContents();
        BitSet set2 = node1.getKnapsackContents();
        List list = new ArrayList();
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(set1.get(i) || set2.get(i))
            {
                double weight = -1;
                for(int j=0; j<Constants.NUMBER_CONSTRAINTS;j++)
                {
                    double ww = LagrangianRelaxation.LAMBDAS[j]*Constants.CONSTRAINTS[j][i];
                    weight+=ww; 
                }
                weight/=Constants.NUMBER_CONSTRAINTS;
                double ratio = (double)Constants.VALUES[i]/(double)weight;
                CompareObject obj = new CompareObject(i, ratio);
                list.add(obj);
            }
        }
        
        Collections.sort(list);
        Iterator it = list.iterator();
        int count = 0;
        BitSet set = new BitSet(Constants.NUMBER_OBJECTS);
        KNode node = new KNode(set, 0, 0);
        while(it.hasNext())
        {
            CompareObject obj = (CompareObject)it.next();
            int index = obj.index;
            node.addOne(index);
            if(!Util.isValidSolution(node))
            {
                node.resetBit(index);
            }
        }
        
        /* Try to improve upon the crossed solution */
        it = GreedyAlgorithm.greedyObjects.iterator();
        while(it.hasNext())
        {
            GreedyAlgorithm.CompareObject obj = (GreedyAlgorithm.CompareObject)it.next();
            int i = obj.index;
            if(!node.getKnapsackContents().get(i))
            {
                node.addOne(i);
                if(!Util.isValidSolution(node))
                {
                    node.resetBit(i);
                }
            }
        }
        
        //int [] weights = Util.calculateWeights(set);
        //int value = Util.calculateValue(set);
        //node = new KNode(set, 0, weights, value);
        return new KNode[]{node};
    }
    
    /**
     * Used for Sorting.
     */
    public static class CompareObject implements Comparable
    {
        public double ratio;
        public int index;
        
        public CompareObject(int in, double r)
        {
            ratio = r;
            index = in;
        }
        
        public int compareTo(Object obj)
        {
            CompareObject o = (CompareObject)obj;
            double or = o.ratio;
            if(or < ratio)
            {
                return -1;
            }
            else if(or > ratio)
            {
                return 1;
            }
            
            return 0;
        }
    }
}
