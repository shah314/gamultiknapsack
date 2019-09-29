import java.util.*;

/**
 * Generates random initial population.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class PopulationGenerator 
{
    /**
     * Generate random initial population
     */
    public static List generateRandomPopulation()
    {
        List population = new ArrayList();
        for(int i=0; i<Constants.POPULATION; i++)   
        {
            KNode node = new KNode(new BitSet(Constants.NUMBER_OBJECTS), 0, 0);
            for(int j=0; j<Constants.NUMBER_OBJECTS; j++)
            {
                double rand = Math.random();
                if(rand < Constants.INITIAL_POPULATION_PROBABILITY)
                {
                    node.addOne();
                }
                else
                {
                    node.addZero();
                }
            }
            node.setCrossoverType(Util.randomCrossoverType());
            population.add(node);
        }
        
        return population;
    }
}
