package brunel.bastien;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SendButton extends VBox{
    public SendButton(String i){
        //création du bouton
        Button button = new Button(i);
        this.getChildren().addAll(button);
        
        //onclick: faire appel a la fonction operation et remplacer le champ de saisie par le résultat
        button.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            String Cur = ChampCalcul.TextField.getText();
            ChampCalcul.TextField.setText(""+operation(Cur));
            }
        });
    }

    private double operation(String exp) {
        /*
         * Fonction qui execute le calcul passé en paramètre sous la forme d'un string.
         * les opérateurs sont les suivants : " + ", " - ", " / ", " x ".
         * ATTENTION les opérateurs doivent etre entourés d'espace pour etre reconnu.
         */
        //on transforme la chaine de caractère en liste terme a terme.
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(exp.split(" ")));
        double result = 0;
        
        //on récupère l'opérateur du premier calcul ainsi que les termes
        String operateur = list.get(1);
        double nb1_2 = Double.valueOf(list.get(0));
        double nb2_2 = Double.valueOf(list.get(2));

        //on identifie le calcul a effectue en fonction du signe
        if(operateur.equals("+")) {
            result = nb1_2 + nb2_2;
        }
        else if(operateur.equals("-")) {
            result = nb1_2 - nb2_2;
        }
        else if(operateur.equals("x")) {
            result = nb1_2 * nb2_2;
        }
        else if(operateur.equals("/")) {
            result = nb1_2 / nb2_2;
        }

        //on supprime le calcul effectue
        list.remove(0);
        list.remove(0);
        list.set(0, String.valueOf(result));

        //si le calcul ne contient plus qu'un terme, fin du programme
        if (list.size()==1) {
            return Double.valueOf(list.get(0));
        
        //sinon on ajoute le résultat a la liste existante
        }else{
            String new_list = "";
            for (String string : list) {
                switch(string){
                    case "+":
                        new_list = new_list+" + ";
                        break;

                    case "-":
                        new_list = new_list+" - ";
                        break;

                    case "*":
                        new_list = new_list+" * ";
                        break;

                    case "/":
                        new_list = new_list+" / ";
                        break;
                        
                      default:
                        new_list = new_list+string;

                }                
            }
            return operation(new_list);
        }
    }
}
