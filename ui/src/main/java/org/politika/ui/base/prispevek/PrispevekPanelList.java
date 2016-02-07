package org.politika.ui.base.prispevek;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.politika.Politika.model.Prispevek;

public class PrispevekPanelList extends Panel {

	private static final long serialVersionUID = 1L;

	public PrispevekPanelList(String id, List<Prispevek> prispevky) {
		super(id);
		
		add(new ListView("prispevky", prispevky) {

			@Override
			protected void populateItem(ListItem arg0) {
				final Prispevek p = (Prispevek)arg0.getModelObject();
				arg0.add(new PrispevekPanel("prispevek", p));
			}
			
		});
	}
}
