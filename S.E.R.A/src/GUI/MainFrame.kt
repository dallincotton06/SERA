package GUI

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.UIManager

class MainFrame() {

    var frame: JFrame = JFrame("SERA")
    private var panel: JPanel = JPanel()

    init {
        val scrollPane = JScrollPane(panel)
        UIManager.setLookAndFeel(FlatDarkLaf())
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Toolkit.getDefaultToolkit().screenSize
        frame.add(scrollPane)
        frame.isVisible = true
    }

    fun constructPage(dialog: Page) {
        panel.removeAll()
        panel.repaint()
        panel.updateUI()
    }
}