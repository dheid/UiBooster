package de.milchreis.uibooster.model.formelements;

import de.milchreis.uibooster.model.FormElement;
import de.milchreis.uibooster.model.FormElementChangeListener;

import javax.swing.*;
import java.awt.*;

public class CheckboxFormElement extends FormElement {

    private final JLabel title;
    private final JCheckBox checkbox;

    public CheckboxFormElement(String label) {
        this(label, null);
    }

    public CheckboxFormElement(String label, String headline) {
        super(headline);
        title = new JLabel(label);
        checkbox = new JCheckBox();
    }

    @Override
    public JComponent createComponent(FormElementChangeListener onChange) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(title, BorderLayout.WEST);
        panel.add(checkbox, BorderLayout.EAST);

        checkbox.addActionListener((l) -> {
            if (onChange != null)
                onChange.onChange(this, checkbox, form);
        });

        return panel;
    }

    @Override
    public void setEnabled(boolean enable) {
        title.setEnabled(enable);
        checkbox.setEnabled(enable);
    }

    @Override
    public Object getValue() {
        return checkbox.isSelected();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Boolean) {
            checkbox.setSelected((Boolean) value);
        } else {
            throw new IllegalArgumentException("The value has to be a boolean");
        }
    }

}
