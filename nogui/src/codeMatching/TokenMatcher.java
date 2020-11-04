package codeMatching;

import codeTokens.CodeToken;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TokenMatcher {
	protected Pattern matchingPattern;
	
	public Boolean isMatching(String codeSnippet) {
		Boolean result = Boolean.FALSE;
		
		if (matchingPattern != null) {
			Matcher patternMatcher = matchingPattern.matcher(codeSnippet);			
			result = patternMatcher.find();		
		}
		
		return result;		
	}
	
	public abstract CodeToken createToken(String codeSnippet);
	
	public TokenMatcher(String patternString) {
		matchingPattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	}
}
