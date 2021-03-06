package Algorithm.Section07;

// 부분집합(DFS)
public class Algorithm06 {
    static int n;
    static int[] result;

    static void dfs(int k) {
        if (k == n + 1) {
            String str = "";
            for (int i = 1; i <= n; i++) {
                if (result[i] == 1) str += i + " ";
            }
            if (str.length() > 0) System.out.println(str);
        } else {
            int L = 1;
            result[k] = L;
            dfs(k + 1);

            L = 0;
            result[k] = L;
            dfs(k + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        result = new int[n + 1];
        dfs(1);
    }
}
