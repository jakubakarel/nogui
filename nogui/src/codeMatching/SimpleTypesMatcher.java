package codeMatching;

import codeTokens.CodeToken;

public class SimpleTypesMatcher extends TokenMatcher {

	public SimpleTypesMatcher() {
		super("types \\S+ type \\S+");
	}

	@Override
	public CodeToken createToken(String codeSnippet) {
		// TODO Auto-generated method stub
		return null;
	}

}
