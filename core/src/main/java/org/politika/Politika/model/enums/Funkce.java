package org.politika.Politika.model.enums;

public enum Funkce {

	Nic("žádná funkce"),
	Prezident("Prezident"),
	PredsVlady("Předseda vlády"),
	Premier("Premiér"),
	MistPred1("1. místopředseda vlády pro ekonomiku"),
	MistPredVV("Místopředseda vlády pro vědu a výzkum"),
	MinFin("Ministr financí"),
	MinVnitra("Ministr vnitra"),
	MinSprav("Ministr spravedlnosti"),
	MinObr("Ministr obrany"),
	MinPrumObch("Ministr průmyslu a obchodu"),
	MinZivPr("Ministr životního prostředí"),
	MinZem("Ministr zemědělství"),
	MinZahr("Ministr zahraničí"),
	MinZdrav("Ministr zdravotnictví"),
	MinPrCos("Ministr práce a sociálních věcí"),
	MinKult("Ministr kultury"),
	MinDopr("Ministr dopravy"),
	MinSMT("Ministr školství, mládeže a tělovýchovy"),
	MinMistR("Ministr pro mínístní rozvoj"),
	MinLP("Ministr pro lidská práva a rovné příležitosti"),
	PredLegRV("Předseda legislativní rady vlády");
	
	public final String funcName;
	
	private Funkce(String name) {
		funcName = name;
	}
}
