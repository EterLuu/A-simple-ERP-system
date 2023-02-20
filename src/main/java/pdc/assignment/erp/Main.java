package pdc.assignment.erp;

import java.util.logging.Level;
import java.util.logging.Logger;

import pdc.assignment.erp.ui.dialog.Loading;

public class Main {

    public static void main(String[] args) {
        Logger.getLogger(Main.class.getName()).log(Level.INFO, "Starting the program...");

        java.awt.EventQueue.invokeLater(() -> new Loading().setVisible(true));
    }
}
