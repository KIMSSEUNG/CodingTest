import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<String> q = new LinkedList<>();

    public static void main(String[] args)throws IOException {
        String[] temp = br.readLine().split(">");
        List<String> t = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            if(temp[i]==" ")
                continue;
            if(temp[i].toCharArray()[0]=='<'){
                t.add(temp[i]+">");
                continue;
            }
            char[] te =temp[i].toCharArray();
            boolean isCheck =false;
            for(int j=0;j<te.length;j++){
                if(te[j]=='<'){
                    isCheck=true;
                    t.add(temp[i].substring(0,j));
                    t.add(temp[i].substring(j,te.length)+">");
                    break;
                }
            }

            if(!isCheck){
                t.add(temp[i]);
            }
        }

        for(var i=0;i<t.size();i++){
            if(t.get(i).toCharArray()[0]=='<'){
                System.out.print(t.get(i));
            }
            else{
                String[] split = t.get(i).split(" ");
                for(int j=0;j<split.length;j++){
                    StringBuffer s = new StringBuffer(split[j]);
                    String temp2 = s.reverse().toString();
                    if(j==0){
                        System.out.print(temp2);
                    }
                    else{
                        System.out.print(" "+temp2);
                    }
                }

            }
        }


    }
}