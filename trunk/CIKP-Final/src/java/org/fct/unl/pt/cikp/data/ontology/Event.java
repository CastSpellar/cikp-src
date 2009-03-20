package org.fct.unl.pt.cikp.data.ontology;

/**
 *
 * @author Paulo Figueiras
 */
public class Event {

    private String username ;
    private String eventtype ;
    private int eventcost ;
    private String eventendingtime ;
    private String eventstartingtime ;
    private String location ;
    private String subjectDomain ;

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
     * @return the eventcost
     */
    public int getEventcost() {
        return eventcost;
    }

    /**
     * @param eventcost the eventcost to set
     */
    public void setEventcost(int eventcost) {
        this.eventcost = eventcost;
    }

    /**
     * @return the eventendingtime
     */
    public String getEventendingtime() {
        return eventendingtime;
    }

    /**
     * @param eventendingtime the eventendingtime to set
     */
    public void setEventendingtime(String eventendingtime) {
        this.eventendingtime = eventendingtime;
    }

    /**
     * @return the eventstartingtime
     */
    public String getEventstartingtime() {
        return eventstartingtime;
    }

    /**
     * @param eventstartingtime the eventstartingtime to set
     */
    public void setEventstartingtime(String eventstartingtime) {
        this.eventstartingtime = eventstartingtime;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the subjectDomain
     */
    public String getSubjectDomain() {
        return subjectDomain;
    }

    /**
     * @param subjectDomain the subjectDomain to set
     */
    public void setSubjectDomain(String subjectDomain) {
        this.subjectDomain = subjectDomain;
    }


}
