package renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {

    private Color selectionBackgroundColor;
    private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

    public ComboBoxRenderer() {
        setOpaque(true);
        selectionBackgroundColor = this.dlcr.getBackground();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setBackground(Color.WHITE);
        Color mouseHoverHighlight = this.dlcr.getBackground();

        ItemComboBox itemData = (ItemComboBox) value;
        setText(itemData.getContent());

        if (isSelected) {
            setBackground(mouseHoverHighlight);
        } else {
            String selectedTextInDropdownList = getText();
            if (selectedTextInDropdownList.equals("SelectedTextOne")) {
                setBackground(Color.GREEN);
            } else if (selectedTextInDropdownList.equals("SelectedTextTwo")) {
                setBackground(Color.RED);
            }
        }
        String selectedText = getText();
        switch (selectedText) {
            case "SelectedTextOne":
                list.setSelectionBackground(Color.GREEN);
                break;
            case "SelectedTextTwo":
                list.setSelectionBackground(Color.RED);
                break;
            default:
                list.setSelectionBackground(this.dlcr.getBackground());
                break;
        }

        return this;
    }

}
