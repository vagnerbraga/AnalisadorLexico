package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import principal.IdentificaToken;
import principal.Simbolo;
import principal.Token;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.TableColumn;

public class Analisador extends Shell {
	
	private Table table;
	private Text text;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Analisador shell = new Analisador(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Analisador(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new BorderLayout(0, 0));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(BorderLayout.CENTER);
		composite.setLayout(new BorderLayout(0, 0));
		
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(BorderLayout.NORTH);
		label.setText("   ");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setLayoutData(BorderLayout.WEST);
		label_1.setText("   ");
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setLayoutData(BorderLayout.EAST);
		label_2.setText("   ");
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setLayoutData(BorderLayout.SOUTH);
		label_3.setText("   ");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.CENTER);
		composite_1.setLayout(new FormLayout());
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				analisar(text.getText());
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 204);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Analisar");
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table = new FormData();
		fd_table.left = new FormAttachment(0, 10);
		fd_table.right = new FormAttachment(100, -10);
		fd_table.bottom = new FormAttachment(btnNewButton, 292, SWT.BOTTOM);
		fd_table.top = new FormAttachment(btnNewButton, 6);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(table, SWT.NONE);
		tblclmnCdigo.setWidth(100);
		tblclmnCdigo.setText("C\u00F3digo");
		
		TableColumn tblclmnToken = new TableColumn(table, SWT.NONE);
		tblclmnToken.setWidth(100);
		tblclmnToken.setText("Token");
		
		TableColumn tblclmnDescrio = new TableColumn(table, SWT.NONE);
		tblclmnDescrio.setWidth(100);
		tblclmnDescrio.setText("Descri\u00E7\u00E3o");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite_1, SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.bottom = new FormAttachment(btnNewButton, -6);
		fd_scrolledComposite.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_scrolledComposite.left = new FormAttachment(0, 10);
		fd_scrolledComposite.top = new FormAttachment(0, 10);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		text = new Text(scrolledComposite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		scrolledComposite.setContent(text);
		scrolledComposite.setMinSize(text.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		createContents();
	}

	private void analisar(String textoInput){
		
//		String condicao = "if a123 = 125 then (* teste de comentario *) (*outro comentario*) \n\tC := 30\nelse\n\tC := 40";
		String condicao = textoInput;

		List<String> comentarios = new ArrayList<String>();
		List<String> literais = new ArrayList<String>();
		List<Token> tokens = new ArrayList<Token>();
		
		while (condicao.contains("(*") && condicao.contains("*)")){
			int inicioComentario = condicao.indexOf("(*");
			int fimComentario = condicao.indexOf("*)")+2;
			String comentario = condicao.substring(inicioComentario, fimComentario);

			comentarios.add(comentario);
			condicao = condicao.replace(comentario, "");
		}
		
		while (condicao.contains("\" ") && condicao.contains(" \"")){
			int inicioLiteral = condicao.indexOf("\" ");
			int fimLiteral = condicao.indexOf(" \"")+2;
			String literal = condicao.substring(inicioLiteral, fimLiteral);

			literais.add(literal);
			condicao = condicao.replace(literal, "");
		}
		
		String texto = condicao.replace("\n", " ");
		texto = texto.replace("\t", " ");

		String[] textoQuebrado = texto.split(" ");
		
		IdentificaToken identifica = new IdentificaToken();
		
		for (String comentario : comentarios){
			Token token = new Token(comentario, identifica.identifica(comentario));
			tokens.add(token);
		}
		
		for (String lit : literais){
			Token token = new Token(lit, identifica.identifica(lit));
			tokens.add(token);
		}

		for (String txt : textoQuebrado){
			Token token = new Token(txt, identifica.identifica(txt));
			tokens.add(token);
		}

		preencheTabela(tokens);
	}
	
	private void preencheTabela(List<Token> tokens){
		this.table.setItemCount(0);
		this.table.clearAll();
		
		for (Token token : tokens) {
			TableItem it = new TableItem(this.table, SWT.NONE);
			it.setText(token.toArray());
		}
	}
	
	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Analisador L\u00E9xico");
		setSize(450, 600);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
