package main;

import javafx.application.Application;
import main.DCSconnection.PortListenerThread;
import main.UI.AppGUI;
import main.UI.GUI;

public class Main {
    public static void main(String[] args) {
//        GUI.show();
        Application.launch(AppGUI.class, args);
        new Thread(new PortListenerThread()).start();
    }
}
