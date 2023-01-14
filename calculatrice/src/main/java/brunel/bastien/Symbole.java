package brunel.bastien;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Symbole extends VBox{
    public Symbole(String tab){
        //création du bouton
        Button buttonW = new Button(""+(tab));
        this.getChildren().addAll(buttonW);
        
        //on click: ajout de sa valeur dans le champ de texte
        buttonW.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            String Cur = ChampCalcul.TextField.getText();
            ChampCalcul.TextField.setText(Cur+" "+tab+" ");
            }
        });
    }
    
}
