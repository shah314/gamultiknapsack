import java.util.*;

/**
 * Utility functions
 * @author  Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Util {
    
    public static Random random = new Random();
    /** 
     * Generate a random number in the range
     * @param min The minimimum value of the range
     * @param max The maximum value of the range
     */
    public static int generateRandomNumber(int min, int max)
    {
        int r;
        r = (int) (random.nextDouble() * (max - min + 1)) + min;
        return r;
    }
    
    /** 
     * Generate a double random number in the range
     * @param min The minimimum value of the range
     * @param max The maximum value of the range
     */
    public static double generateDoubleRandom(double min, double max)
    {
        double r;
        r = (double) (random.nextDouble() * (max - min)) + min;
        return r;
    }
    
    /**
     * Is the passed in genome a valid solution? Does it violate any of the constraints?
     */
    public static boolean isValidSolution(KNode sack)
    {
        if(sack.violatesConstraints())
        {
            return false;
        }
        
        return true;
    }
    
    /**
     * Is the passed in genome a valid solution? Does it violate any of the constraints?
     */
    public static boolean isValidSolution(BitSet sack) 
    {
        int [] weight = calculateWeights(sack);
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            if(weight[i] > Constants.CAPACITIES[i])
            {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Calculate the weights represented by the passed in BitSet of chosen objects.
     */
    public static int [] calculateWeights(BitSet set)
    {
        int [] weights = new int[Constants.NUMBER_CONSTRAINTS];
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(set.get(i) == true)
            {
                for(int j=0; j<Constants.NUMBER_CONSTRAINTS; j++)
                {
                    double weight = Constants.CONSTRAINTS[j][i];
                    weights[j]+=weight;
                }
            }
        }
        return weights;
    }
    
    /**
     * Calculate the value represented by the passed in BitSet of chosen objects.
     */
    public static int calculateValue(BitSet set)
    {
        int value = 0;
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(set.get(i) == true)
            {
                value+=Constants.VALUES[i];
            }
        }
        return value;
    }
    
    /**
     * Generate a random crossover Type
     */
    public static int randomCrossoverType()
    {
        return (int)(Math.random()*2);
    }
}
