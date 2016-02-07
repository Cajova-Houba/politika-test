package org.politika.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.page.PageManagerDecorator;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.politika.ui.osoba.OsobaPanel;
import org.politika.ui.schema.KategoriePage;
import org.politika.ui.schema.TerminalPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see org.politika.ui.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		
		//mounting
		mountPage("/clanek", TerminalPage.class);
		mountPage("/cat", KategoriePage.class);
		mountPage("/home", HomePage.class);
		mountPage("/osoba", TerminalPage.class);
	}
}
