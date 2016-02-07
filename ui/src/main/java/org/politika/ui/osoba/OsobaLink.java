package org.politika.ui.osoba;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.politika.Politika.model.Osoba;
import org.politika.ui.schema.TerminalPage;


public class OsobaLink extends Panel {

	private static final long serialVersionUID = 1L;
	
	private final String LINK_ID = "link";
	private final String NAME_ID = "name";
	private final String FUNC_ID = "function";
	
	public OsobaLink(String id, final Osoba osoba, final long backId) {
		super(id);
		
		Link l = new Link(LINK_ID) {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				PageParameters params = new PageParameters();
				params.set("osobaId", osoba.getId());
				params.set("aktivita", true);
				params.add("katId", backId);
				setResponsePage(TerminalPage.class,params);
			}
		};
		l.add(new Label(NAME_ID,osoba.getName()));
		l.add(new Label(FUNC_ID,osoba.getFunkce().funcName));
		
		add(l);
	}


}
