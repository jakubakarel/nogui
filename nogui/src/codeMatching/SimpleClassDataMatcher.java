package codeMatching;

import codeTokens.CodeToken;

public class SimpleClassDataMatcher extends TokenMatcher {
	public SimpleClassDataMatcher() {
		super("\\class-data \\S+ type \\S+");
	}

	@Override
	public CodeToken createToken(String codeSnippet) {
		// TODO Auto-generated method stub
		return null;
	}

}
