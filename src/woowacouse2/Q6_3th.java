package woowacouse2;

import java.util.*;

public class Q6_3th {
    public static String[] solution(String[] logs) {

        Map<String, Map<String, String>> result = new HashMap<>();

        for (String value : logs) {
            String[] temp = value.split(" ");
            String examinationNumber = temp[0];
            String questionNumber = temp[1];
            String score = temp[2];


            if (result.containsKey(examinationNumber) == false) {
                result.put(examinationNumber, new HashMap<>());
            }

            result.get(examinationNumber).put(questionNumber, score);
        }

        Set<String> duplicatedPerson = new LinkedHashSet<>();

        for (String person : result.keySet()) {
            for (String otherPerson : result.keySet()) {
                if (person.equals(otherPerson)) {
                    continue;
                }

                Map<String, String> otherTestResult = result.get(otherPerson);
                Map<String, String> testResult = result.get(person);


                if (otherTestResult.size() <= 4 || testResult.size() <= 4) {
                    continue;
                }

                if (result.get(person).equals(result.get(otherPerson))) {
                    duplicatedPerson.add(person);
                    duplicatedPerson.add(otherPerson);
                }
            }
        }
        if (duplicatedPerson.isEmpty()) {
            return new String[]{"None"};
        }
        String[] answer = duplicatedPerson.toArray(new String[duplicatedPerson.size()]);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"}));
    }

}
