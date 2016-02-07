package org.politika.ui.osoba;

import java.util.ArrayList;

import org.apache.wicket.markup.html.panel.Panel;
import org.politika.Politika.model.Osoba;
import org.politika.Politika.model.Prispevek;

public class OsobaPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	private Osoba osoba;
	
	private boolean showAktivita = false;
	
	public OsobaPanel(String id, Osoba osoba, boolean showAktivita) {
		super(id);
		this.osoba = osoba;
		this.showAktivita = showAktivita;
		
		addVizitka("vizitka");
		addAktivita("aktivita");
	}

	private void addVizitka(String vizitkaId) {
		Vizitka v = new Vizitka(vizitkaId, osoba);
		add(v);
	}
	
	private void addAktivita(String aktivitaId) {
		AktivitaPanel ap;
		if (showAktivita) {
			ap = new AktivitaPanel(aktivitaId, "Aktivita:", osoba.getPrispevky()); 
		} else {
			ap = new AktivitaPanel(aktivitaId, "", new ArrayList<Prispevek>(0));
		}
		
		add(ap);
	}
}
