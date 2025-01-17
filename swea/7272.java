import java.util.*;

import java.io.*;

import java.lang.Math;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int num = 1;
    static HashMap<Character,Character> m = new HashMap<>();
    static HashMap<Character,Character> m_o = new HashMap<>();

    static void set_zero(){
        m.put('C','0'); m.put('V','0');
        m.put('E','0'); m.put('W','0');
        m.put('F','0'); m.put('X','0');
        m.put('G','0'); m.put('Y','0');
        m.put('H','0'); m.put('Z','0');
        m.put('I','0');
        m.put('J','0');
        m.put('K','0');
        m.put('L','0');
        m.put('M','0');
        m.put('N','0');
        m.put('S','0');
        m.put('T','0');
        m.put('U','0');
    }
    //ADOPQR = 1
    static void set_one(){
        m_o.put('A','1');
        m_o.put('D','1');
        m_o.put('O','1');
        m_o.put('P','1');
        m_o.put('Q','1');
        m_o.put('R','1');
    }

    static void logic()throws IOException{

        String[] split = br.readLine().split(" ");
        char[] f = split[0].toCharArray();
        char[] s = split[1].toCharArray();
        String a="",b="";
        for(int i=0;i<f.length;i++){
            if(m.containsKey(f[i])) {
                a+='0';
            }
            else if(m_o.containsKey(f[i])){
                a+='1';
            }
            else{
                a+='2';
            }
        }

        for(int i=0;i<s.length;i++){
            if(m.containsKey(s[i])) {
                b+='0';
            }
            else if(m_o.containsKey(s[i])){
                b+='1';
            }
            else{
                b+='2';
            }
        }

        if(a.equals(b)){
            System.out.println("#"+(num++)+" SAME");
        }
        else{
            System.out.println("#"+(num++)+" DIFF");
        }


    }

    public static void main(String[] args)throws IOException
    {
        int testCase = Integer.parseInt(br.readLine());
        set_zero();
        set_one();
        for(int i=0;i<testCase;i++) {
            logic();
        }

    }
}