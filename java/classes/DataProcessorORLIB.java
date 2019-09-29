import java.util.*;
import java.io.*;

/**
 * Data Processor of the ORLIB format.
 * http://people.brunel.ac.uk/~mastjjb/jeb/orlib/mknapinfo.html
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class DataProcessorORLIB
{
    /**
     * Process the data from the file specified by the constant ORLIB_FILE in Constants.java
     */
    public static void processData(String filename) throws Exception
    {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String numOBJ = reader.readLine();
        StringTokenizer token = new StringTokenizer(numOBJ, " ");
        Constants.NUMBER_OBJECTS = Integer.parseInt(token.nextToken());
        Constants.NUMBER_CONSTRAINTS = Integer.parseInt(token.nextToken());
        Constants.OPTIMUM = Integer.parseInt(token.nextToken());
        String profits = reader.readLine();
        token = new StringTokenizer(profits, " ");
        int i=0;
        Constants.VALUES = new int[Constants.NUMBER_OBJECTS];
        while(true)
        {
            while(token.hasMoreTokens())
            {
                Constants.VALUES[i] = Integer.parseInt(token.nextToken().trim());
                i++;
            }
            if(i < Constants.NUMBER_OBJECTS)
            {
                profits = reader.readLine();
                token = new StringTokenizer(profits, " ");
            }
            else
            {
                break;
            }
        }

        Constants.CONSTRAINTS = new int[Constants.NUMBER_CONSTRAINTS][Constants.NUMBER_OBJECTS];
        for(i=0; i<Constants.NUMBER_CONSTRAINTS; i++)
        {
            String constraint = reader.readLine();
            token = new StringTokenizer(constraint, " ");
            Constants.CONSTRAINTS[i] = new int[Constants.NUMBER_OBJECTS];
            int j=0;
            while(true)
            {
                while(token.hasMoreTokens())
                {
                    Constants.CONSTRAINTS[i][j] = Integer.parseInt(token.nextToken().trim());
                    j++;
                }

                if(j < Constants.NUMBER_OBJECTS)
                {
                    constraint = reader.readLine();
                    token = new StringTokenizer(constraint, " ");
                }
                else
                {
                    break;
                }
            }
        }

        String capacities = reader.readLine();
        token = new StringTokenizer(capacities, " ");
        Constants.CAPACITIES = new int[Constants.NUMBER_CONSTRAINTS];
        i=0;

        while(true)
        {
            while(token.hasMoreTokens())
            {
                Constants.CAPACITIES[i] = Integer.parseInt(token.nextToken().trim());
                i++;
            }

            if(i < Constants.NUMBER_CONSTRAINTS)
            {
                capacities = reader.readLine();
                token = new StringTokenizer(capacities, " ");
            }
            else
            {
                break;
            }
        }
    }
}
