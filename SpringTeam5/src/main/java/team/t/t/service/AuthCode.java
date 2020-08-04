package team.t.t.service;

import java.util.Random;

public class AuthCode {

	public String authCode() {

		StringBuffer temp = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int ranIndex = random.nextInt(3);
			switch (ranIndex) {
			case 0:
				// a-z
				// temp.append( (char) random.nextInt(26)+97 );
				temp.append((char) (random.nextInt(26) + 97));
			
				break;
			case 1:
				// A-Z
				// emp.append((char) random.nextInt(26)+65);
				temp.append((char) (random.nextInt(26) + 65));
				
				break;
			case 2:
				// 0-9
				temp.append((random.nextInt(10)));
				
				break;
			}
		}
		String str = temp.toString();
		return str;
	}
}
