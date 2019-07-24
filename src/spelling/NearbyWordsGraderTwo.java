package spelling;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;

public class NearbyWordsGraderTwo {
    public static void main(String args[]) {
        int tests = 0;
        int incorrect = 0;
        StringBuilder feedback = new StringBuilder();
        PrintWriter out;

        try {
            out = new PrintWriter("grader_output/module5.part2.out");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            Dictionary d = new DictionaryHashSet();
            DictionaryLoader.loadDictionary(d, "test_cases/dict2.txt");
            NearbyWords nw = new NearbyWords(d);

            feedback.append("** Test 1: 2 suggestions... ");
            List<String> d1 = nw.suggestions("dag", 4);
            feedback.append("").append(d1.size()).append(" suggestions returned.\n");

            feedback.append("** Test 2: Checking suggestion correctness... ");
            feedback.append("Suggestions: ");
            for (String i : d1) {
                feedback.append(i).append(", ");
            }

            feedback.append("\n** Test 3: 3 suggestions... ");
            d1 = nw.suggestions("fare", 3);
            feedback.append("").append(d1.size()).append(" suggestions returned.\n");

            feedback.append("** Test 4: Checking suggestion correctness... ");
            feedback.append("Suggestions: ");
            for (String i : d1) {
                feedback.append(i).append(", ");
            }
            feedback.append("\n");
            
        } catch (Exception e) {
            out.println(feedback + "Runtime error: " + e);
            return;
        }

        out.println(feedback.append("Tests complete. Make sure everything looks right."));
        out.close();
    }
}
