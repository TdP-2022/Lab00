package it.polito.tdp.lab00_soluzione;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private int tentativiFatti = 0;
	private int TMAX = 3;
	private int TNOW;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnAccedi;

    @FXML
    private Label labelInfo;

    @FXML
    private Label labelTentativi;

    @FXML
    private Button btnClear;

    @FXML
    void doAccedi(ActionEvent event) {
    	
    	String nome = txtNome.getText();
    	String password = txtPassword.getText();
    	
    	if (nome.length()==0){
    		labelInfo.setText("Inserire il nome");
    	} else  {
    	
    	this.tentativiFatti++;
    	if (password.length()<7) {  
    		labelInfo.setText("La password deve contenere almeno 7 caratteri");
    		TNOW = (TMAX-tentativiFatti);
    		labelTentativi.setText("Numero di tentativi rimasti: " + Integer.toString(TNOW));
    		txtNome.setDisable(true);
    		if (TNOW==0) {
    			btnAccedi.setDisable(true);
    		}
    		
    	}else {

    		if (password.matches("[a-zA-Z0-9?!@#]*") && 
    				!password.matches("[a-z0-9?!@#]*") && 
    				!password.matches("[a-z0-9]*") && 
    				!password.matches("[a-z]*") &&
    				!password.matches("[A-Z0-9?!@#]*") && 
    				!password.matches("[A-Z0-9]*") &&
    				!password.matches("[A-Z]*") &&
    				!password.matches("[0-9a-zA-Z]*") &&
    				!password.matches("[0-9a-z]*") &&
    				!password.matches("[0-9]*") &&
    				!password.matches("[?!@#a-zA-Z]*") &&
    				!password.matches("[?!@#a-z]*") &&
    				!password.matches("[?!@#]*") 
    				)
    		{
    			labelInfo.setText("Password corretta!");
    			labelTentativi.setText("");
    		}else {
    			labelInfo.setText("La password deve contenere almeno 1 lettera maiuscola,\n"
    					+ "un numero ed un carattere tra ?!@# ");
        		TNOW = (TMAX-tentativiFatti);
        		labelTentativi.setText("Numero di tentativi rimasti: " + Integer.toString(TNOW));
        		txtNome.setDisable(true);
        		if (TNOW==0) {
        			btnAccedi.setDisable(true);
        		}
    			
    		}
    	}
    		
    	}


    }

    @FXML
    void doClear(ActionEvent event) {
    	txtNome.clear();
    	txtPassword.clear();
    	txtNome.setDisable(false);
    	btnAccedi.setDisable(false);
    	this.tentativiFatti = 0;
    	labelTentativi.setText(null);
    	labelInfo.setText(null);
    	
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAccedi != null : "fx:id=\"btnAccedi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelInfo != null : "fx:id=\"labelInfo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelTentativi != null : "fx:id=\"labelTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

