/**
 * Constants
 * @author  Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Constants {

    public static int [] VALUES = null; // populated automatically
    public static int [][] CONSTRAINTS = null; // populated automatically
    public static int [] CAPACITIES = null; // populated automatically
    public static int NUMBER_CONSTRAINTS = 10; // populated automatically
    public static final String CONSTRAINT_FILE__PREFIX = "constraint";
    public static String ORLIB_FILE = "orlib4.txt";
    public static String WEING_FILE = "data.DAT";
    public static String DIRECTORY = "D:\\javacode\\gamultiKnapsack\\data\\";
    public static int NUMBER_OBJECTS = 50;// populated automatically
    public static boolean SHOW_WINDOW = false;

    /* GA parameters */
    public static int POPULATION = 100;
    public static int GENERATIONS = 10;
    public static double INITIAL_POPULATION_PROBABILITY = 0.9;
    public static int GREEDY_CROSSOVER = 0;
    public static int ONE_POINT_CROSSOVER = 1;
    public static double MUTATION_PROBABILITY; // populated automatically
    public static double MUTATION_INCREMENT; // populated automatically
    public static double MAX_MUTATION_PROBABILITY; // populated automatically
    public static int NEGATIVE_FITNESS = -100;
    public static int OPTIMUM; // populated automatically
    public static boolean OPTIMUM_FOUND = false;
    public static int SHUFFLE_TOLERANCE = 10;
    public static double SHUFFLE_PROBABILITY; // populated automatically
    public static int GBEST; // populated automatically
    public static int MAX_TIME = 60 * 1000;

    /* Lagrangian Relaxation Parameters */
    public static double INITIAL_LAMBDA = 0;
    public static double INITIAL_INCREMENT = 0.01;
    public static double LAMBDA_TOLERANCE = 0.00000001;
    public static int COUNT_TOLERANCE = 100;
    public static int DIFF_TOLERANCE = 2;

    /* Local Improvement */
    public static int NUMBER_OF_TIMES = 10;
    public static int REMOVE = 5;
}
