package org.launchcode.codingevents.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    @NotNull(message = "Location is required.")
    private String eventLocation;

    @AssertTrue(message = "You must register for this event.")
    private boolean registerForEvent;

    @NotNull
    @Positive(message = "Number of attendees must be one or more.")
    private int numberOfAttendees;

    @DateTimeFormat()
    @Positive(message = "Please enter the date of attendance")
    private String eventDate;

    public Event(String name, String description, String contactEmail, String eventLocation, Boolean registerForEvent, int numberOfAttendees, String eventDate) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventLocation = eventLocation;
        this.registerForEvent = registerForEvent;
        this.numberOfAttendees = numberOfAttendees;
        this.eventDate = eventDate;
        this.id = nextId;
        nextId++;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Boolean getRegisterForEvent() {
        return registerForEvent;
    }

    public void setRegisterForEvent(Boolean registerForEvent) {
        this.registerForEvent = registerForEvent;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
