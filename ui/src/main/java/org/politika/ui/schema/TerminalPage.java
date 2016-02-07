package org.politika.ui.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.politika.Politika.generic.service.GenericManager;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;
import org.politika.Politika.model.Prispevek;
import org.politika.Politika.service.KategorieManager;
import org.politika.Politika.service.PrispevekManager;
import org.politika.ui.HomePage;
import org.politika.ui.base.GenericPage;
import org.politika.ui.base.MenuBar;
import org.politika.ui.base.prispevek.PrispevekPanel;
import org.politika.ui.base.prispevek.PrispevekPanelList;
import org.politika.ui.osoba.OsobaPanel;

/**
 * Parameters:
 * 		artId:		ID of article that should be displayed. It has the highest priority.
 * 		osobaId:	ID of person that should be displayed. It has the second highest priority.
 * 					If the 'aktivita' parameter is present and set to 'true', this person's activity
 * 					will be also displayed.
 * 		katId:		ID of category from which all articles will be displayed. The lowest priority.
 * 					This ID should also be specified if you want to create a navigation bar.
 * @author Zdenda
 *
 */
public class TerminalPage extends GenericPage {
	
	protected static final Logger logger = LogManager.getLogger(KategoriePage.class);
	
	private static final long serialVersionUID = 1L;
	
	//this will display just the article
	private long artId;
	private boolean artIdLoaded = false;
	
	//this will display all articles from subcategory. The artId parameter has higher priority.
	private long katId;
	private boolean katIdLoaded = false;
	
	private long osobaId;
	private boolean osobaIdLoaded = false;
	
	private boolean aktivita = false;
	
	
	@SpringBean(name="prispevekManager")
	PrispevekManager prispevekManager;
	
	@SpringBean(name="kategorieManager")
	KategorieManager kategorieManager;
	
	@SpringBean(name="osobaManager")
	GenericManager<Osoba, Long> osobaManager;
	
	public TerminalPage(PageParameters parameters) {
		super(parameters);
	}
	
	@Override
	public void inic(PageParameters parameters) {
		super.inic(parameters);
		
		// display header only if category content or person will be displayed
		if (!artIdLoaded && osobaIdLoaded) {
			setHeader(osobaManager.get(osobaId).getName());
		}
		else if (!artIdLoaded && katIdLoaded) {
			setHeader(kategorieManager.get(katId).getNazev());
		} else {
			setHeader("");
		}
		
		
		if(artIdLoaded) {
			setTitle("Článek: "+prispevekManager.get(artId).getNadpis());
		} else  if (osobaIdLoaded) {
			setTitle("Osoba: "+osobaManager.get(osobaId).getName());
		} else if (katIdLoaded) {
			setTitle("Články z: "+kategorieManager.get(katId).getNazev());
		} else {
			setTitle("Prázdná stránka.");
		}
	}
	
	@Override
	public void loadParameters(PageParameters parameters) {
		super.loadParameters(parameters);
		
		//load artId
		if(!parameters.get("artId").isNull()) {
			try {
				artId = Long.parseLong(parameters.get("artId").toString());
				
				//check if exists
				if(prispevekManager.exists(artId)) {
					artIdLoaded = true;
				}
			} catch (Exception e) {
				addError("Error while parsing the 'artId' parameter. "+e.toString());
			}
		}

		//load osobaId
		if(!parameters.get("osobaId").isNull()) {
			try {
				osobaId = Long.parseLong(parameters.get("osobaId").toString());
				
				//check if exists
				osobaIdLoaded = osobaManager.exists(osobaId);
			} catch (Exception e) {
				addError("Error while parsing the 'osobaId' parameter. "+e.toString());
			}
		}
		
		//load aktivita 
		if(!parameters.get("aktivita").isNull()) {
			aktivita = parameters.get("aktivita").toString().equalsIgnoreCase("true");
		}
		
		//load katId
		if(!parameters.get("katId").isNull()) {
			try {
				katId = Long.parseLong(parameters.get("katId").toString());
				
				//check if exists
				if(kategorieManager.exists(katId)) {
					katIdLoaded = true;
				}
			} catch (Exception e) {
				addError("Error while parsing the 'katId' parameter. "+e.toString());
			}
		}
		
	}
	
	@Override
	public void addComponents(PageParameters parameters) {
		super.addComponents(parameters);
		
		displayContent("content");
	}
	
	@Override
	protected MenuBar createNavigationBar(String navBarId) {
		//if the katId is not loaded correctly, then there will be no 
		//navigation bar
		if(!katIdLoaded) {
			return super.createNavigationBar(navBarId);
		} else {
			//get a chain of categories to display
			List<Kategorie> kategorie = new ArrayList<Kategorie>(0);
			
			//parent category
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
	
	protected void displayContent(String contentId) {
		
		//check artId
		if(artIdLoaded) {
			PrispevekPanel pp = new PrispevekPanel(contentId, prispevekManager.get(artId));
			add(pp);
		
		//else check osobaId
		} else if (osobaIdLoaded) {
			OsobaPanel op = new OsobaPanel(contentId, osobaManager.get(osobaId), aktivita);
			add(op);
			
		//else check the katId
		} else if (katIdLoaded) {
			List<Prispevek> prispevky = kategorieManager.get(katId).getPrispevky();
			PrispevekPanelList ppl = new PrispevekPanelList(contentId, prispevky);
			add(ppl);
		} else {
			add(new Label(contentId,"Prázdná stránka"));
		}
	}
}
