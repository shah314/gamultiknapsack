import java.util.*;

/**
 * Calculates lagrangian multipliers.
 * @author  Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class LagrangianRelaxation {
    
    /** The Lagrangian Multipliers */
    public static double [] LAMBDAS = new double[Constants.NUMBER_CONSTRAINTS];
    /** Lagrangian Solution */
    public static double [] SOLUTION = new double [Constants.NUMBER_OBJECTS];
    public static double [] VALUES = new double[Constants.NUMBER_OBJECTS];
    
    /**
     * Calculate the optimum Lagrangian multipliers
     */
    public static void calculateLambda()
    {
        double increment = Constants.INITIAL_INCREMENT;
        double tolerance = Constants.LAMBDA_TOLERANCE;
        
        while(true)
        {   
            int count = 0;
            double prevValue = -1;
            while(true)
            {
                BitSet solution = calculateSolution();
                int [] weights = Util.calculateWeights(solution);
                boolean flag = true;
                double value = calculateValue();
                if(prevValue == -1)
                {
                    prevValue = value;
                }
                else
                {
                    double diff = Math.abs(prevValue - value);
                    if(diff < Constants.DIFF_TOLERANCE)
                    {
                        count++;
                        if(count >= Constants.COUNT_TOLERANCE)
                        {
                            count = 0;
                            break;
                        }
                    }
                    else
                    {
                        count = 0;
                    }
                    prevValue = value;
                }
                       
                for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
                {
                    if(weights[i] < Constants.CAPACITIES[i])
                    {
                        if(LAMBDAS[i] > 0)
                        {
                            LAMBDAS[i]-=increment;
                            if(LAMBDAS[i] < 0)
                            {
                                LAMBDAS[i] = 0;
                            }
                        }
                    }
                    else if(weights[i] > Constants.CAPACITIES[i])
                    {
                        flag = false;
                        LAMBDAS[i]+=increment;
                    }
                }
            }
            
            if(increment <= tolerance)
            {
                break;
            }
            increment/=2;
        }
    }
    
    /**
     * Calculate the solution represented by the Lagrangian multipliers
     */
    public static BitSet calculateSolution()
    {
        double [] solution = new double[Constants.NUMBER_OBJECTS];
        KNode knapsack = new KNode(new BitSet(Constants.NUMBER_OBJECTS), 0);
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            double w = 0;
            for(int j=0; j<Constants.NUMBER_CONSTRAINTS; j++)
            {
                double ww = (double)Constants.CONSTRAINTS[j][i];
                ww*=LAMBDAS[j];
                w+=ww;
            }
            double v = (double)Constants.VALUES[i] - w;
            solution[i] = v;
        }
        
        SOLUTION = solution;
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(solution[i] < 0)
            {
                knapsack.getKnapsackContents().set(i, false);
            }
            else
            {
                knapsack.getKnapsackContents().set(i, true);
            }
        }
        
        return knapsack.getKnapsackContents();
    }
    
    /**
     * Calculate the upper bound on the value
     */
    public static double calculateValue()
    {
        double value = 0;
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            double ll = LAMBDAS[i]*(double)Constants.CAPACITIES[i];
            value+=ll;
        }
        
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            if(SOLUTION[i] > 0)
            {
                value+=SOLUTION[i];
            }
        }
        
        return value;
    }
    
    /** 
     * Calculate the maximum value possible to be achieved
     * when a partial knapsack is passed in 
     */
    public static double calculateValue(BitSet set, int index)
    {
        int size = index;
        double value = 0;
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            double ll = LAMBDAS[i]*(double)Constants.CAPACITIES[i];
            value+=ll;
        }
        
        for(int i=0; i<size; i++)
        {
            if(set.get(i) == true)
            {
                value+=SOLUTION[i];
            }
        }
        
        if(VALUES[index-1] != 0)
            return value+=VALUES[index-1];
        
        double value1 = 0;
        for(int i=size; i<Constants.NUMBER_OBJECTS;i++)
        {
            if(SOLUTION[i] > 0)
            {
                value1+=SOLUTION[i];
            }
        }
        
        VALUES[index-1] = value1;
        return value+value1;
    }
}
