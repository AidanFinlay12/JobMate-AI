import java.util.ArrayList;

public class JobMateMatcher {

    public static MatchResult calculateMatch(Candidate candidate, Job job) {

        ArrayList<String> requiredMatchedSkills = new ArrayList<>();
        ArrayList<String> requiredRelatedSkills = new ArrayList<>();
        ArrayList<String> requiredMissingSkills = new ArrayList<>();

        ArrayList<String> preferredMatchedSkills = new ArrayList<>();
        ArrayList<String> preferredRelatedSkills = new ArrayList<>();
        ArrayList<String> preferredMissingSkills = new ArrayList<>();

        double requiredScore = scoreSkills(
                job.getRequiredSkills(),
                candidate,
                1.0,
                0.5,
                requiredMatchedSkills,
                requiredRelatedSkills,
                requiredMissingSkills
        );

        double preferredScore = scoreSkills(
                job.getPreferredSkills(),
                candidate,
                0.5,
                0.25,
                preferredMatchedSkills,
                preferredRelatedSkills,
                preferredMissingSkills
        );

        double totalScore = requiredScore + preferredScore;

        double maxScore =
                job.getRequiredSkills().size() * 1.0
                        + job.getPreferredSkills().size() * 0.5;

        if (maxScore == 0) {
            return new MatchResult(
                    0.0,
                   requiredMatchedSkills,
                    requiredRelatedSkills,
                    requiredMissingSkills,
                    preferredMatchedSkills,
                    preferredRelatedSkills,
                    preferredMissingSkills
            );
        }

        double matchPercentage = totalScore / maxScore * 100;

        return new MatchResult(
                matchPercentage,
                requiredMatchedSkills,
                requiredRelatedSkills,
                requiredMissingSkills,
                preferredMatchedSkills,
                preferredRelatedSkills,
                preferredMissingSkills
        );
    }

    public static double scoreSkills(
            ArrayList<String> jobSkills,
            Candidate candidate,
            double exactWeight,
            double relatedWeight,
            ArrayList<String> matchedSkills,
            ArrayList<String> relatedSkills,
            ArrayList<String> missingSkills) {

        double score = 0.0;

        for (int i = 0; i < jobSkills.size(); i++) {

            boolean foundMatch = false;
            boolean relatedMatchFound = false;
            String relatedCandidateSkill = null;

            for (int j = 0; j < candidate.getSkills().size(); j++) {

                if (jobSkills.get(i).equalsIgnoreCase(candidate.getSkills().get(j))) {

                    foundMatch = true;
                    score += exactWeight;
                    matchedSkills.add(jobSkills.get(i));
                    break;

                } else if (areRelatedSkills(
                        jobSkills.get(i),
                        candidate.getSkills().get(j))) {

                    relatedMatchFound = true;
                    relatedCandidateSkill = candidate.getSkills().get(j);
                }
            }

            if (!foundMatch && relatedMatchFound) {

                score += relatedWeight;

                relatedSkills.add(
                        jobSkills.get(i)
                                + " <- "
                                + relatedCandidateSkill
                );

            } else if (!foundMatch) {

                missingSkills.add(jobSkills.get(i));
            }
        }

        return score;
    }

    public static boolean areRelatedSkills(String skill1, String skill2) {

        if ((skill1.equalsIgnoreCase("Java")
                && skill2.equalsIgnoreCase("C#"))
                ||
                (skill1.equalsIgnoreCase("C#")
                        && skill2.equalsIgnoreCase("Java"))) {

            return true;
        }

        if ((skill1.equalsIgnoreCase("JavaScript")
                && skill2.equalsIgnoreCase("TypeScript"))
                ||
                (skill1.equalsIgnoreCase("TypeScript")
                        && skill2.equalsIgnoreCase("JavaScript"))) {

            return true;
        }

        return false;
    }
}