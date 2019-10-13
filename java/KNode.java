import java.util.*;

/**
 * The knapsack genome in the genetic algorithm.
 * @author  Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class KNode implements Comparable
{
    private BitSet knapsack = null;
    private double maxValue = 0;
    private boolean pruned = false;
    private boolean fathomed = false;
    private int index = 0;
    private int value;
    private int [] weights;
    private int crossoverType;
    
    /** Creates a new instance of KNode */
    public KNode(BitSet k, int ind, int [] w, int v) {
        knapsack = k;
        index = ind;
        weights = w;
        value = v;
    }
    
    /** Creates a new instance of KNode */
    public KNode(BitSet k, int ind, int v) {
        knapsack = k;
        index = ind;
        weights = new int[Constants.NUMBER_CONSTRAINTS];
        value = v;
    }
    
    /** Creates a new instance of KNode */
    public KNode(BitSet set, int ind)
    {
        knapsack = set;
        index = ind;
        weights = Util.calculateWeights(set);
        value = Util.calculateValue(set);
    }
   
    /** Creates a new instance of KNode */
    public KNode()
    {
        knapsack = new BitSet(Constants.NUMBER_OBJECTS);
        index = 0;
        weights = new int[Constants.NUMBER_CONSTRAINTS];
        value = 0;
    }
    
    /**
     * Get the current index
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Get the weights of the chosen objects.
     * This corresponds to the multiple constraints specified by Constants.CAPACITIES.
     */
    public int [] weights()
    {   
        return weights;
    }
    
    /*
     * Get the value (profit) of this node
     */
    public int value()
    {
        if(knapsack == null)
            return 0;
        
        return value;
    }
    
    /*
     * The fitness of the genome
     */
    public int fitness()
    {
        if(violatesConstraints())
        {
            return Constants.NEGATIVE_FITNESS;
        }
        
        return value();
    }
   
    /**
     * Add a one to the BitSet of this node. This means that the object represented
     * by index is chosen
     */
    public void addOne()
    {
        value+=Constants.VALUES[index];
        
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            double weight = Constants.CONSTRAINTS[i][index];
            weights[i]+=weight;
        }
        
        knapsack.set(index, true);
        index++;
    }
    
    /**
     * Add a one to the BitSet of this node. This means that the object represented
     * by index is chosen
     */
    public void addOne(int in)
    {
        value+=Constants.VALUES[in];
        
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            double weight = Constants.CONSTRAINTS[i][in];
            weights[i]+=weight;
        }
        
        knapsack.set(in, true);
    }
    
    /**
     * Add a one to the BitSet of this node. This means that the object represented
     * by index is chosen
     */
    public void resetBit(int in)
    {
        if(knapsack.get(in) == false)
        {
            return;
        }
        
        value-=Constants.VALUES[in];
        
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            double weight = Constants.CONSTRAINTS[i][in];
            weights[i]-=weight;
        }
        
        knapsack.set(in, false);
    }
    
    
    
    /**
     * Add a zero to the BitSet of this node. This means that the object represented by 
     * index is not chosen
     */
    public void addZero()
    {
        knapsack.set(index, false);
        index++;
    }
    
    /** 
     * CompareTo method of the interface Comparable
     */
    public int compareTo(Object obj) {
        KNode o = (KNode)obj;

        if(o.fitness() > this.fitness())
        {
            return 1;
        }
        else if(o.fitness() < this.fitness())
        {
            return -1;
        }
       
        return 0;
    }
    
    /**
     * Get the BitSet represented by this node
     */
    public BitSet getKnapsackContents()
    {
        return knapsack;
    }
    
    /**
     * Does this knapsack violate any constraints?
     */
    public boolean violatesConstraints()
    {
        for(int i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            if(weights[i] > Constants.CAPACITIES[i])
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Get the crossover type
     */
    public int crossoverType()
    {
        return crossoverType;
    }
    
    /**
     * Set the crossover type
     */
    public void setCrossoverType(int type)
    {
        crossoverType = type;
    }
}
