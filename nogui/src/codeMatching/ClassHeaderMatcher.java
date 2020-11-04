package codeMatching;

import codeTokens.CodeToken;

public class ClassHeaderMatcher extends TokenMatcher {
	
	public ClassHeaderMatcher() {
		super("class \\S+ definition");
	}

	@Override
	public CodeToken createToken(String codeSnippet) {
		// TODO Auto-generated method stub
		return null;
	}

}
