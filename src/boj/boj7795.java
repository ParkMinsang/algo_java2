package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nnum = new int[n];
            int[] mnum = new int[m];

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<n; i++) nnum[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<m; i++) mnum[i] = Integer.parseInt(st.nextToken());

            qs(mnum, 0, m-1);

            int ans=0;
            for(int i=0; i<n; i++){
                int lt=0, rt=m-1, mt=0, cnt=0;
                while(lt<=rt){
                    mt=(lt+rt)/2;

                    if(nnum[i]>mnum[mt]){
                        cnt=mt+1;
                        lt=mt+1;
                    }else{
                        rt=mt-1;
                    }
                }
                ans+=cnt;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void qs(int[] arr, int l, int r){
        if(l>=r) return;
        int pivot = arr[r];
        int s=l, b=l;

        while(s<r){
            while(s<r && arr[s]>pivot) s++;
            if(s==r) break;
            swap(arr, s++, b++);
        }
        swap(arr, b, r);
        qs(arr, l, b-1);
        qs(arr, b+1, r);
    }

    static void swap(int[] arr, int i1, int i2){
        int tmp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=tmp;
    }
}
