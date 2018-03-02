package cz.IBA.servlet.service;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter extends PropertyEditorSupport {
    @Override
    public void setAsText(String value) {
        try {
            setValue(new SimpleDateFormat("dd.MM.yyyy").parse(value));
        } catch (Exception ex) {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        String stringDate = "";
        try {
            stringDate= new SimpleDateFormat("dd.MM.yyyy").format((Date)getValue());
        } catch(Exception ex) {
            //
        }
        return stringDate;
    }
}