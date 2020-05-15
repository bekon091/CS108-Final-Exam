/**
 *  Final Exam
 *  This file handles the creation of the list of the original 17 champions available in League of Legends, and sorts
 *  the list, and also includes a binary search method for finding the details of a specific champion.
 *  CS108-4
 *  Date 5/14/20
 *  @author  Kevin Uy
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ChampionList {
    ArrayList<Champion> championList = new ArrayList<Champion>(17);

    public ArrayList<Champion> createChampionList(){ //Creates the list of the original 17 Champions, unsorted
        championList.add(new Champion("Alistar", "Support","Magical"));
        championList.add(new Champion("Warwick", "Jungle","Physical"));
        championList.add(new Champion("Ashe", "ADC","Physical"));
        championList.add(new Champion("Fiddlesticks", "Jungle","Magical"));
        championList.add(new Champion("Annie", "Middle","Magical"));
        championList.add(new Champion("Jax", "Top","Physical"));
        championList.add(new Champion("Morgana", "Support","Magical"));
        championList.add(new Champion("Kayle", "Top","Mixed"));
        championList.add(new Champion("Nunu", "Jungle","Magical"));
        championList.add(new Champion("Ryze", "Middle","Magical"));
        championList.add(new Champion("Sion", "Top","Physical"));
        championList.add(new Champion("MasterYi", "Jungle","Physical"));
        championList.add(new Champion("Sivir", "ADC","Physical"));
        championList.add(new Champion("Teemo", "Top","Magical"));
        championList.add(new Champion("Soraka", "Support","Magical"));
        championList.add(new Champion("Tristana", "ADC","Physical"));
        championList.add(new Champion("TwistedFate", "Middle","Magical"));
        return championList;
    }

    public void sortChampionList(){
        int indexPrevious;
        Champion temp;
        for(int i = 0; i<championList.size() -1 ; i++){ //Selection sorting the list to be alphabetical
            indexPrevious = i;

            for(int j = i+1; j<championList.size(); j++){
                if(championList.get(j).name.compareTo(championList.get(indexPrevious).name) < 0){ //Compares the names of the adjacent Champions
                    indexPrevious = j;
                }
            }

            temp = championList.get(i); //Replaces the Champions into the correct positions
            championList.set(i,championList.get(indexPrevious));
            championList.set(indexPrevious, temp);
        }
    }

    public void printChampionList(){ //Prints the list of Champions and their details
        for(Champion champ : championList){
            System.out.println(champ.name + " " + champ.role + " " + champ.dmgType + " "  + champ.level);
        }
    }

    public void searchChampion(int lowVal, int highVal){ //Binary Searches through the list to find the user's Champion
        Scanner scnr = new Scanner(System.in);
        int midValue;
        char userAnswer;

        midValue = (highVal + lowVal)/2;

        System.out.print("Is your champion: " + championList.get(midValue).name + "? (y/n)");
        userAnswer = scnr.next().charAt(0);
        if(userAnswer == 'y'){
            System.out.println(championList.get(midValue).name + " " + championList.get(midValue).role + " " + championList.get(midValue).dmgType);
        }
        else{
            System.out.print("Is your champion's name before or after " + championList.get(midValue).name + "'s name? (b/a)");
            userAnswer = scnr.next().charAt(0);
            if(userAnswer=='b'){ //Searches the lower bound
                searchChampion(lowVal,midValue);
            }
            else{ //Searches the upper bound
                searchChampion(midValue+1,highVal);
            }
        }
    }

}
