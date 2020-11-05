package woowacouse2;

/*
물 좋고 공기 좋은 강원도 양양의 한 개발자 마을 토지를 분양받고자 합니다.
토지는 직사각형 형태로 분양받을 수 있으며, x축(수평 방향)과 y축(수직 방향)에 의해 만들어지는 2차원 평면에서 두 점 P1(x1, y1)과 P2(x2, y2)로 표현할 수 있습니다.
마을 곳곳에는 식수원이 존재하여, 이미 분양된 토지와 겹치지 않으며 식수원 일부를 포함한 토지를 분양받고자 합니다.

사진 생략 (궁금하면 사진 드릴게요.)

이미 분양된 토지와 겹치지 않으며 식수원을 포함하고 있으므로 분양 가능합니다.
이미 분양된 토지별 위치를 담은 이차원 배열 lands와 식수원별 위치를 담은 이차원 배열 wells, 분양받고자 하는 토지의 위치를 담은 배열 point가 매개변수로 주어질 때, 토지분양이 가능한지 판별하여 return 하도록 solution 메서드를 완성해주세요.

* 제한사항
lands와 wells의 길이는 1 이상 10,000 이하입니다.
lands와 wells의 원소(토지와 식수원의 위치)는 [x1, y1, x2, y2]로 들어있습니다.
point의 길이는 4입니다.
point에는 점이 [x1, y1, x2, y2]로 들어있습니다.
x 좌표와 y 좌표는 0 이상 1,000,000 이하인 정수입니다.

* 입출력 예
int[][] lands = { {10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40} };
int[][] wells = { {15, 15, 25, 25}, {40, 10, 50, 20}};
int[] point ={10, 10, 30, 30};

* 입출력 예)1
lands : [ [10, 0, 30, 5], [0, 30, 20, 50], [30, 30, 40, 40] ]
wells : [ [15, 15, 25, 25], [40, 10, 50, 20] ]
point : [10, 10, 30, 30]
result : true

* 입출력 예)2
lands : [ [0, 0, 20, 10], [10, 20, 20, 40], [30, 0, 50, 20] ]
wells : [ [20, 40, 30, 50], [30, 20, 50, 30] ]
point : [20, 30, 30, 40]
result : false

* 입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.
입출력 예 #2
이미 분양된 토지와 겹치지 않지만 식수원 일부를 포함하고 있지 않아 분양받을 수 없습니다.

 */
public class Q2_1th {

    static final int X1 = 0, Y1 = 1, X2 = 2, Y2 = 3;

    static int left(int[] r) { return Math.min(r[X1], r[X2]); }   // 사각형 r의 왼쪽 경계 좌표
    static int right(int[] r) { return Math.max(r[X1], r[X2]); }  // 사각형 r의 오른쪽 경계 좌표
    static int top(int[] r) { return Math.min(r[Y1], r[Y2]); }    // 사각형 r의 윗쪽 경계 좌표
    static int bottom(int[] r) { return Math.max(r[Y1], r[Y2]); } // 사각형 r의 아래쪽 경계 좌표

    // 두 사각형 r1, r2가 겹치는가? 단지 경계선만이 닿는 것은 겹치는 것이 아닌 것으로 구현함.
    public static boolean overlap(int[] r1, int[] r2) {
        if (right(r1) <= left(r2) || right(r2) <= left(r1)) return false;
        if (bottom(r1) <= top(r2) || bottom(r2) <= top(r1)) return false;
        return true;
    }

    // 사각형 목록 rects의 사각형 중에서, 사각형 r과 겹치는 것이 있는가?
    public static boolean overlap(int[][] rects, int[] r) {
        for (int[] rect : rects)
            if (overlap(rect, r)) return true;
        return false;
    }

    public static boolean solution(int[][] lands, int[][] wells, int[] point) {
        return overlap(lands, point) == false && overlap(wells, point) == true;
    }

    public static void main(String[] args) {
        int[][] lands1 = { {10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40} };
        int[][] wells1 = { {15, 15, 25, 25}, {40, 10, 50, 20} };
        int[] point1 = {10, 10, 30, 30};
        System.out.println(solution(lands1, wells1, point1));

        int[][] lands2 = { {0, 0, 20, 10}, {10, 20, 20, 40}, {30, 0, 50, 20} };
        int[][] wells2 = { {20, 40, 30, 50}, {30, 20, 50, 30} };
        int[] point2 = {20, 30, 30, 40};
        System.out.println(solution(lands2, wells2, point2));
    }
}
