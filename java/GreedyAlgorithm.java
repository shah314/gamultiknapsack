import java.util.*;

/**
 * Greedy Algorithm for the multi-constraint knapsack problem
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class GreedyAlgorithm
{
    public static List greedyObjects = null;

    /**
     * Main
     */
    public static void main(String [] args) throws Exception
    {
      if(args.length <= 1)
      {
        System.out.println("Usage:");
        System.out.println("java GreedyAlgorithm <filename> <fileformat weing/orlib>");
        System.out.println("Example: java GreedyAlgorithm data.DAT weing");
        System.exit(0);
      }

      if(args[1].equals("weing"))
      {
        /* Process the data from the ORLIB_FILE */
        DataProcessorWeing.processData(args[0]);
      }
      else if(args[1].equals("orlib"))
      {
        Constants.DIFF_TOLERANCE = 5000;
        DataProcessorORLIB.processData(args[0]);
      }
      else
      {
        System.out.println("Unknown file format. Exiting...");
        System.exit(1);
      }

        LagrangianRelaxation.calculateLambda();
        System.out.println(runGreedyAlgorithm().value());
    }

    /**
     * Run the greedy algorithm.
     */
    public static KNode runGreedyAlgorithm()
    {
        List list = new ArrayList();
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            double weight = 0;
            for(int j=0; j<Constants.NUMBER_CONSTRAINTS; j++)
            {
                double ww = Constants.CONSTRAINTS[j][i] * LagrangianRelaxation.LAMBDAS[j];
                weight+=ww;
            }
            weight/=Constants.NUMBER_CONSTRAINTS;
            double ratio = Constants.VALUES[i]/weight;
            CompareObject o = new CompareObject(i, ratio);
            list.add(o);
        }

        Collections.sort(list);
        greedyObjects = list;
        Iterator it = list.iterator();
        BitSet set = new BitSet(Constants.NUMBER_OBJECTS);
        while(it.hasNext())
        {
            CompareObject obj = (CompareObject)it.next();
            int index = obj.index;
            set.set(index, true);
            if(!Util.isValidSolution(set))
            {
                set.set(index, false);
            }
        }
        int value = Util.calculateValue(set);
        KNode node = new KNode(set, 0, value);
        return node;
    }

    /**
     * Used for sorting.
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
