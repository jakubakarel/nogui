package nogui.handlers;

public class CodeToken {
	private String codeExpression;
	
	public CodeToken(String codeExpression) {
		this.setCodeExpression(codeExpression);
	}

	protected String getCodeExpression() {
		return codeExpression;
	}

	protected void setCodeExpression(String codeExpression) {
		this.codeExpression = codeExpression;
	}
}
