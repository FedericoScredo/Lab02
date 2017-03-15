package it.polito.tdp.alien;

public class Word {
	
	private String alienWord,translation;

	public Word(String parola,String traduzione){
		this.alienWord=parola;
		this.translation=traduzione;
	}
	
	public String getAlienWord(){
		return alienWord;
	}
	
	public String getTranslation(){
		return translation;
	}
	
	public boolean compare(String alienWord){
		if (this.alienWord.compareTo(alienWord)==0)
			return true;
		else
			return false;
	}
	
}
