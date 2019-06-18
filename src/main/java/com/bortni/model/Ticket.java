package com.bortni.model;

import com.bortni.model.enums.Bonus;
import com.bortni.model.enums.TicketClass;

import java.util.List;

public abstract class Ticket {
    private List<Bonus> bonuses;
    private TicketClass ticketClass;

    public Ticket(List<Bonus> bonuses, TicketClass ticketClass) {
        this.bonuses = bonuses;
        this.ticketClass = ticketClass;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }
}
