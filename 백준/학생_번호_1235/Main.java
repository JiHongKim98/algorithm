package 학생_번호_1235;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int studentCount = Integer.parseInt(br.readLine());
		int answer = 0;

		String[] arr = new String[studentCount];
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < studentCount; ++i) {
			arr[i] = br.readLine();
		}

		for (int i = 1; i <= arr[0].length(); i++) {
			for (int j = 0; j < studentCount; j++) {
				set.add(arr[j].substring(arr[j].length() - i));
			}

			if (set.size() == studentCount) {
				answer = i;
				break;
			}

			set.clear();
		}
		System.out.println(answer);
	}
}
