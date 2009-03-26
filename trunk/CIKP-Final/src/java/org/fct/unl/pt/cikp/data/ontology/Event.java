package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDTimeType;
/**
 *
 * @author Paulo Figueiras
 */
public class Event {

    private String username ;
    private String eventtype ;
    private int event_cost ;
    private XSDTimeType event_ending_time ;
    private XSDTimeType event_starting_time ;
    private String event_location ;
    private String event_subject_domain ;

    public void Event() {}

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the eventtype
     */
    public String getEventtype() {
        return eventtype;
    }

    /**
     * @param eventtype the eventtype to set
     */
    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    /**
     * @return the event_cost
     */
    public int getEvent_cost() {
        return event_cost;
    }

    /**
     * @param event_cost the event_cost to set
     */
    public void setEvent_cost(int event_cost) {
        this.event_cost = event_cost;
    }

    

    /**
     * @return the event_location
     */
    public String getEvent_location() {
        return event_location;
    }

    /**
     * @param event_location the event_location to set
     */
    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    /**
     * @return the event_subject_domain
     */
    public String getEvent_subject_domain() {
        return event_subject_domain;
    }

    /**
     * @param event_subject_domain the event_subject_domain to set
     */
    public void setEvent_subject_domain(String event_subject_domain) {
        this.event_subject_domain = event_subject_domain;
    }

    /**
     * @return the event_ending_time
     */
    public XSDTimeType getEvent_ending_time() {
        return event_ending_time;
    }

    /**
     * @param event_ending_time the event_ending_time to set
     */
    public void setEvent_ending_time(XSDTimeType event_ending_time) {
        this.event_ending_time = event_ending_time;
    }

    /**
     * @return the event_starting_time
     */
    public XSDTimeType getEvent_starting_time() {
        return event_starting_time;
    }

    /**
     * @param event_starting_time the event_starting_time to set
     */
    public void setEvent_starting_time(XSDTimeType event_starting_time) {
        this.event_starting_time = event_starting_time;
    }

}
