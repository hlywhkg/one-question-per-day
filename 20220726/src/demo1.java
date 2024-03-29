import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/26 9:53
 * @Version 1.0
 */

class Main {
    public static void reserve(int a){

    }
    public static void main(String[] args) {
        int[] ret = new int[10001];
        ret[1] = 1;
        ret[2] = 2;
        for(int i = 3 ; i < 10001 ; i++) {
            ret[i] = ret[i-1] + ret[i-2];
            ret[i] = ret[i] % 10000;
        }
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            for(int i = 0 ; i < a ; i++) {
                int x = in.nextInt();
                if(ret[x] < 1000){
                    String y = String.valueOf(ret[x]);
                    StringBuilder sb = new StringBuilder(y);
                    while(sb.length() < 4){
                        StringBuilder zero = new StringBuilder("0");
                        sb = zero.append(sb);
                    }
                    System.out.print(sb);
                }else{
                    System.out.print(ret[x]);
                }
            }
            System.out.println();
        }
    }
}

class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            int b = 0;
            for(int i = 0 ; i < a.length() ; i++) {
                b += a.charAt(i) - '0';
            }
            int c = 0;
            while(b >= 10){
                while(b >= 10){
                    c += b % 10;
                    b /= 10;
                }
                b += c;
                c = 0;
            }
            System.out.println(b);
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        //System.out.println((long)Math.pow(18,6));
        //System.out.println(0123);
        StringBuilder sb = new StringBuilder("10");
        while(sb.length() < 4){
            StringBuilder zero = new StringBuilder("0");
            sb = zero.append(sb);
            System.out.println(sb);
        }
    }
}

/**
 * 实际版
 */

class Main2 {
    static Deque<Deque<int[]>> deques = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int row = in.nextInt();
            int col = in.nextInt();
            Deque<int[]> d = new ArrayDeque<>();
            int[][] ret = new int[row][col];
            boolean[][] flg = new boolean[row][col];
            for(int i = 0 ; i < row ; i++) {
                for(int j = 0; j < col ; j++) {
                    ret[i][j] = in.nextInt();
                }
            }
            d.addLast(new int[]{0,0});
            flg[0][0] = true;
            int min = Integer.MAX_VALUE;
            bfs(ret,d,flg,min);
            while(!deques.isEmpty()){
                Deque<int[]> d1 = deques.pollFirst();
                while(!d1.isEmpty()){
                    int[] tmp = d1.pollFirst();
                    int x = tmp[0],y = tmp[1];
                    System.out.println("(" + x +"," + y + ")");
                }
            }
        }
    }
    static int[][] dict = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void bfs(int[][] ret, Deque<int[]> d, boolean[][] flg,int min){
        int[] ans = d.peekLast();
        int x = ans[0], y = ans[1];
        int m = ret.length, n = ret[0].length;
        for (int[] cnt : dict) {
            int nx = x + cnt[0], ny = y + cnt[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || ret[nx][ny] == 1 || flg[nx][ny]) continue;
            d.addLast(new int[]{nx, ny});
            if(nx == m - 1 && ny == n - 1 && d.size() < min){
                deques.clear();
                deques.addLast(new ArrayDeque<>(d));
            }
            flg[nx][ny] = true;
            bfs(ret, d, flg,min);
            d.pollLast();
            flg[nx][ny] = false;
        }
    }
}

/**
 * 测试版
 */
class Main1 {
    static Deque<Deque<int[]>> deques = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int row = in.nextInt();
            int col = in.nextInt();
            Deque<int[]> d = new ArrayDeque<>();
            int[][] ret = new int[row][col];
            boolean[][] flg = new boolean[row][col];
            for(int i = 0 ; i < row ; i++) {
                for(int j = 0; j < col ; j++) {
                    ret[i][j] = in.nextInt();
                }
            }
            d.addLast(new int[]{0,0});
            flg[0][0] = true;
            int min = Integer.MAX_VALUE;
            bfs(ret,d,flg,min);
            while(!deques.isEmpty()){
                Deque<int[]> d1 = deques.pollFirst();
                while(!d1.isEmpty()){
                    System.out.println(d1.size());
                    int[] tmp = d1.pollFirst();
                    int x = tmp[0],y = tmp[1];
                    System.out.println("(" + x +"," + y + ")");
                }
            }
        }
    }
    static int[][] dict = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void bfs(int[][] ret, Deque<int[]> d, boolean[][] flg,int min){
        int[] ans = d.peekLast();
        int x = ans[0], y = ans[1];
        int m = ret.length, n = ret[0].length;
        for (int[] cnt : dict) {
            int nx = x + cnt[0], ny = y + cnt[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || ret[nx][ny] == 1 || flg[nx][ny]) continue;
            d.addLast(new int[]{nx, ny});
            System.out.println(d.size());
            if(nx == m - 1 && ny == n - 1 && d.size() < min){
                deques.clear();
                deques.addLast(new ArrayDeque<>(d));
                System.out.println(deques.size());
            }
            System.out.println(nx + " " + ny);
            flg[nx][ny] = true;
            bfs(ret, d, flg,min);
            d.pollLast();
            flg[nx][ny] = false;
        }
    }
}
