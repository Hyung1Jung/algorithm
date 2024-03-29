package src.kakao.blind;

import java.util.*;

public class 순위검색 {

    Map<String, Integer> Wordmap = new HashMap<>();
    List<List<Integer>> ScoreList = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        Wordmap.put("-", 0);
        Wordmap.put("cpp", 1);
        Wordmap.put("java", 2);
        Wordmap.put("python", 3);
        Wordmap.put("backend", 1);
        Wordmap.put("frontend", 2);
        Wordmap.put("junior", 1);
        Wordmap.put("senior", 2);
        Wordmap.put("chicken", 1);
        Wordmap.put("pizza", 2);
        for (int i = 0; i < 4 * 3 * 3 * 3; ++i)
            ScoreList.add(new ArrayList<>());

        for (String str : info) {
            String[] word = str.split(" ");
            int[] arr = {Wordmap.get(word[0]) * 3 * 3 * 3,
                    Wordmap.get(word[1]) * 3 * 3,
                    Wordmap.get(word[2]) * 3,
                    Wordmap.get(word[3])};
            int score = Integer.parseInt(word[4]);

            for (int i = 0; i < (1 << 4); ++i) {
                int idx = 0;
                for (int j = 0; j < 4; ++j) {
                    if ((i & 1 << j) != 0) {
                        idx += arr[j];
                    }
                }
                ScoreList.get(idx).add(score);
            }
        }
        for (int i = 0; i < 4 * 3 * 3 * 3; ++i)
            Collections.sort(ScoreList.get(i));

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            String[] word = query[i].split(" ");
            int idx = Wordmap.get(word[0]) * 3 * 3 * 3 +
                    Wordmap.get(word[2]) * 3 * 3 +
                    Wordmap.get(word[4]) * 3 +
                    Wordmap.get(word[6]);
            int score = Integer.parseInt(word[7]);
            int ret = Collections.binarySearch(ScoreList.get(idx), score);
            if (ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; --j) {
                    if (ScoreList.get(idx).get(j) == score) {
                        ret = j;
                    } else {
                        break;
                    }
                }
            }
            answer[i] = ScoreList.get(idx).size() - ret;
        }
        return answer;
    }

    public static void main(String[] args) {
        순위검색 instance = new 순위검색();

        String[] info = new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        System.out.println(Arrays.toString(instance.solution(info, query)));
    }
}
