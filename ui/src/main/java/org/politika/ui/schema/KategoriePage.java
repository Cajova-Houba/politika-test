package org.politika.ui.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters; 
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.politika.Politika.generic.service.GenericManager;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;
import org.politika.Politika.model.Prispevek;
import org.politika.Politika.model.enums.KatTyp;
import org.politika.Politika.service.KategorieManager;
import org.politika.Politika.service.PrispevekManager;
import org.politika.ui.base.GenericPage;
import org.politika.ui.base.MenuBar;
import org.politika.ui.osoba.OsobaLink;


/**
 * The purpose of subcategoroy page is to display links to child subcategories and terminal pages.
 * @author Zdenda
 *
 */
public class KategoriePage extends GenericPage {

	protected static final Logger logger = LogManager.getLogger(KategoriePage.class);
	
	private static final long serialVersionUID = 1L;

	private long katId;
	
	private boolean isMainCat = false;
	
	private final long ERR_CATEGORY = -1;
	
	@SpringBean(name="kategorieManager")
	KategorieManager kategorieManager;
	
	@SpringBean(name="prispevekManager")
	private PrispevekManager prispevekManager;
	
	public KategoriePage(PageParameters parameters) {
		super(parameters);
	}
	
	@Override
	public void inic(PageParameters parameters) {
		super.inic(parameters);
		setTitle("Kategorie");
		
		if (katId != ERR_CATEGORY) {
			setHeader(kategorieManager.get(katId).getNazev());
		}
	}
	
	@Override
	public void loadParameters(PageParameters parameters) {
		super.loadParameters(parameters);
		
		//load kategorieId
		if (!parameters.get("kategorieId").isNull()) {
			try {
				katId = Long.parseLong(parameters.get("kategorieId").toString());
				
				//check if category exists
				if (! kategorieManager.exists(katId)) {
					katId = ERR_CATEGORY;
					addError("Error when parsing parameter kategorieId");
				} else {
					
					//if there is no parent category, the category is main
					isMainCat = (kategorieManager.get(katId).getRodicovskaKategorie() == null);
					logger.warn("The loaded category is: "+kategorieManager.get(katId).toString());
				}
			} catch (NumberFormatException e) {
				katId = ERR_CATEGORY;
				addError("Error when parsing parameter kategorieId. "+e.toString());
			}
		} else {
			katId = ERR_CATEGORY;
			addError("Error when parsing parameter kategorieId");
		}
	}
	
	@Override
	public void addComponents(PageParameters parameters) {
		super.addComponents(parameters);
		displaySubCategories("subCategories");
		displayLinks("links");
	}
	
	@Override
	protected MenuBar createNavigationBar(String navBarId) {
		
		//if this is category is a main category (or the category id is not correct), then do not show the navigation bar
		if (isMainCat || (katId == ERR_CATEGORY)) {
			return super.createNavigationBar(navBarId);
			
		//else show navigation bar from the main category to this subcategory
		} else {
			//get a chain of categories to display
			List<Kategorie> kategorie = new ArrayList<Kategorie>(0);
			
			//this category
			Kategorie k = kategorieManager.get(katId);
			
			//get parent categories recursively
			while (k != null) {
				kategorie.add(0,k);
				k = k.getRodicovskaKategorie();
			}
			
			//return the navigation bar
			return new MenuBar(navBarId, kategorie, true);
		}
		
	}
	
	private void displayLinks(String linksId) {
		//if the type is normal, display links to articles
		//if the type is osoby, display links to persons
		if(katId != ERR_CATEGORY) {
			switch(kategorieManager.get(katId).getTyp()) {
			case Normal: displayArticleLinks(linksId);
						break;
			case Osoby: displayPersonLinks(linksId);
						break;
			default: logger.warn("Display nothing.");
			}
		} else {
			add(new Label(linksId,""));
		}
	}
	
	private void displaySubCategories(String subCatsId) {
		
		//get subcategories
		List<Kategorie> subKategorie = new ArrayList<Kategorie>(0);
		
		//check
		if (katId != ERR_CATEGORY) {
			subKategorie = kategorieManager.get(katId).getSubkategorie();
		}
		
		RepeatingView subs = new RepeatingView(subCatsId);
		
		for(final Kategorie k : subKategorie) {
			
			//create link to sub category
			Link l = new Link(subs.newChildId()) {

				@Override
				public void onClick() {
					PageParameters params = new PageParameters();
					params.add("kategorieId", k.getId());
					
					setResponsePage(KategoriePage.class,params);
				}
			};
			l.setBody(Model.of(k.getNazev()));
			
			//add that link
			subs.add(l);
		}
		
		//add list of links
		add(subs);
	}
	
	private void displayArticleLinks(String artLinksId) {
		
		logger.warn("Display article links method");
		
		List<Prispevek> prispevky =  prispevekManager.getAll(katId);
		
		RepeatingView termLinks = new RepeatingView(artLinksId);
		
		for(final Prispevek p : prispevky) {
			Link l = new Link(termLinks.newChildId()) {

				@Override
				public void onClick() {
					PageParameters params = new PageParameters();
					params.set("artId", p.getId());
					params.add("katId", katId);
					setResponsePage(TerminalPage.class,params);
				}
				
			};
			l.setBody(Model.of(p.getNadpis()));
			
			termLinks.add(l);
		}
		
		//link to display all articles, only if any articles all displayed
		if (!prispevky.isEmpty()) {
			Link artAll = new Link(termLinks.newChildId()) {
				
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					PageParameters params = new PageParameters();
					params.add("katId", katId);
					params.add("katId", katId);
					setResponsePage(TerminalPage.class,params);
				}
				
			};
			artAll.setBody(Model.of("Všechny články..."));
			
			termLinks.add(artAll);
		}
		
		add(termLinks);
	}
	
	private void displayPersonLinks(String linksId) {
		
		logger.warn("Display person links method");
		
		List<Osoba> osoby = kategorieManager.getAllPersons(katId);
		
		logger.warn("Number of persons: "+osoby.size());
		
		RepeatingView osLinks = new RepeatingView(linksId);
		
		for(final Osoba o : osoby) {
			
			OsobaLink l = new OsobaLink(osLinks.newChildId(), o, katId);
			
			osLinks.add(l);		
		}
		
		add(osLinks);
	}
}
