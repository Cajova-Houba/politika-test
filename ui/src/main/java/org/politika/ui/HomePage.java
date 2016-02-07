package org.politika.ui;


import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.politika.ui.base.GenericPage;


public class HomePage extends GenericPage {
	private static final long serialVersionUID = 1L;
	
	
	public HomePage(final PageParameters parameters) {
		super(parameters);		
    }
	
	@Override
	public void inic(PageParameters parameters) {
		super.inic(parameters);
		
		setTitle("Home");
		setHeader("News");
	}
}
