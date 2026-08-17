import java.util.ArrayList;

public class MatchResult {
    private double matchPercentage;
    private ArrayList<String> matchedSkills;
    private ArrayList<String> relatedSkills;
    private ArrayList<String> missingSkills;

    public MatchResult(double matchPercentage, ArrayList<String> matchedSkills, ArrayList<String> relatedSkills, ArrayList<String> missingSkills){
        this.matchPercentage = matchPercentage;
        this.matchedSkills = matchedSkills;
        this.relatedSkills = relatedSkills;
        this.missingSkills = missingSkills;

    }

    public double getMatchPercentage(){
        return matchPercentage;
    }

    public ArrayList<String> getMatchedSkills() {
        return matchedSkills;
    }

    public ArrayList<String> getRelatedSkills() {
        return relatedSkills;
    }

    public ArrayList<String> getMissingSkills() {
        return missingSkills;
    }
}
