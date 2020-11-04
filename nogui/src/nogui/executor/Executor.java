package nogui.executor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codeMatching.ClassHeaderMatcher;
import codeMatching.PublicSectionMatcher;
import codeMatching.SimpleClassDataMatcher;
import codeMatching.SimpleDataMatcher;
import codeMatching.TokenMatcher;
import nogui.handlers.EndOfExpressionFormatter;
import version2.AbapCodeParser;

public class Executor {
	public static void main(String[] args) {

		String completeSourceCode = "";
		try {
//			completeSourceCode = new String(Files
//					.readAllBytes(Paths.get("C:\\Users\\s1627\\Desktop\\abap_source_files\\cl_job_order_bo.abap")));
			
			completeSourceCode = new String(Files
					.readAllBytes(Paths.get("C:\\Users\\s1627\\Desktop\\abap_source_files\\types.abap")));

			AbapCodeParser parser = new AbapCodeParser(completeSourceCode);

			List<TokenMatcher> tokenMatchers = new ArrayList<>();
			
			tokenMatchers.add(new ClassHeaderMatcher());
			tokenMatchers.add(new PublicSectionMatcher());
			tokenMatchers.add(new SimpleDataMatcher());
			tokenMatchers.add(new SimpleClassDataMatcher());
			
			for (String statement : parser.GetParsedStatements()) {
				int numberOfHits = 0;
				
				for (TokenMatcher tokenMatcher : tokenMatchers) {
					if (tokenMatcher.isMatching(statement)) {
						numberOfHits++;
					}
				}
				
				System.out.println(numberOfHits);
			}			

			// String[] parts = completeSourceCode.split("(?i)endclass.");

			// String[] parts2 = parts[0].split("(?i)class.*definition.*\\.");
			// Pattern pattern = Pattern.compile("class (.*?) definition");
			// Pattern pattern = Pattern.compile("private section\\.(.*)ENDCLASS\\.",
			// Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
//			Pattern pattern = Pattern.compile("class.*definition.*\\.(.*?)", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
//			Matcher matcher = pattern.matcher(]);
//			
//			while (matcher.find()) {
//				System.out.println("Found...\n");
//				String groupContent = matcher.group(1);
//				System.out.println(groupContent);
//			}
//			

			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
