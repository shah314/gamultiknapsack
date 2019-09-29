import java.util.*;

/**
 * Mutation.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Mutator 
{
    /**
     * Update the mutation rate for adaptive mutation
     */
    public static void updateMutationRate(KNode oldBest, KNode gBest)
    {
        if(oldBest.fitness() == gBest.fitness())
        {
            if(Constants.MUTATION_PROBABILITY < Constants.MAX_MUTATION_PROBABILITY)
            {
                Constants.MUTATION_PROBABILITY+=Constants.MUTATION_INCREMENT;
            }
        }
        else
        {
            Constants.MUTATION_PROBABILITY = Constants.MUTATION_INCREMENT;
        }
    }
    
    /**
     * Mutate the genome.
     * @param n The knapsack genome
     */
    public static KNode mutate(KNode n)
    {
        BitSet set = n.getKnapsackContents();
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            double rand = Math.random();
            if(rand < Constants.MUTATION_PROBABILITY)
            {
                if(set.get(i))
                {
                    set.set(i, false);
                }
                else
                {
                    set.set(i, true);
                }
            }
        }
        
        int [] weights = Util.calculateWeights(set);
        int value = Util.calculateValue(set);
        KNode node = new KNode(set, 0, weights, value);
        return node;
    }
}
