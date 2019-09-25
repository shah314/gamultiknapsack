
import java.util.*;
import java.io.*;

/**
 * A utility to generate the problem in AMPL format.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class AMPLGenerator
{
    /**
     * Generate AMPL file
     */
    public static void main(String [] args) throws Exception
    {
        if(args.length == 0)
        {
          System.out.println("Usage: java AMPLGenerator <orlib file name>");
          System.exit(0);
        }

        DataProcessorORLIB.processData(args[0]);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Constants.DIRECTORY + "ampl.mod")));
        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            String s = "var X" + i + ";\n";
            writer.write(s);
        }

        String s = "maximize Profit: ";
        writer.write(s);

        for(int i=0; i<Constants.NUMBER_OBJECTS-1; i++)
        {
            int value = Constants.VALUES[i];
            s = "X" + i + " * " + value + " + ";
            writer.write(s);
        }
        int c = Constants.NUMBER_OBJECTS-1;
        s = "X" + c + " * " + Constants.VALUES[c] + ";\n\n";
        writer.write(s);

        for(int i=0; i < Constants.NUMBER_CONSTRAINTS; i++)
        {
            s = "subject to limit" + i + ": ";
            writer.write(s);
            for(int j=0; j<Constants.NUMBER_OBJECTS-1; j++)
            {
                int weight = Constants.CONSTRAINTS[i][j];
                s = "X" + j + " * " + weight + " + ";
                writer.write(s);
            }
            c = Constants.NUMBER_OBJECTS-1;
            s = "X" + c + " * " + Constants.CONSTRAINTS[i][c] + " <= " + Constants.CAPACITIES[i] + ";\n\n";
            writer.write(s);
        }

        for(int i=0; i<Constants.NUMBER_OBJECTS; i++)
        {
            s = "subject to limit_" + i + ": 0 <= X" + i + " <= 1;\n";
            writer.write(s);
        }

        writer.flush();
        writer.close();
    }

}
