package brunel.bastien;

import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class ChampCalcul extends VBox{
    public static TextField TextField;

    public ChampCalcul(){
        TextField = new TextField();
        this.getChildren().addAll(TextField);
        
    }
}
