

import java.util.ArrayList;

public class MatchResult {

    private double matchPercentage;

    private ArrayList<String> requiredMatchedSkills;
    private ArrayList<String> requiredRelatedSkills;
    private ArrayList<String> requiredMissingSkills;

    private ArrayList<String> preferredMatchedSkills;
    private ArrayList<String> preferredRelatedSkills;
    private ArrayList<String> preferredMissingSkills;

    public MatchResult(
            double matchPercentage,
            ArrayList<String> requiredMatchedSkills,
            ArrayList<String> requiredRelatedSkills,
            ArrayList<String> requiredMissingSkills,
            ArrayList<String> preferredMatchedSkills,
            ArrayList<String> preferredRelatedSkills,
            ArrayList<String> preferredMissingSkills) {

        this.matchPercentage = matchPercentage;
        this.requiredMatchedSkills = requiredMatchedSkills;
        this.requiredRelatedSkills = requiredRelatedSkills;
        this.requiredMissingSkills = requiredMissingSkills;
        this.preferredMatchedSkills = preferredMatchedSkills;
        this.preferredRelatedSkills = preferredRelatedSkills;
        this.preferredMissingSkills = preferredMissingSkills;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public ArrayList<String> getRequiredMatchedSkills() {
        return requiredMatchedSkills;
    }

    public ArrayList<String> getRequiredRelatedSkills() {
        return requiredRelatedSkills;
    }

    public ArrayList<String> getRequiredMissingSkills() {
        return requiredMissingSkills;
    }

    public ArrayList<String> getPreferredMatchedSkills() {
        return preferredMatchedSkills;
    }

    public ArrayList<String> getPreferredRelatedSkills() {
        return preferredRelatedSkills;
    }

    public ArrayList<String> getPreferredMissingSkills() {
        return preferredMissingSkills;
    }
}