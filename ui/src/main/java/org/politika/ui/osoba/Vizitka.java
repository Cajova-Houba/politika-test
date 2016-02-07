package org.politika.ui.osoba;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.politika.Politika.model.Osoba;

public class Vizitka extends Panel {
	private static final long serialVersionUID = 1L;

	private final String NAME_ID = "name";
	private final String DNR_ID = "dnr";
	private final String STRANA_ID = "strana";
	private final String FUNKCE_ID = "funkce";

	private Osoba osoba;
	
	public Vizitka(String id, Osoba osoba) {
		super(id);
		
		this.osoba = osoba;
		
		addComponents();
	}
	
	public void addComponents() {
		add(new Label(NAME_ID,osoba.getName()));
		add(new Label(DNR_ID,"datum"));
		add(new Label(STRANA_ID,"strana"));
		add(new Label(FUNKCE_ID,osoba.getFunkce().funcName));
	}


}
