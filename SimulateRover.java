import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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

        int x = 0;
        int y = 0;
        int angle = 0;
        int instruction_number = 1;

        //file

        try {

            File myObj = new File(file);
            Scanner reader = new Scanner(myObj);
            String regex = "[.\\s\\.]";

            System.out.println("I'm at (%d, %d) facing %d degrees".formatted(x, y, angle));

            while (reader.hasNextLine()){
                
                String line = reader.nextLine().toLowerCase();
                
                String[] command_line = line.split(regex);

                if (command_line.length != 4){
                    System.out.println("I've encountered an instruction I don't understand, aborting (instruction %d)".formatted(instruction_number));
                    System.exit(1);
                }

                if (Arrays.asList(command_line).contains("move")){

                    int distance = Integer.parseInt(command_line[1]);
                    double radians = Math.toRadians(angle);

                    //"Moving {distance:.2f} meters {command_line[3]} (instruction {instruction_number:.2f})"

                    if (Arrays.asList(command_line).contains("forward")){

                        x += Math.round(distance * Math.cos(radians));
                        y += Math.round(distance * Math.sin(radians));
                        System.out.println("Moving %d meters forward (instruction %d)".formatted(distance, instruction_number));

                    }

                    else if (Arrays.asList(command_line).contains("backward")){

                        x -= Math.round(distance * Math.cos(radians));
                        y -= Math.round(distance * Math.sin(radians));
                        System.out.println("Moving %d meters backward (instruction %d)".formatted(distance, instruction_number));
                    }
                    
                    System.out.println("I'm at (%d, %d) facing %d degrees".formatted(x, y, angle));

                }

                else if (Arrays.asList(command_line).contains("turn")){

                    int turn_angle = Integer.parseInt(command_line[1]);

                    // System.out.println("turn");

                    if (command_line[3].equals("clockwise")){
                        angle += turn_angle;
                    }

                    else if (command_line[3].equals("counterclockwise")){
                        angle -= turn_angle;
                    }
                    else {
                        System.out.println("I've encountered an instruction I don't understand, aborting (instruction %d)".formatted(instruction_number));
                        System.exit(1);

                    }

                    angle = Math.round(angle % 360);

                    //"Turning {turn_angle:.2f} degrees {command_line[3]} (instruction {instruction_number:.2f})"
                    System.out.println("Turning %d degrees %s (instruction %d)".formatted(turn_angle, command_line[3], instruction_number));
                    System.out.println("I'm at (%d, %d) facing %d degrees".formatted(x, y, angle));

                }

                instruction_number ++;
            }
            
        } 
        
        
        catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }


    }
}