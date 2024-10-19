package GUI

import javax.swing.JPanel

interface Page {
    fun construct(panel: JPanel);
}