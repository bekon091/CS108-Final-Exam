/**
 *  Final Exam
 *  This file manages the actual game simulation, and allows for the searching of Champion details and a simulated game.
 *  CS108-4
 *  Date 5/14/20
 *  @author  Kevin Uy
 */
import java.util.Queue;
import java.util.Scanner;

public class GameSimulator extends TeamBuilder{
    public static void main (String args[ ]){
        char userInput;
        Scanner us = new Scanner(System.in);

        System.out.println("Welcome to League of Legends! Press x to start a game, or press z to search for the details of a champion.");
        userInput = us.next().charAt(0);
        if(userInput =='z'){ //Searching for a specific champion's details
            ChampionList list = new ChampionList();
            list.createChampionList();
            list.sortChampionList();
            list.printChampionList();
            list.searchChampion(0,list.championList.size());
        }
        else if(userInput == 'x') { //Starts a simulated game, and allows you to submit your custom team.
            TeamBuilder game1 = new GameSimulator();
            game1.createRedTeam(); //Begins with creating Red Team, then the Blue Team
            game1.createBlueTeam();
            game1.printTeam(redTeam); //Shows the details of both teams before beginning the game
            System.out.println("VS");
            game1.printTeam(blueTeam);

            while (!isGameFinished()) { //Checks if the game is finished
                System.out.println("Press x to start a team fight. Press z to view both teams.");
                userInput = us.next().charAt(0);
                if (userInput == 'x') { //If the user decides to start a fight, it simulates a single team fight
                    game1.startTeamFight();
                } else if (userInput == 'z') { //The user can check the details of both teams again
                    game1.printTeam(redTeam);
                    System.out.println("VS");
                    game1.printTeam(blueTeam);
                } else { //Prompts the user to try again if they inputted something other than x or z.
                    System.out.println("Invalid input! Try again.");
                }
            }
        }
        else{ //Exits the program if the user input was incorrect.
            System.out.println("Invalid input! Game exited.");
        }

    }
    public Queue<Champion> createRedTeam(){ //This method prompts the user to input the five members of their team, Red
        for(int i = 0; i<= 4; i++) {
            System.out.println("Input next Red Champion name, role, and damage type.");
            redTeam.add(new Champion(sc.next(), sc.next(), sc.next()));
        }
        return redTeam;
    }

    public Queue<Champion> createBlueTeam(){ //This method prompts the user to input the five members of the enemy team, Blue
        for(int i = 0; i<= 4; i++) {
            System.out.println("Input next Blue Champion name, role, and damage type.");
            blueTeam.add(new Champion(sc.next(), sc.next(), sc.next()));
        }
        return blueTeam;
    }
    public void printTeam(Queue<Champion> team) { //Prints the details of each of the champions on the specified team.
        for (Champion champ : team) {
            System.out.println(champ.name + " " + champ.role + " " + champ.dmgType + " " + champ.level);
        }
    }


    public static boolean isGameFinished(){ //Checks to see if either team has reached the maximum level in League of Legends, 18.
        if(redTeam.peek().level == 18) {
            System.out.println("Victory! Red Team wins.");
            return true;
        }
        else if(blueTeam.peek().level == 18){
            System.out.println("Defeat! Blue Team wins.");
            return true;
        }
        else{
            return false;
        }
    }
}
