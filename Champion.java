/**
 *  Final Exam
 *  This file holds the details of each Champion.
 *  CS108-4
 *  Date 5/14/20
 *  @author  Kevin Uy
 */
public class Champion {
    protected String name; //Champion's name
    protected String role; //Champion's preferred role
    protected String dmgType; //Champion's damage type, Physical, Magical, or Mixed
    protected int level;

    public Champion(){ //Default Constructor

    }

    public Champion(String nameInput, String roleInput, String dmgInput){
        name = nameInput;
        role = roleInput;
        dmgType = dmgInput;
        level = 1; //Each Champion starts at level 1.
    }
}
