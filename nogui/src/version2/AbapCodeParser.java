package version2;

import java.util.ArrayList;
import java.util.List;

public class AbapCodeParser {
	private String originalSourceCode;
	private List<String> parsedCodeStatements;
	
	public AbapCodeParser(String sourceCode) {
		originalSourceCode = sourceCode;
		parsedCodeStatements = new ArrayList<String>();
		parseToStatements();		
	}
	
	public List<String> GetParsedStatements() {
		return parsedCodeStatements;
	}
	
	private void parseToStatements() {
		boolean isInsideQuotes = false;
		StringBuilder stringBuilder = new StringBuilder();
		
		for (char singleChar : originalSourceCode.toCharArray()) {
			if (singleChar == '.' && isInsideQuotes == false) {
				parsedCodeStatements.add(stringBuilder.toString().strip());
				stringBuilder = new StringBuilder();
				continue;
			}
			
			if (singleChar == '\'') {
				isInsideQuotes = !isInsideQuotes;
			}
			
			stringBuilder.append(singleChar);		
		}		
	}
}
