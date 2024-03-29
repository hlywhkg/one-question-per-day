/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/6 10:17
 * @Version 1.0
 */

import java.util.*;

class Solution3 {
    public int minAddToMakeValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        int count = 0;
        int need = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                need++;
                count = 0;
            }
        }
        need += count;
        return need;
    }
}

class Solution2 {
    List<String> ans = new ArrayList<String>();

    public List<String> letterCasePermutation(String s) {
        StringBuilder path = new StringBuilder(s);
        dfs(s, 0, path);
        return ans;
    }

    public void dfs(String s, int pos, StringBuilder path) {
        if (pos == s.length()) {
            ans.add(path.toString());
            return;
        }

        if (Character.isDigit(s.charAt(pos))) {
            path.setCharAt(pos, s.charAt(pos));
            dfs(s, pos + 1, path);
        } else if (Character.isLowerCase(s.charAt(pos))) {
            path.setCharAt(pos, s.charAt(pos));
            dfs(s, pos + 1, path);
            path.setCharAt(pos, Character.toUpperCase(s.charAt(pos)));
            dfs(s, pos + 1, path);
        } else {
            path.setCharAt(pos, s.charAt(pos));
            dfs(s, pos + 1, path);
            path.setCharAt(pos, Character.toLowerCase(s.charAt(pos)));
            dfs(s, pos + 1, path);
        }
    }
}

/**
 * id+1在Logs表中且id+2也在Logs表中
 * select distinct Num as ConsecutiveNums from Logs where (Id+1,Num) in (select * from Logs)
 * and (Id+2,Num) in (select * from Logs);
 */

class Solution1 {
    public String frequencySort(String s) {
        char[] cnt = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        //存储每个字母的次数
        for(char c : cnt){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //字母频率不同逆序排序,相同则按照字典升序排序
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
        });
        for (char c : map.keySet()) {
            p.add(new int[]{c,map.get(c)});
        }
        StringBuilder sb = new StringBuilder();
        while(!p.isEmpty()){
            int[] tmp = p.poll();
            int x = tmp[0],y = tmp[1];
            while(y-->0){
                sb.append((char)x);
            }
        }
        return sb.toString();
    }
}

/**
 * in 的 操作
 * select b.name as Department,a.name as Employee,a.salary as Salary from Employee a ,
 * Department b where a.departmentId = b.id and (a.salary,b.departmentId) in (select max(Salary),
 * departmentId from Employee group by departmentId);
 */

public class demo1 {
    public static void main(String[] args) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
        });
        char a = 'c';
        int[] arr = new int[]{a};//
        System.out.println(Arrays.toString(arr));
        //冷知识:异或32大小写转换
        char c = 'a';
        System.out.println(c^32);
    }
}
