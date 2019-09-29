/**
 * Adaptive Crossover
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Crossover 
{
    /**
     * Implementation of adaptive crossover
     */
    public static KNode[] crossover(KNode node1, KNode node2)
    {
        int type = -1;
        if(node1.crossoverType() == node2.crossoverType())
        {
            type = node1.crossoverType();
        }
        else
        {
            type = Util.randomCrossoverType();
        }
        
        KNode [] array = null;
        if(type == Constants.GREEDY_CROSSOVER)
        {
            array = GreedyCrossover.greedyCrossover(node1, node2);
            if(array[0].fitness() > node1.fitness())
            {
                node1.setCrossoverType(Constants.GREEDY_CROSSOVER);
                array[0].setCrossoverType(Constants.GREEDY_CROSSOVER);
            }
            else
            {
                node1.setCrossoverType(Util.randomCrossoverType());
                array[0].setCrossoverType(Util.randomCrossoverType());
            }
            
            if(array[0].fitness() > node2.fitness())
            {
                node2.setCrossoverType(Constants.GREEDY_CROSSOVER);
                array[0].setCrossoverType(Constants.GREEDY_CROSSOVER);
            }
            else
            {
                node2.setCrossoverType(Util.randomCrossoverType());
                array[0].setCrossoverType(Util.randomCrossoverType());
            }
        }
        else if(type == Constants.ONE_POINT_CROSSOVER)
        {
            array = OnePointCrossover.onePointCrossover(node1, node2);
            if(array[0].fitness() > node1.fitness())
            {
                node1.setCrossoverType(Constants.ONE_POINT_CROSSOVER);
                array[0].setCrossoverType(Constants.ONE_POINT_CROSSOVER);
            }
            else
            {
                node1.setCrossoverType(Util.randomCrossoverType());
                array[0].setCrossoverType(Util.randomCrossoverType());
            }
            
            if(array[0].fitness() > node2.fitness())
            {
                node2.setCrossoverType(Constants.ONE_POINT_CROSSOVER);
                array[0].setCrossoverType(Constants.ONE_POINT_CROSSOVER);
            }
            else
            {
                node2.setCrossoverType(Util.randomCrossoverType());
                array[0].setCrossoverType(Util.randomCrossoverType());
            }
            
            if(array[1].fitness() > node1.fitness())
            {
                node1.setCrossoverType(Constants.ONE_POINT_CROSSOVER);
                array[1].setCrossoverType(Constants.ONE_POINT_CROSSOVER);
            }
            else
            {
                node1.setCrossoverType(Util.randomCrossoverType());
                array[1].setCrossoverType(Util.randomCrossoverType());
            }
            
            if(array[1].fitness() > node2.fitness())
            {
                node2.setCrossoverType(Constants.ONE_POINT_CROSSOVER);
                array[1].setCrossoverType(Constants.ONE_POINT_CROSSOVER);
            }
            else
            {
                node2.setCrossoverType(Util.randomCrossoverType());
                array[1].setCrossoverType(Util.randomCrossoverType());
            }
        }
     
        return array;
    }
}
