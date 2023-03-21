package revising_java;

import java.util.ArrayList;

public class FirstSelenium {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("name1");
		list.add("name2");
		list.add("name3");
		// System.out.println(list.contains("name2"));

		boolean find = true;
		 System.out.println(list.size());
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i).contains("name2")) {
				System.out.println("Set as false");
				find = false;
			}
		}

	}
}
