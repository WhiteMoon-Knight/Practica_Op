/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poker.practica_op.hja.GUI;

/**
 *
 * @author jjcar
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class PlayerActionButton extends JButton {
    
    //Estados por los que cirula el boton
    protected enum State { DEAL, FOLD, RESET }
    
    //Estado actual del boton
    private State button_state;
   
    
    //Constructor basico
    public PlayerActionButton(){
        init();
    }
    
    //Inicializador de parametros y opciones
    private void init(){
        button_state = State.DEAL;
        setButtonProperties();
    }
    
    /**
     * Setter para el estado del boton
     * @param state: Estado al que poner al boton 
     */
    public void setState(State state){
        button_state = state;
        setButtonProperties();
    }
    
    /**
     * Getter para el estado del boton
     * @return state: El esatdo del boton
     */
    public State getState(){
        return button_state;
    }
    
    private void setButtonProperties(){
        switch (button_state){
            case DEAL:
                this.setText("Deal Cards");
                this.setBackground(Color.WHITE);
                break;
            case FOLD:
                this.setText("FOLD");
                this.setBackground(Color.RED);
                break;
            case RESET:
                this.setText("Reset");
                this.setBackground(Color.WHITE);
                break;
        }
    }
    
    
}

