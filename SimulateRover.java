import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimulateRover{

    public static void main (String[] args){

        //mars rover project

        if (args.length != 1){
            System.out.println("Error not enough arguments");
            System.exit(1);

        }

        simulate(args[0]);
    }

    //outside main scope

    public static void simulate(String file){


    }
}