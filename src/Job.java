import java.util.ArrayList;

public class Job {
    private String title;
    private String company;
    private ArrayList<String> requiredSkills;
    private ArrayList<String> preferredSkills;

    public Job(String title, String company, ArrayList<String> requiredSkills, ArrayList<String> preferredSkills){
        this.title = title;
        this.company = company;
        this.requiredSkills = requiredSkills;
        this.preferredSkills = preferredSkills;

    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    public ArrayList<String> getPreferredSkills() {
        return preferredSkills;
    }
}
