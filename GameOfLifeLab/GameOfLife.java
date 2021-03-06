import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have these default values
    private static int ROWS = 10;
    private static int COLS = 10;
    private static int iter = 5;
    private static int sleepTime = 1000;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @param pattern the pattern specified by the user
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife(String pattern)
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame(pattern);

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid based on predefined patterns/custom patterns
     *
     * @param pattern the pattern specified by the user
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame(String pattern)
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();

        // create and add rocks (a type of Actor) to the initial locations
        int[] x;
        int[] y;
        if(pattern.toLowerCase().equals("default"))
        {
            x = new int[] {0,0,1,2,2,2,2,3,3,4,4,4,5,5,5,6,6,7,7,7,7,8,9,9};
            y = new int[] {0,2,1,0,2,5,7,3,6,4,5,7,2,4,5,3,6,2,4,7,9,8,7,9};

        }
        else if(pattern.toLowerCase().equals("line"))
        {
            x = new int[] {4,4,4,4,4,4,4,4,4,4};
            y = new int[] {0,1,2,3,4,5,6,7,8,9};

        }
        else
        {
            x = new int[] {0};
            y = new int[] {0};

        }
        for(int i=0;i<x.length;i++)
        {
            Rock rock1 = new Rock();
            Location loc1 = new Location(x[i], y[i]);
            grid.put(loc1, rock1);
        }
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        //new empty grid to store the next generation
        BoundedGrid<Actor> newGrid = new BoundedGrid<Actor>(ROWS,COLS);

        // insert magic here...
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                Location loc = new Location(row, col);
                int size = grid.getOccupiedAdjacentLocations(loc).size();
                if( size == 3 || (getActor(row, col)!= null && size ==2))
                {
                    newGrid.put(loc, new Rock());
                }
            }
        }

        world.setGrid(newGrid);
        world.show();
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. Provides convenient execution. Allows user to choose a pattern.
     *
     */
    public static void main(String[] args)
    throws InterruptedException
    {
        //Clear Terminal
        for(int i = 0;i<255;i++)
        {
            System.out.println();
        }
        
        GameOfLife game;
        
        String pattern = "default";
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("Pattern: default, line or custom?");
        pattern = s.next();
        if(pattern.toLowerCase().equals("default"))
        {
            iter = 10;
            game = new GameOfLife(pattern);
        }
        else if(pattern.toLowerCase().equals("custom"))
        {
            //need to test dims so that the grid/world is valid.
            boolean acceptableDims = false;
            while(acceptableDims!=true)
            {
                System.out.println("Rows?");
                ROWS = s.nextInt();
                if(ROWS >=1){acceptableDims=true;}
            }
            acceptableDims=false;
            while(acceptableDims!=true)
            {
                System.out.println("Columns?");
                COLS = s.nextInt();
                if(COLS >=1){acceptableDims=true;}
            }
            game = new GameOfLife(pattern); //places rock to start.
            System.out.println("Would you like to remove the automatically-placed rock? (y/n)");
            String remRock = s.next();
            if(remRock.toLowerCase().equals("y"))
            {
                game.world.getGrid().remove(new Location(0,0));
                game.world.show();
            }
            System.out.println("Make your pattern, then enter any character and press enter.");
            s.next();
            System.out.println("How many iterations?");
            iter = s.nextInt();
            System.out.println("How many milliseconds between iterations?");
            sleepTime = s.nextInt();
        }
        else //default pattern
        {
            game = new GameOfLife(pattern);
        }

        //delay and loop
        Thread.sleep(sleepTime);
        for(int i=0;i<iter;i++)
        {
            game.createNextGeneration();
            Thread.sleep(sleepTime);
        }
    }

}
