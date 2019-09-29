import java.util.*;
import java.io.*;

/**
 * Implemetation of One Point Crossover.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class OnePointCrossover 
{    
    /**
     * One Point Crossover
     */
    public static KNode [] onePointCrossover(KNode node1, KNode node2)
    {
        BitSet one = node1.getKnapsackContents();
        BitSet two = node2.getKnapsackContents();
        
        int rand = Util.generateRandomNumber(0, Constants.NUMBER_OBJECTS);
        BitSet set1 = new BitSet(Constants.NUMBER_OBJECTS);
        BitSet set2 = new BitSet(Constants.NUMBER_OBJECTS);
        for(int i=0; i<rand; i++)
        {
            boolean flag1 = one.get(i);
            boolean flag2 = two.get(i);
            set1.set(i, flag1);
            set2.set(i, flag2);
        }
        
        for(int i=rand; i<Constants.NUMBER_OBJECTS; i++)
        {
            boolean flag1 = two.get(i);
            boolean flag2 = one.get(i);
            set1.set(i, flag1);
            set2.set(i, flag2);
        }
        
        int value1 = Util.calculateValue(set1);
        int value2 = Util.calculateValue(set2);
        int [] weights1 = Util.calculateWeights(set1);
        int [] weights2 = Util.calculateWeights(set2);
        
        KNode n1 = new KNode(set1, 0, weights1, value1);
        KNode n2 = new KNode(set2, 0, weights2, value2);
        
        return new KNode[]{n1, n2};
    }
}
