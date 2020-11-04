package nogui.handlers;

import java.util.ArrayList;
import java.util.List;

public class GroupToken extends CodeToken {
	private List<CodeToken> content;

	public GroupToken(String tokenName) {
		super(tokenName);
		content = new ArrayList<>();
	}

	public void AddToken(CodeToken token) {
		content.add(token);
	}

	@Override
	public String toString() {
		
		return "empty";
	}	
}
