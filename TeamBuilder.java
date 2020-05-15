/**
 *  Final Exam
 *  This file handles the creation of each team, as well as calculates the odds of either team winning. It also handles the result of each fight.
 *  CS108-4
 *  Date 5/14/20
 *  @author  Kevin Uy
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

abstract class TeamBuilder extends Champion implements Teamfight{
    Scanner sc = new Scanner(System.in);
    public static Queue<Champion> redTeam = new LinkedList<Champion>(); //Initializes the LinkedList of each team.
    public static Queue<Champion> blueTeam = new LinkedList<Champion>();

    public abstract Queue<Champion> createRedTeam();
    public abstract Queue<Champion> createBlueTeam();

    public abstract void printTeam(Queue<Champion> team);

    public boolean fightCalculator() { //Calculates the odds of either team winning, emulating the snowball effect of winning fights in League of Legends.
        Float percentSuccess;
        assert redTeam.peek() != null;
        assert blueTeam.peek() != null;
        int levelDifference = Math.abs(redTeam.peek().level-blueTeam.peek().level); //Checks to see the level difference of each team, doesn't matter which champion is checked
        if(redTeam.peek().level > blueTeam.peek().level) {
            percentSuccess = 0.5f + (0.02f * levelDifference); //For every level that the team is ahead, they get an additional 2% chance of winning the next team fight
        }
        else {
            percentSuccess = 0.5f - (0.02f * levelDifference);
        }
        Random rand = new Random();
        if(percentSuccess.compareTo(rand.nextFloat())>0){
            return true;
        }
        else {
            return false;
        }
    }

    public void startTeamFight(){ //Adds a level to each of the champions in the team that won.
        if(fightCalculator()){
            for(Champion champ : redTeam){
                champ.level = champ.level+1;
            }
            System.out.println("Red Team won the fight! 1 level awarded to all red champions.");
        }
        else{
            for(Champion champ : blueTeam){
                champ.level = champ.level+1;
            }
            System.out.println("Blue Team won the fight! 1 level awarded to all blue champions.");
        }
    }
}
