package by.it.nesterovich.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class ReportEntireBuilder extends ReportBuilder {

    @Override
    String titleReport(TitleType titleType) {
        return String.valueOf(titleType);
    }

    @Override
    String currentTime() {
        Date now = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, Locale.getDefault());
        return dateFormat.format(now);
    }

    @Override
    String massage(String message) {
        String mes = message;
        return mes;
    }
}
