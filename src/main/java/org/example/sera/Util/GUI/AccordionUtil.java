package org.example.sera.Util.GUI;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class AccordionUtil {
    public static TitledPane findParentTitledPane(Node node) {
        Node parent = node.getParent();
        while (parent != null) {
            System.out.println(parent.getClass().getSimpleName());
            if (parent instanceof TitledPane) {
                return (TitledPane) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }

    public static boolean isInAccordion(Node node) {
       return findParentTitledPane(node) == null;
    }
}
