package org.example;

import java.util.Date;

public class Todo {
    private String text;
    private Date startDate = new Date();
    private Date endDate;

    public Todo () {}

    public Todo (String text, Date endDate) {
        this.text = text;
        this.endDate = endDate;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
