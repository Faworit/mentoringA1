package com.epam.ryabtsev.model;

import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.UserImpl;

/**
 * Created by maksym_govorischev.
 */
public interface Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id);
    Category getCategory();
    void setCategory(Category category);
    int getPlace();
    void setPlace(int place);
    EventImpl getEvent();
    void setEvent(EventImpl event);
    UserImpl getUser();
    void setUser(UserImpl user);

}
