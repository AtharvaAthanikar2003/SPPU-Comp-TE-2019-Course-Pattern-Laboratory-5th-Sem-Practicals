import java.util.*;
import java.io.*;
public class AssemblerPass2 {
public static void main(String args[]) {
        BufferedReader br, br1, br2;
        String input = null;
        String t = null;
        String t1 = null;
        String ss = null;
        String address;
        try {
                br = new BufferedReader(new FileReader("IM.txt"));
                File f = new File("Output.txt");
                PrintWriter p = new PrintWriter(f);

                while ((input = br.readLine()) != null) {

                        StringTokenizer st = new StringTokenizer(input, " ");
                        while (st.hasMoreTokens()) {
                                t = st.nextToken();
                                // System.out.println(t);
                if (t.equals("AD") || t.equals("IS") || t.equals("DL")) 
                {
                        p.print(t + " ");
                } 
                else if (t.matches("\\d*") && t.length() > 0 && st.hasMoreTokens()) {
                        p.print(t + " ");
                }

                else if (t.matches("\\d*") && t.length() > 0 && !(st.hasMoreTokens())) {
                        p.println(t);
                } else {
                        br1 = new BufferedReader(new FileReader("ST.txt"));
                        br2 = new BufferedReader(new FileReader("LT.txt"));
                        if (t.charAt(0) == 'S') {
                                char a;
                                int aa;
                                a = t.charAt(1);
                                aa = Character.getNumericValue(a);
                                while ((t1 = br1.readLine()) != null) {
                                        StringTokenizer st1 = new StringTokenizer(t1, "\t");
                                        ss = st1.nextToken();
                                        int index = Integer.parseInt(ss);
                                        if (index == aa) {
                                                address = st1.nextToken();
                                                p.println(address);
                                        }
                                }
                        } else if (t.charAt(0) == 'L') {
                                char a;
                                int aa;
                                a = t.charAt(1);
                                aa = Character.getNumericValue(a);
                                while ((t1 = br2.readLine()) != null) {
                                        StringTokenizer st2 = new StringTokenizer(t1, "\t");
                                        ss = st2.nextToken();
                                        int index = Integer.parseInt(ss);
                                        if (index == aa) {
                                                address = st2.nextToken();
                                                p.println(address);
                                        }

                                                        }
                                                } else {
                                                        p.print(t + " ");
                                                }
                                        }

                                }
                        }
                        p.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}