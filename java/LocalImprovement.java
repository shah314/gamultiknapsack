
import java.util.*;

/**
 * Improve upon the solution randomly.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class LocalImprovement {
    
    /**
     * Improve upon the solution locally using a randomized hill climbing routine
     */
    public static KNode randomImprovement(KNode node)
    {
        BitSet set = node.getKnapsackContents();
        KNode best = new KNode((BitSet)set.clone(), node.getIndex(), node.weights(), node.value());
        
        for(int i=0; i<Constants.NUMBER_OF_TIMES; i++)
        {       
            KNode temp = new KNode(set, 0);
            int count = 0;
            while(true)
            {
                int rand = Util.generateRandomNumber(0, Constants.NUMBER_OBJECTS-1);
                if(set.get(rand) == true)
                {
                    temp.resetBit(rand);
                    count++;
                }
                
                if(count == Constants.REMOVE)
                {
                    break;
                }
            }
        
            Iterator it = GreedyAlgorithm.greedyObjects.iterator();
            while(it.hasNext())
            {
                GreedyAlgorithm.CompareObject o = (GreedyAlgorithm.CompareObject)it.next();
                int index = o.index;
                if(set.get(index) == false)
                {
                    temp.addOne(index);
                    if(!Util.isValidSolution(temp))
                    {
                        temp.resetBit(index);
                    }
                }
            }
            
            if(temp.fitness() > best.fitness())
            {
                best = new KNode((BitSet)set.clone(), temp.getIndex(), temp.weights(), temp.value());
            }
        }
        
        return best;
    }
}
