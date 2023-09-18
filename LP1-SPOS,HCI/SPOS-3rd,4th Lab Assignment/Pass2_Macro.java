import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pass2_Macro {
	public static void main(String[] args) {

		try {
			try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\karti\\Desktop\\mnt.txt"))) {
				try (BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\karti\\Desktop\\Input.txt"))) {
					try (BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\karti\\Desktop\\mdt.txt"))) {
						File ot = new File("C:\\Users\\karti\\Desktop\\Output.txt");

						PrintWriter p = new PrintWriter(ot);
						String[] mn = new String[10];
						int n = 0;
						String data = "";

						while ((data = br.readLine()) != null) {
							StringTokenizer st = new StringTokenizer(data, "\t");
							data = st.nextToken();
							mn[n] = data;
							n++;
						}

						int line = 0;
						int sline = 0;
						while ((data = br1.readLine()) != null) {
							StringTokenizer mds = new StringTokenizer(data, " ");
							line++;
							data = mds.nextToken();
							if (data.equals("START")) {
								sline = line - 1;
							} else {
								continue;
							}
						}
						System.out.println(line);
						String data1 = "";

						while ((data = Files.readAllLines(Paths.get("C:\\Users\\karti\\Desktop\\Input.txt"))
								.get(sline)) != null) {
							StringTokenizer tt = new StringTokenizer(data, " ");

							data1 = tt.nextToken();

							if (data1.equals(mn[0]) || data1.equals(mn[1])) {

								String temp = "";

								int t = 0;

								while ((temp = br2.readLine()) != null) {
									StringTokenizer bt = new StringTokenizer(temp, " ");
									temp = bt.nextToken();
									t++;
									if (temp.equals(data1)) {
										while (1 > 0) {
											temp = Files.readAllLines(Paths.get("C:\\Users\\karti\\Desktop\\mdt.txt")).get(t);
											if (temp.equals("MEND")) {
												break;
											}
											p.println(temp);
											t++;
										}
										break;
									}

								}

							}

							else {
								p.println(data);

							}
							sline++;
							if (sline == line) {
								break;
							}

						}
						p.close();
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
