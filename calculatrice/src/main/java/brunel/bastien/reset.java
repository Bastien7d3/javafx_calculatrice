package brunel.bastien;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class reset extends VBox{
    public reset(String str){
        //création du bouton
        Button button = new Button(str);
        this.getChildren().addAll(button);

        //onclick: mettre le champ de saisie a ""
        button.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            ChampCalcul.TextField.setText("");
            }
        });
    }
}
