package woowacouse2;

public class Q4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        boolean isLogin = false;
        boolean isBasket = false;
        for(int i=0; i<actions.length; i++) {
            String[] action = actions[i].split(" ");
            if(action[0].equals("LOGIN")) {
                if(!isLogin) {
                    for(int j=0; j<infos.length; j++) {
                        String[] info = infos[j].split(" ");
                        if(action[1].equals(info[0]) && action[2].equals(info[1])) {
                            isLogin = true;
                            answer[i] = true;
                            break;
                        }
                    }
                }
            } else if(action[0].equals("ADD")) {
                if(isLogin) {
                    answer[i] = true;
                    isBasket = true;
                }
            } else if(action[0].equals("ORDER")) {
                if(isBasket) {
                    answer[i] = true;
                    isBasket = false;
                }
            }
        }
        return answer;
    }

}