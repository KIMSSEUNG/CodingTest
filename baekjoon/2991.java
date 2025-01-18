import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean aAttack = true;
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean bAttack = true;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int pCount=0,mCount=0,nCount=0;
        int aCount=a,cCount=c;

        for(int i=1;i<=999;i++){
            if(p==i){
                if(aAttack && bAttack){
                    pCount=2;
                }
                else if(aAttack || bAttack){
                    pCount=1;
                }
                else{
                    pCount=0;
                }
            }
            if(m==i){
                if(aAttack && bAttack){
                    mCount=2;
                }
                else if(aAttack || bAttack){
                    mCount=1;
                }
                else{
                    mCount=0;
                }
            }
            if(n==i){
                if(aAttack && bAttack){
                    nCount=2;
                }
                else if(aAttack || bAttack){
                    nCount=1;
                }
                else{
                    nCount=0;
                }
            }


            if(aAttack){
                if(i==aCount){
                    aAttack = false;
                    aCount+=b;
                }
            }
            else{
                if(i==aCount){
                    aAttack = true;
                    aCount+=a;
                }
            }

            if(bAttack){
                if(i==cCount){
                    bAttack = false;
                    cCount+=d;
                }
            }
            else{
                if(i==cCount){
                    bAttack = true;
                    cCount+=c;
                }
            }
        }

        System.out.println(pCount);
        System.out.println(mCount);
        System.out.println(nCount);
    }
}