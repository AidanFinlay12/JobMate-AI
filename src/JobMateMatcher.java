import java.util.ArrayList;

public class JobMateMatcher {

    public static void main(String[] args) {

        String[] candidateSkills = {"Java", "SQL", "Git", "HTML"};
        String[] jobSkills = {"Java", "C#", "SQL", "Git"};

        MatchResult result = calculateMatch(candidateSkills, jobSkills);

        System.out.println("Match Percentage: " + result.getMatchPercentage() + "%");
    }

    public static MatchResult calculateMatch(String[] candidateSkills, String[] jobSkills) {

        ArrayList<String> matchedSkills = new ArrayList<>();
        ArrayList<String> missingSkills = new ArrayList<>();
        ArrayList<String> relatedSkills = new ArrayList<>();

        double score = 0.0;

        if (jobSkills.length == 0) {
            return new MatchResult(
                    0.0,
                    matchedSkills,
                    relatedSkills,
                    missingSkills
            );
        }

        for (int i = 0; i < jobSkills.length; i++) {

            boolean foundMatch = false;
            boolean relatedMatchFound = false;
            String relatedCandidateSkill = null;


            for (int j = 0; j < candidateSkills.length; j++) {

                if (jobSkills[i].equalsIgnoreCase(candidateSkills[j])) {
                    foundMatch = true;
                    score += 1.0;
                    matchedSkills.add(jobSkills[i]);
                    break;
                } else if (areRelatedSkills(jobSkills[i], candidateSkills[j])) {
                    relatedMatchFound = true;
                    relatedCandidateSkill = candidateSkills[j];

                }
            }

            if (!foundMatch && relatedMatchFound) {
                score += 0.5;
                relatedSkills.add(jobSkills[i] + " <- " + relatedCandidateSkill);
            }
            else if (!foundMatch) {
                missingSkills.add(jobSkills[i]);
            }
        }

        double matchPercentage = score / jobSkills.length * 100;

        return new MatchResult(
                matchPercentage,
                matchedSkills,
                relatedSkills,
                missingSkills
        );
    }

    public static boolean areRelatedSkills(String skill1, String skill2) {

        if ((skill1.equalsIgnoreCase("Java") && skill2.equalsIgnoreCase("C#")) ||
                (skill1.equalsIgnoreCase("C#") && skill2.equalsIgnoreCase("Java"))) {
            return true;
        }

        if ((skill1.equalsIgnoreCase("JavaScript") && skill2.equalsIgnoreCase("TypeScript")) ||
                (skill1.equalsIgnoreCase("TypeScript") && skill2.equalsIgnoreCase("JavaScript"))) {
            return true;
        }

        return false;
    }
}