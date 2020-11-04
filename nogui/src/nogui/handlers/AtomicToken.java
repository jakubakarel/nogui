package nogui.handlers;

public class AtomicToken extends CodeToken {
	public AtomicToken(String sourceCode) {
		super(sourceCode);
	}

	@Override
	public String toString() {
		return getCodeExpression();
	}
}
