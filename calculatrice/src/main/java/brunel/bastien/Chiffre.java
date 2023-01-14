package brunel.bastien;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Chiffre extends VBox {
    public Chiffre(int i){
            //création du bouton
            Button buttonW = new Button(""+(i));
            this.getChildren().addAll(buttonW);

            //on click: ajout de sa valeur dans le champ de texte
            buttonW.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String Cur = ChampCalcul.TextField.getText();
                ChampCalcul.TextField.setText(Cur+i);  
            }
        });
    }
}
