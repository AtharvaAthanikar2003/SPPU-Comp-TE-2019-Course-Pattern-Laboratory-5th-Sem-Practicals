import java.util.Random;

public class GoBackN {
    public static void gobackN(int nf, int fpers) {
        int n = 0;
        int cf = 0;
        while (n < nf) {
            for (int i = cf + 1; i < cf + fpers; i++) {
                Random rand = new Random();
                int r = rand.nextInt(2);
                if (i > nf) {
                    break;
                } else {
                    if (r == 1) {
                        System.out.println("Transmitting Frame No." + i + "....");
                        System.out.println("Acknowledgement :- Success\n");
                        n++;
                        cf = i;
                    } else {
                        System.out.println("Error While Transfering Frame No." + i + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println("Transmission Successful");
    }
  
  public static void main(String[] args) {
        int frame_no, fs;
        System.out.println("---------SIMULATION FOR 'GO-BACK-N' ARQ PROTOCOL---------\n");
        System.out.print("Enter The No.of Frames :- ");
        frame_no = Integer.parseInt(System.console().readLine());
        System.out.print("Enter The Windows Length :- ");
        fs = Integer.parseInt(System.console().readLine());
        System.out.println();
        gobackN(frame_no, fs);
    }
}
