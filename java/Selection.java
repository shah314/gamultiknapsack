import java.util.*;

/**
 * Random Selection.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Selection 
{    
    /**
     * Random Selection
     */
    public static KNode[] randomSelection(List population)
    {
        int rand1 = (int)(Math.random()*population.size());
        int rand2 = (int)(Math.random()*population.size());
        KNode node1 = (KNode)population.get(rand1);
        KNode node2 = (KNode)population.get(rand2);
        int count = 0;
        return new KNode[]{node1, node2};
    }
    
    /**
     * Shuffle the whole population due to a lot of duplicates.
     * This happens due to the nature of the greedy crossover.
     */
    public static void shuffle(List population)
    {
        System.out.println("Shuffling...");
        Iterator it = population.iterator();
        double oldprob = Constants.MUTATION_PROBABILITY;
        Constants.MUTATION_PROBABILITY = Constants.SHUFFLE_PROBABILITY;
        List newPopulation = new ArrayList();
        while(it.hasNext())
        {
            KNode node = (KNode)it.next();
            node = Mutator.mutate(node);
            it.remove();
            newPopulation.add(node);
        }
        
        population.addAll(newPopulation);
        Constants.MUTATION_PROBABILITY = oldprob;
    }
}
