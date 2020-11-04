package codeMatching;

import java.util.List;

import codeTokens.CodeToken;

public class CompositeTokenMatcher extends TokenMatcher {
	private List<TokenMatcher> containedMatchers;
	
	public CompositeTokenMatcher(String patternString) {
		super(patternString);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean isMatching(String codeSnippet) {
		for (TokenMatcher tokenMatcher : containedMatchers) {
			if (!tokenMatcher.isMatching(codeSnippet)) {
				return false;
			}
		}
		
		return true;
	}


	@Override
	public CodeToken createToken(String codeSnippet) {
		// TODO Auto-generated method stub
		return null;
	}

}
