package nogui.handlers;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class SourceCodeEditor {
	private IDocument currentWindowDocument;

	public SourceCodeEditor() {
		initialize();
	}
	
	public String getEditorContent() {
		String currentSourceCode = "";
		
		if (currentWindowDocument != null) {
			currentSourceCode = currentWindowDocument.get();
		}
		
		return currentSourceCode;
	}
	
	public void setEditorContent(String newEditorContent) {
		if (currentWindowDocument != null) {
			currentWindowDocument.set(newEditorContent);
		}
	}

	private void initialize() {
		IEditorPart activeEditor = getEditorPart();

		if (activeEditor instanceof TextEditor) {
			tryFillCurrentDocument((TextEditor) activeEditor);
		}
	}

	private IEditorPart getEditorPart() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	private void tryFillCurrentDocument(TextEditor textEditor) {
		if (textEditor != null) {
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			IEditorInput input = textEditor.getEditorInput();
			currentWindowDocument = documentProvider.getDocument(input);
		}
	}
}
