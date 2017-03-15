package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private Map<String,Word> dictionary=new TreeMap<String,Word>();
	private Map<String,WordEnhanced> dictionary1= new TreeMap<String,WordEnhanced>();
	
	public void addWord(String alienWord, String translation){
		if (!dictionary.containsKey(alienWord))
			dictionary.put(alienWord,new Word(alienWord,translation));
		else
			dictionary.replace(alienWord,dictionary.get(alienWord),new Word(alienWord,translation));
	}
	
	public void addWord1(String alienWord, String translation){
		if (!dictionary1.containsKey(alienWord)){
			dictionary1.put(alienWord,new WordEnhanced(alienWord));
			dictionary1.get(alienWord).addTranslation(translation);
		}
		else
			dictionary1.get(alienWord).addTranslation(translation);
	}
	
	public String translateWord(String alienWord){
		if (!dictionary.containsKey(alienWord))
			return null;
		else
			return dictionary.get(alienWord).getTranslation();
	}
	
	public Collection translateWord1(String alienWord){
		if (!dictionary1.containsKey(alienWord))
			return null;
		else
			return dictionary1.get(alienWord).getTranslation();
	}
	
	public Collection translateWord2(String alienWord){
		int y,z;
		List<String> temp=new LinkedList<String>();
		for (Word w: dictionary.values()){
			y=0;
			z=0;
			for (int x=0;x<w.getAlienWord().length();x++){
				if (w.getAlienWord().charAt(x)==alienWord.charAt(x))
					y++;
				if (alienWord.charAt(x)=='?')
					z++;
			}
			if (z==1 && y==alienWord.length()-1)
				temp.add(w.getAlienWord()+" "+w.getTranslation());
			if (z==0 && y==alienWord.length()){
				temp.add(w.getTranslation());
			}
		}
		return temp;
	}
	
}
