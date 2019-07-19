import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Displays the results of the algorithm in a window
 * @author  Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class AlgorithmWindow {
    
    public static JFrame frame;
    public static WindowThread thread;
    
    public int beginminutes = 0;
    public int beginseconds = 0;
    
    /** Creates a new instance of AlgorithmWindow */
    public AlgorithmWindow() {
        frame = new JFrame("Genetic Algorithm for the 0/1 Knapsack Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new WindowThread();
        //Display the window.
        Dimension d = new Dimension(500, 200);
        
        frame.pack();
        frame.setSize(d);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        JLabel emptyLabel = new JLabel("Greedy Solution (Maximizing V/W)::");
        frame.getContentPane().add(emptyLabel);
        KNode sack = GreedyAlgorithm.runGreedyAlgorithm();
        frame.getContentPane().add(new JLabel("** Value: " + sack.fitness()));
        frame.getContentPane().add(new JLabel("---------------------------------"));
        JLabel emptyLabel2 = new JLabel("Top Three Genetic Algorithm Solutions::");
        frame.getContentPane().add(emptyLabel2);
        frame.getContentPane().add(new JLabel(""));
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        beginminutes = minute;
        beginseconds = second;
        JLabel begin = new JLabel("Begin: " + hour + ":" + minute + ":" + second);
        frame.getContentPane().add(begin);
    }
    
    /** Display the current search space in the window */
    public void show(java.util.List o, int generation)
    {   
        if(!thread.isAlive())
            thread.start();
        thread.setDisplayObject(o, generation);
    }
    
    public void stop()
    {
        thread.flag = false;
    }
    
     public void done()
        {
            JLabel emptyLabel = new JLabel("");
            String s = "Done.";
            emptyLabel.setText(s);
            //emptyLabel.setPreferredSize(new Dimension(175, 100));
            frame.getContentPane().add(emptyLabel);
            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            JLabel end = new JLabel("End: " + hour + ":" + minute + ":" + second);
            frame.getContentPane().add(end);
            
            if(beginminutes > minute)
            {
                minute+=60;
            }
            
            int diffm = minute - beginminutes;
            diffm*=60;
            int diffs = second- beginseconds;
            diffm+=diffs;
            JLabel timeTaken = new JLabel("**Time Taken: " + diffm + " seconds.");
            frame.getContentPane().add(timeTaken);
            frame.repaint();
            frame.setVisible(true);
        }
     
     public void greedyFound()
     {
            Calendar cal = new GregorianCalendar();
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            
            if(beginminutes > minute)
            {
                minute+=60;
            }
            int diffm = minute - beginminutes;
            diffm*=60;
            int diffs = second- beginseconds;
            diffm+=diffs;
            JLabel timeTaken = new JLabel("**Greedy Exceeded: " + diffm + " seconds.");
            frame.getContentPane().add(timeTaken);
            frame.repaint();
            frame.setVisible(true);
     }
    
     /**
      * The algorithm window thread
      */
    public static class WindowThread extends Thread
    {
        public java.util.List o;
        public volatile boolean flag = true;
        public int generation;
        
        public void setDisplayObject(java.util.List obj, int generation)
        {
            o = obj;
            this.generation = generation;
        }
        
        public void run()
        {
            JLabel emptyLabel = new JLabel("");
            JLabel emptyLabel2 = new JLabel("");
            JLabel emptyLabel3 = new JLabel("");
            JLabel gg = new JLabel("");
            JLabel rr = new JLabel("");
            JLabel ss = new JLabel("");
            JLabel mm = new JLabel("");
            
            while(flag)
            {   
                gg.setText("Generation: " + generation);
                //mm.setText("Mutation Probability: " + o.mutationProb);
                //ss.setText("Selection: " + o.selection.getClass().getName());
                //rr.setText("Replacement: " + o.replacement.getClass().getName());
                frame.getContentPane().add(gg);
                //frame.getContentPane().add(mm);
                //frame.getContentPane().add(ss);
                //frame.getContentPane().add(rr);

                Iterator it = o.iterator();
                KNode sack = null;
                Dimension d = new Dimension(500, 300);
                frame.setSize(d);
                String s = "";
                String crossover = "";
                
                if(it.hasNext())
                {
                    sack = (KNode)it.next();
                    s = "Solution 1 - " + " ** Value: " + sack.fitness();
                    
                    if(sack.crossoverType() == Constants.GREEDY_CROSSOVER)
                    {
                        crossover = "greedy crossover";
                    }
                    else if(sack.crossoverType() == Constants.ONE_POINT_CROSSOVER)
                    {
                        crossover = "one point crossover";
                    }
                    
                    s = "Solution 1 - " + " ** Value: " + sack.fitness() + " (" + crossover + ")";
                    
                    emptyLabel.setText(s);
                
                    //emptyLabel.setPreferredSize(new Dimension(175, 100));
                    frame.setSize(d);
                    frame.getContentPane().add(emptyLabel);
                }
                if(it.hasNext())
                {
                    sack = (KNode)it.next();
                    s = "Solution 1 - " + " ** Value: " + sack.fitness();
                    
                    if(sack.crossoverType() == Constants.GREEDY_CROSSOVER)
                    {
                        crossover = "greedy crossover";
                    }
                    else if(sack.crossoverType() == Constants.ONE_POINT_CROSSOVER)
                    {
                        crossover = "one point crossover";
                    }
                    
                    s = "Solution 1 - " + " ** Value: " + sack.fitness() + " (" + crossover + ")";
                    
                    emptyLabel2.setText(s);
                    frame.getContentPane().add(emptyLabel2);
                }
                
                if(it.hasNext())
                {
                    sack = (KNode)it.next();
                    s = "Solution 1 - " + " ** Value: " + sack.fitness();
                    
                    if(sack.crossoverType() == Constants.GREEDY_CROSSOVER)
                    {
                        crossover = "greedy crossover";
                    }
                    else if(sack.crossoverType() == Constants.ONE_POINT_CROSSOVER)
                    {
                        crossover = "one point crossover";
                    }
                    
                    s = "Solution 1 - " + " ** Value: " + sack.fitness() + " (" + crossover + ")";
                    
                    emptyLabel3.setText(s);
                    frame.getContentPane().add(emptyLabel3);
                }
                
                frame.repaint();
                frame.setVisible(true);
            }
        }
    }
}