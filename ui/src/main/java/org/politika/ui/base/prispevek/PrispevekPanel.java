package org.politika.ui.base.prispevek;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.politika.Politika.model.Prispevek;

public class PrispevekPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String HEADER_ID = "header";
	private final String TEXT_ID = "text";
	private final String SOURCE_ID = "source";
	private final String DATE_ID = "date";
	
	private Prispevek prispevek;
	
	public PrispevekPanel(String id, Prispevek prispevek) {
		super(id);
		this.prispevek = prispevek;
		
		add(new Label(HEADER_ID,prispevek.getNadpis()));
		add(new Label(TEXT_ID,prispevek.getText()));
		add(new Label(SOURCE_ID,prispevek.getZdroje()));
		add(new Label(DATE_ID,prispevek.getDatum()));
			
	}


}
