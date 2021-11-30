package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	private String getMonth(String line) {

		String openBracket = "[";
		String closeBracket = "]";
		String hittedResRegex = Pattern.quote(openBracket) + "(.*?)"
				+ Pattern.quote(closeBracket);
		Pattern pattern = Pattern.compile(hittedResRegex);
		Matcher matcher = pattern.matcher(line);

		String month = "-1";
		try {
			matcher.find();
			String resTxtInBetween = matcher.group(1);
			String[] splittedArray = resTxtInBetween.split("/");

			if (splittedArray.length > 2) {
				month = splittedArray[1].trim();
			}
		} catch (Exception ex) {

		}

		return month;

	}

	private String getIpAddress(String line) {
		String ipAddress = "-1";
		try {
			String[] splittedArray = line.split(" ");

			if (splittedArray.length > 1) {
				ipAddress = splittedArray[0].trim();
			}
		} catch (Exception ex) {

		}
		return ipAddress;
	}

	public static void main(String args[]) {
		String testString = "10.223.157.186 - - [1/Jul/2009:15:50:35 -0700] \"GET /assets/js/lightbox.gif"
				+ " HTTP/1.1\" 200 25960";
		test t = new test();

		System.out.print(t.getIpAddress(testString));
		System.out.print(t.getMonth(testString));

	}

}
