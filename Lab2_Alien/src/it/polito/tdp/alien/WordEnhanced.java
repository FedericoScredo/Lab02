package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String>translation;

	public WordEnhanced(String parola){
		this.alienWord=parola;
		this.translation=new LinkedList<String>();
	}
	
	public void addTranslation(String t){
		if(!cercaTraduzione(t))
			translation.add(t);
	}
	
	public boolean cercaTraduzione(String t){
		for (String s:translation){
			if (s.compareTo(t)==0)
				return true;
		}
		return false;
	}
	
	public String getAlienWord(){
		return alienWord;
	}
	
	public Collection<String> getTranslation(){
		return translation;
	}
	
	public boolean compare(String alienWord){
		if (this.alienWord.compareTo(alienWord)==0)
			return true;
		else
			return false;
	}
	
}
