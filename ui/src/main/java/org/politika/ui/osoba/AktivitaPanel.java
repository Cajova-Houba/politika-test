package org.politika.ui.osoba;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.politika.Politika.model.Prispevek;
import org.politika.ui.base.prispevek.PrispevekPanelList;

public class AktivitaPanel extends PrispevekPanelList {

	private final String PANEL_HEADER_ID = "panelHeader";
	
	public AktivitaPanel(String id, String header, List<Prispevek> prispevky) {
		super(id, prispevky);
		// TODO Auto-generated constructor stub
		
		add(new Label(PANEL_HEADER_ID,header));
	}

}
