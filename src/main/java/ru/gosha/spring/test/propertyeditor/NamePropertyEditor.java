package ru.gosha.spring.test.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {//Создали свой PropertyEditor ; setAsText - основной метод
    @Override
    public void setAsText(String text) throws IllegalArgumentException { // Переводит весь текст в Upper
        String myConvertedStringValue = text.toUpperCase();
        setValue(myConvertedStringValue);
    }

//    @Override                                      other hand of setAsText from obj -> str
//    public String getAsText() {
//          getValue()                  returning passed obj
//        return super.getAsText();
//    }
}
