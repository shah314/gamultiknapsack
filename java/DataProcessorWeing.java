import java.util.*;
import java.io.*;

/**
 * Data Processor of the ORLIB format.
 * http://people.brunel.ac.uk/~mastjjb/jeb/orlib/mknapinfo.html
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class DataProcessorWeing
{
    /**
     * Process the data from the file specified by the constant ORLIB_FILE in Constants.java
     */
    public static void processData(String filename) throws Exception
    {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String numOBJ = reader.readLine();
        StringTokenizer token = new StringTokenizer(numOBJ, " \t");
        Constants.NUMBER_CONSTRAINTS = Integer.parseInt(token.nextToken().trim());
        Constants.NUMBER_OBJECTS = Integer.parseInt(token.nextToken().trim());
        String profits = reader.readLine();
        token = new StringTokenizer(profits, " \t");
        int i=0;
        Constants.VALUES = new double[Constants.NUMBER_OBJECTS];
        while(true)
        {
            while(token.hasMoreTokens())
            {
                String ss = token.nextToken().trim();
                if(ss.equals("") || ss.equals(" "))
                {
                    continue;
                }
                Constants.VALUES[i] = Double.parseDouble(ss);
                i++;
            }
            if(i < Constants.NUMBER_OBJECTS)
            {
                profits = reader.readLine();
                token = new StringTokenizer(profits, " \t");
            }
            else
            {
                break;
            }
        }

        String capacities = reader.readLine();
        token = new StringTokenizer(capacities, " \t");
        Constants.CAPACITIES = new double[Constants.NUMBER_CONSTRAINTS];
        i=0;

        while(true)
        {
            while(token.hasMoreTokens())
            {
                Constants.CAPACITIES[i] = Double.parseDouble(token.nextToken().trim());
                i++;
            }

            if(i < Constants.NUMBER_CONSTRAINTS)
            {
                capacities = reader.readLine();
                token = new StringTokenizer(capacities, " \t");
            }
            else
            {
                break;
            }
        }

        Constants.CONSTRAINTS = new double[Constants.NUMBER_CONSTRAINTS][Constants.NUMBER_OBJECTS];
        for(i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            String constraint = reader.readLine();
            token = new StringTokenizer(constraint, " \t");
            Constants.CONSTRAINTS[i] = new double[Constants.NUMBER_OBJECTS];
            int j=0;
            while(true)
            {
                while(token.hasMoreTokens())
                {
                    String ss = token.nextToken().trim();
                    if(ss.equals("") || ss.equals(" "))
                    {
                        continue;
                    }
                    Constants.CONSTRAINTS[i][j] = Double.parseDouble(ss);
                    j++;
                }

                if(j < Constants.NUMBER_OBJECTS)
                {
                    constraint = reader.readLine();
                    token = new StringTokenizer(constraint, " \t");
                }
                else
                {
                    break;
                }
            }
        }
        String opt = reader.readLine().trim();
        while(true)
        {
            if(opt.equals("") || opt.equals(" "))
            {
                opt = reader.readLine().trim();
            }
            else
            {
                opt = opt.trim();
                Constants.OPTIMUM = Double.parseDouble(opt);
                break;
            }
        }
    }
}
