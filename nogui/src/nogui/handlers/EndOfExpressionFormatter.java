package nogui.handlers;

public class EndOfExpressionFormatter {
	private static final char SIMPLE_QUOTE = '\'';
	private static final char STRING_QUOTE = '`';
	private static final char PERIOD = '.';
	private static final char SPACE = ' ';

	private char[] input;
	private Boolean isProcessingQuotedText;
	private StringBuilder outputBuilder;
	private char currentlyProcessedCharacter;
	private int currentInputIndex;

	public EndOfExpressionFormatter() {
		isProcessingQuotedText = false;
		outputBuilder = new StringBuilder();
	}

	public String Apply(String originalSourceCode) {
		input = originalSourceCode.toCharArray();

		for (currentInputIndex = 0; currentInputIndex < input.length; ++currentInputIndex) {
			processOneCharacter();
		}

		return outputBuilder.toString();
	}

	private void processOneCharacter() {
		currentlyProcessedCharacter = input[currentInputIndex];

		switch (currentlyProcessedCharacter) {
		case SIMPLE_QUOTE:
		case STRING_QUOTE:
			handleQuotes();
			break;
		case SPACE:
			handleSpace();
			break;
		default:
			handleOrdinaryChar();
		}
	}

	private void handleQuotes() {
		isProcessingQuotedText = !isProcessingQuotedText;
		outputBuilder.append(currentlyProcessedCharacter);
	}
	
	private void handleSpace() {
		if (isSpaceFollowedByPeriod()) {
			handleSpaceFollowedByPeriod();
		} else {
			handleOrdinaryChar();
		}
	}
	
	private void handleOrdinaryChar() {
		outputBuilder.append(currentlyProcessedCharacter);
	}
	
	private Boolean isSpaceFollowedByPeriod() {
		return !isProcessingQuotedText && input[currentInputIndex + 1] == PERIOD;
	}
	
	private void handleSpaceFollowedByPeriod() {
		outputBuilder.append(PERIOD);
		++currentInputIndex;		
	}
}
