package nogui.handlers;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class EditorWindowReader {
	private String editorWindowContent;
	
	public void readActiveEditorWindow() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (activeEditor instanceof TextEditor) {
			TextEditor textEditor = (TextEditor) editor;
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			IEditorInput input = textEditor.getEditorInput();
			IDocument document = documentProvider.getDocument(input);

			String text = document.get();
			System.out.print(text);

		}
	}
	

}
