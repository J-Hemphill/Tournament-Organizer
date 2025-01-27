package org.launchcode.tournamentevents.models;

import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required!")
    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;

    // This Class Event is One To One EventDetails Object
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    public Event(
            String name,
            EventDetails eventDetails
    ) {

        this.name = name;
        this.eventDetails = eventDetails;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return name;
    }

}
