package programmers;

public class N으로표현 {
    static int n, num;
    static int ans;
    public static void main(String[] args) {
        System.out.println(solution(5, 26));
    }

    public static int solution(int N, int number){
        int answer=0;
        n = N;
        num = number;
        ans=10;
        func(0, 0);

        answer = ans>8?-1:ans;
        return answer;
    }

    static void func(int cnt, int val){
        if(cnt>8) return;
        if(val==num){
            ans = Math.min(ans, cnt);
            return;
        }

        func(cnt+1, val+n);
        func(cnt+1, val-n);
        func(cnt+1, val*n);
        func(cnt+1, val/n);
        func(cnt+1, val*10+n);

        int tmp=1;
        for(int i=2; i<9; i++){
            func(cnt+i, val+tmp);
            func(cnt+i, val-tmp);
            func(cnt+i, val*tmp);
            func(cnt+i, val/tmp);

            tmp=tmp*10+1;
        }
    }
}
