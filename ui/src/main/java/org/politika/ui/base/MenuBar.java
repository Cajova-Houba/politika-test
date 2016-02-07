package org.politika.ui.base;

import java.awt.Menu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.politika.Politika.model.Kategorie;
import org.politika.ui.schema.KategoriePage;

public class MenuBar extends Panel {


	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_SEPARATOR = "»";

	private final String MENU_ID = "menu";
	
	/**
	 * Separator for menu items
	 */
	private String separator;
	private boolean showSeparator;
	
	private Class homePage;
	
	private List<Kategorie> kategorie;
	private Map<Long, String> names;
	
	public MenuBar(String id, List<Kategorie> kategorie,boolean showSeparator) {
		this(id, null, kategorie, showSeparator);
	}
	
	public MenuBar(String id, List<Kategorie> kategorie, Map<Long,String> nazvy) {
		this(id, null, kategorie,nazvy);
	}
	
	public MenuBar(String id, Class homePage, List<Kategorie> kategorie) {
		this(id, homePage, kategorie, null);
	}
	
	public MenuBar(String id, Class homePage, List<Kategorie> kategorie, boolean showSeparator) {
		this(id, homePage, kategorie, null, showSeparator, DEFAULT_SEPARATOR);
	}
	
	/**
	 * Use this constructor if you want to use a custom name for every category. 
	 * @param id
	 * @param nazvy The category id is the key and value is displayed caption.
	 */
	public MenuBar(String id, Class homePage, List<Kategorie> kategorie, Map<Long,String> nazvy) {
		this(id, homePage, kategorie, nazvy, false, DEFAULT_SEPARATOR);
	}

	public MenuBar(String id, Class homePage, List<Kategorie> kategorie, Map<Long,String> nazvy, boolean showSeparator,  String separator) {
		super(id);
		
		this.homePage = homePage;
		this.kategorie = kategorie;
		this.showSeparator = showSeparator;
		this.separator = separator;
		
		if(nazvy == null) {
			//null pointer exception prevention
			this.names = new HashMap<>();
		} else {
			this.names = nazvy;
		}
		
		addMenu(MENU_ID);
	}
	
	private void addMenu(String menuId) {
		RepeatingView menuItems = new RepeatingView(menuId);
		
		//homepage link
		if (this.homePage != null) {
			Link homeLink = new Link(menuItems.newChildId()) {
				
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					setResponsePage(homePage);
				}
			};
			homeLink.setBody(Model.of("Home"));
			menuItems.add(homeLink);
			
			//add separator
			if(showSeparator) {
				menuItems.add(new Label(menuItems.newChildId(),separator));
			}
		}
		
		
		//add links to categories
		long lastKatId = 0;
		
		//if the list is empty
		if (!kategorie.isEmpty()) {
			lastKatId = kategorie.get(kategorie.size()-1).getId();
		}
		for (final Kategorie k : kategorie) {
			
			//if there is a caption for current category in hash map, use it
			//otherwise use category name as caption
			final String caption = names.get(k.getId()) == null?k.getNazev():names.get(k.getId());
			
			Link menuLink = new Link(menuItems.newChildId()) {

				@Override
				public void onClick() {
					//category ID in parameter
					PageParameters params = new PageParameters();
					params.add("kategorieId", k.getId());
					
					//link to the category page
					setResponsePage(KategoriePage.class,params);
				}	
			};
			
			//link text
			menuLink.setBody(Model.of(caption));
			
			//add link to the category
			menuItems.add(menuLink);
			
			//add separator, but not after the last item
			if(showSeparator && (k.getId() != lastKatId)) {
				menuItems.add(new Label(menuItems.newChildId(),separator));
			}
		}
		
		
		//add the component
		
		add(menuItems);
	}
}
