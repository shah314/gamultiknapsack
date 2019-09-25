import java.util.*;
import java.io.*;

/**
 * Genetic Algorithm for the MultiConstraint Knapsack Problem.
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class GeneticAlgorithm
{
    /**
     * Main
     */
    public static void main(String [] args) throws Exception
    {
        if(args.length <= 1)
        {
          System.out.println("Usage:");
          System.out.println("java GeneticAlgorithm <filename> <fileformat weing/orlib>");
          System.out.println("Example: java GeneticAlgorithm data.DAT weing");
          System.exit(0);
        }

        if(args[1].equals("weing"))
        {
          /* Process the data from the ORLIB_FILE */
          DataProcessorWeing.processData(args[0]);
        }
        else if(args[1].equals("orlib"))
        {
          DataProcessorORLIB.processData(args[0])
        }
        else
        {
          System.out.println("Unknown file format. Existing...");
          System.exit(1);
        }

        /* Find Lagrangian Multipliers for greedy crossover */
        LagrangianRelaxation.calculateLambda();

        /* The greedy algorithm */
        KNode greedy = GreedyAlgorithm.runGreedyAlgorithm();
        System.out.println("Greedy Solution: " + greedy.fitness());

        /* Generate the initial population */
        List population = PopulationGenerator.generateRandomPopulation();

        /* Update mutation rates */
        Constants.MUTATION_PROBABILITY = (double)1 / (double)Constants.NUMBER_OBJECTS;;
        Constants.MUTATION_INCREMENT = (double)1 / (double)Constants.NUMBER_OBJECTS;
        Constants.MAX_MUTATION_PROBABILITY = (double)20 / (double)Constants.NUMBER_OBJECTS;
        Constants.SHUFFLE_PROBABILITY = (double)20 / (double)Constants.NUMBER_OBJECTS;

        /* Run the genetic algorithm */
        population = runGeneticAlgorithm(population);

        /* Output the global best individual */
        Collections.sort(population);
        KNode gBest = (KNode)population.iterator().next();
        Constants.GBEST = gBest.fitness();
        System.out.println("Genetic Solution: " + Util.calculateValue(gBest.getKnapsackContents()));
        int weights [] = Util.calculateWeights(gBest.getKnapsackContents());
        for(int i=0; i<weights.length; i++)
        {
            System.out.println("Weight" + (i+1) + ": " + weights[i]);
        }
    }

    /**
     * Run the genetic algorithm.
     */
    public static List runGeneticAlgorithm(List population)
    {
        long start = System.currentTimeMillis();
        KNode gBest = null;
        KNode oldBest = null;
        AlgorithmWindow window = null;

        if(Constants.SHOW_WINDOW)
            window = new AlgorithmWindow();

        for(int i=0; i<Constants.GENERATIONS; i++)
        {
            Collections.sort(population);
            List newPopulation = new ArrayList();

            if(Constants.SHOW_WINDOW)
                window.show(population, i);

            /* Elitism */
            Iterator it = population.iterator();
            gBest = (KNode)it.next();
            if(gBest.fitness() == Constants.OPTIMUM)
            {
                if(Constants.SHOW_WINDOW)
                    window.done();

                Constants.OPTIMUM_FOUND = true;
                return population;
            }
            if(oldBest == null)
            {
                oldBest = gBest;
            }

            newPopulation.add(gBest);

            /* Crossover and Mutation */
            for(int j=0; j<Constants.POPULATION;)
            {
                KNode [] parents = Selection.randomSelection(population);
                KNode [] children = Crossover.crossover(parents[0], parents[1]);
                if(children.length == 1)
                {
                    j+=1;
                    if(children[0].fitness() <= parents[0].fitness() || children[0].fitness() <= parents[1].fitness())
                        children[0] = Mutator.mutate(children[0]);
                    children[0] = LocalImprovement.randomImprovement(children[0]);
                    newPopulation.add(children[0]);
                }
                else
                {
                    j+=2;
                    if(children[0].fitness() <= parents[0].fitness() || children[0].fitness() <= parents[1].fitness())
                        children[0] = Mutator.mutate(children[0]);
                    children[0] = LocalImprovement.randomImprovement(children[0]);
                    newPopulation.add(children[0]);
                    if(children[1].fitness() <= parents[0].fitness() || children[1].fitness() <= parents[1].fitness())
                        children[1] = Mutator.mutate(children[1]);
                    children[1] = LocalImprovement.randomImprovement(children[1]);
                    newPopulation.add(children[1]);
                }
            }

            population = newPopulation;
            Mutator.updateMutationRate(oldBest, gBest);
            oldBest = gBest;

            long end = System.currentTimeMillis();
            if((end-start) > Constants.MAX_TIME)
            {
                return population;
            }
        }

        return population;
    }
}
