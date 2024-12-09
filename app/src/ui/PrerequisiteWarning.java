package ui;

import javax.swing.*;

public class PrerequisiteWarning {
    public static boolean showPrerequisiteWarning() {
        int option = JOptionPane.showConfirmDialog(
                null,
                "Esta actividad tiene prerrequisitos que no has completado. ¿Deseas continuar?",
                "Advertencia de Prerrequisitos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        return option == JOptionPane.YES_OPTION;
    }
}

