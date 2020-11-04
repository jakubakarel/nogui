package codeMatching;

import codeTokens.CodeToken;

public class SimpleDataMatcher extends TokenMatcher {

	public SimpleDataMatcher() {
		super("\\data \\S+ type \\S+");
	}

	@Override
	public CodeToken createToken(String codeSnippet) {
		// TODO Auto-generated method stub
		return null;
	}

}
