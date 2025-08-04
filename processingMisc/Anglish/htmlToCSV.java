package processingMisc.Anglish;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class htmlToCSV {
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new java.io.FileReader("processingMisc/Anglish/input.txt"));
			writer = new BufferedWriter(new java.io.FileWriter("processingMisc/Anglish/output.csv"));
			String line;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				if ((!line.equals("<tr>")) && (!line.equals("</tr>")) && !line.isEmpty()) {
					++count;
					writer.write(line.replace("<td>", "").replace("</td>", "") + (count % 3 != 0 ? "," : ""));
				} else if (line.equals("</tr>"))
					writer.newLine();
				else {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
