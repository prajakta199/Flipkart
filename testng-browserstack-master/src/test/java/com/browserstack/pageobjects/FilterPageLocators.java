package com.browserstack.pageobjects;

public class FilterPageLocators {
	public static final String MOBILE_ACCESSORIES="//a[@title='Mobiles & Accessories'][text()='Mobiles & Accessories']";
	public static final String MOBILES="//a[@title='Mobiles'][text()='Mobiles']";
	
	public static final String BRAND_FILTER="//div[text()='Brand']";
	public static final String BRAND_SAMSUNG="//div[@title='SAMSUNG']";
	public static final String BRAND_SAMSUNG_CHCKBX="//div[text()='SAMSUNG']/../input[@type='checkbox']";
	public static final String FLIPKART_ASSURED_CHCKBX="//img[@src='//static final-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_62673a.png']/../../..//input[@type='checkbox']";

	public static final String APPLIED_FILTERS="//span[text()='Filters']";
	public static final String FASSURED="//div[text()='APPLIED']";
	public static final String ADDITIONAL="//div[text()='ADDTNL']";
	public static final String CLEARALL="//span[text()='Filters']/../..//span[text()='Clear all']";
	public static final String PAGE="//span[text()='Page 1 of 6']";
	
}
