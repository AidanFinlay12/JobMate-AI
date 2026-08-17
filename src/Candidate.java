import java.util.ArrayList;

public class Candidate {

    private String name;
    private ArrayList<String> skills;
    private String education;
    private String experience;

    public Candidate(String name,ArrayList<String> skills, String education, String experience){
        this.name = name;
        this.skills = skills;
        this.education = education;
        this.experience = experience;

    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public String getExperience() {
        return experience;
    }
}
