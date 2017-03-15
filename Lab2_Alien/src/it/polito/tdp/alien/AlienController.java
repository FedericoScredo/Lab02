package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;
    
    private AlienDictionary dictionary=new AlienDictionary();


    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtResult.setText("Welcome to Alien Dictionary v2016");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String frase=txtWord.getText();
    	txtWord.clear();
    	String parole[]=frase.split(" ");
    	if (parole.length==2){
    		if (controlloCaratteri(parole[0])==true && controlloCaratteri(parole[1])==true){
	    		dictionary.addWord(parole[0], parole[1]);
	    		txtResult.appendText("\n"+"Added: "+parole[0]+" "+parole[1]);
    		}
    	}
    	if (parole.length==1){
    		if (controlloCaratteri(parole[0])==true)
    			txtResult.appendText("\n"+"Translation: "+dictionary.translateWord(parole[0]));
    	}
    }
    
    @FXML
    void doTranslate1(ActionEvent event){
    	String frase=txtWord.getText();
    	txtWord.clear();
    	String parole[]=frase.split(" ");
    	if (parole.length==2){
    		if (controlloCaratteri(parole[0])==true && controlloCaratteri(parole[1])==true){
	    		dictionary.addWord1(parole[0], parole[1]);
	    		txtResult.appendText("\n"+"Added: "+parole[0]+" "+parole[1]);
    		}
    	}
    	if (parole.length==1){
    		if (controlloCaratteri(parole[0])==true){
    			List<String> temp=(List<String>) dictionary.translateWord1(parole[0]);
    			txtResult.appendText("\nTranslations: ");
    			for (String s: temp){
    				txtResult.appendText("\n   "+s);
    			}
    		}
    	}
    }
    
    @FXML
    void doTranslate2(ActionEvent event){
    	String frase=txtWord.getText();
    	txtWord.clear();
    	String parole[]=frase.split(" ");
    	if (parole.length==2){
    		if (controlloCaratteri(parole[0])==true && controlloCaratteri(parole[1])==true){
	    		dictionary.addWord(parole[0], parole[1]);
	    		txtResult.appendText("\n"+"Added: "+parole[0]+" "+parole[1]);
    		}
    	}
    	if (parole.length==1){
    		if (controlloCaratteri(parole[0])==true){
    			List<String> temp=(List<String>) dictionary.translateWord2(parole[0]);
    			txtResult.appendText("\nTranslations: ");
    			for (String s: temp){
    				txtResult.appendText("\n   "+s);
    			}
    		}
    	}
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }
    
    boolean controlloCaratteri(String parola){
    	int y=0;
    	for (int x=0;x<parola.length();x++){
    		//System.out.println((int)parola.charAt(x)+" a:"+(int)'a'+" z:"+(int)'z'+" A:"+(int)'A'+" Z:"+(int)'Z');
    		if (!((int)parola.charAt(x)>=(int)'A' && (int)parola.charAt(x)<=(int)'Z') 
    				&& !((int)parola.charAt(x)>=(int)'a' && (int)parola.charAt(x)<=(int)'z') 
    				&& (int)parola.charAt(x)!=(int)'?'){	
    			return false;
    		}
    		if ((int)parola.charAt(x)==(int)'?')
				y++;
    	}
    	if (y>1){
    		return false;
    	}
    	else
    		return true;
    }
}

