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

        int x, y = 0;
        int angle = 0;
        int instruction_number = 0;

        //file

        try {

            File myObj = new File(file);
            Scanner reader = new Scanner(myObj);
            String regex = "[.\\s\\.]";

            while (reader.hasNextLine()){
                
                String line = reader.nextLine().trim();
                
                String[] command_line = line.split(regex);

                System.out.println(command_line);
            }
            
        } 
        
        
        catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }


    }
}