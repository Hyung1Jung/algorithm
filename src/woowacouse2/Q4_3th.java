package woowacouse2;

import java.util.Arrays;


public class Q4_3th {

    public int solution(int n, int[][] board){
        Position currentPosition = new Position(0,0);
        Position targetPosition = new Position(0,0); //단순 초기화상태
        int totalDistance = 0;


        for (int i = 1; i<= n*n; i++){
            targetPosition = targetPosition.findTargetPosition(board, i);
            int distance = currentPosition.getCurrentToTargetDistance(board, targetPosition);
            totalDistance += distance;
            currentPosition.setXY(targetPosition);
        }

        int answer = totalDistance + n*n;
        return answer;
    }


    class Position {
        private int x;
        private int y;

        public Position findTargetPosition(int[][] board, int value){
            for(int i=0; i<board.length; i++){
                for(int j=0; j< board[i].length; j++){
                    if(board[i][j] == value){
                        this.setXY(i,j);
                        return this;
                    }
                }
            }
            throw new RuntimeException("보드에 존재하지 않는 숫자입니다.");
        }

        public int getCurrentToTargetDistance(int[][] board, Position targetPosition){

            int length = board.length;
            int originDistance = Math.abs(this.x - targetPosition.getX()) + Math.abs(this.y - targetPosition.getY());
            int xWarpDistance = Math.abs(Math.abs(this.x - targetPosition.getX()) - length) + Math.abs(this.y - targetPosition.getY());
            int yWarpDistance = Math.abs(this.x - targetPosition.getX()) + Math.abs(Math.abs(this.y - targetPosition.getY()) - length);
            int xyWarpDistance = Math.abs(Math.abs(this.x - targetPosition.getX()) - length) + Math.abs(Math.abs(this.y - targetPosition.getY()) - length);
            int[] temp = new int[]{originDistance, xWarpDistance, yWarpDistance,xyWarpDistance};
            Arrays.sort(temp);
            System.out.println(board[targetPosition.getX()][targetPosition.getY()] +"  "+ temp[0]);
            return temp[0];
        }

        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void setXY(Position targetPosition){
            this.x = targetPosition.getX();
            this.y = targetPosition.getY();
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    public static void main(String[] args) {

    }
}
