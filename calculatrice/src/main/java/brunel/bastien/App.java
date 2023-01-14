/**
*
* Programme Java pour créer une calculatrice a l'aide du module javafx
*
* @author  Bastien BRUNEL
* @version 1.2 
* @since   2022-12-5
*
**/
package brunel.bastien;

//import
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        VBox content = new VBox();

        //création des boutons chiffres
        VBox content_colonne = new VBox();
        for (int i = 0; i < 3; i++) {
            HBox content_ligne = new HBox();
            for (int j = 0; j < 3; j++) {
                Chiffre buttonW = new Chiffre(3*i+j+1);
                content_ligne.getChildren().addAll(buttonW);
            }
            content_colonne.getChildren().addAll(content_ligne);
        }
        Chiffre buttonT = new Chiffre(0);
        content_colonne.getChildren().addAll(buttonT);

        //création des boutons symboles
        HBox content_symbole = new HBox();
        String tab[] = {"+", "-", "x", "/"};
        for (int i = 0; i < tab.length; i++) {
            Symbole buttonW = new Symbole(tab[i]);
            content_symbole.getChildren().addAll(buttonW);
        }
        
        //champ de saisie du calcul
        HBox content_formule = new HBox();
        ChampCalcul TextField = new ChampCalcul();
        
        
        //Bonton send
        SendButton send = new SendButton("send");
        content_formule.getChildren().addAll(TextField, send);

        //Bouton reset
        reset reset = new reset("RESET");

        //regrouper tous les modules et gerer la fenetre
        content.getChildren().addAll(content_colonne, content_symbole, content_formule, reset);
        var scene = new Scene(content, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}