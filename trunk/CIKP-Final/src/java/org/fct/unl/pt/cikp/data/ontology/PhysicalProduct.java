
package org.fct.unl.pt.cikp.data.ontology;

/**
 *
 * @author Paulo Figueiras
 */
public class PhysicalProduct {

    private String location ;
    private String name ;
    private String event_affiliation ;
    private String process_affiliation ;
    private String project_affiliation ;
    private String type ;

    public void PhysicalProduct() {}

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the eventaffiliation
     */
    public String getEvent_affiliation() {
        return event_affiliation;
    }

    /**
     * @param eventaffiliation the eventaffiliation to set
     */
    public void setEvent_affiliation(String eventaffiliation) {
        this.event_affiliation = eventaffiliation;
    }

    /**
     * @return the procaffiliation
     */
    public String getProcess_affiliation() {
        return process_affiliation;
    }

    /**
     * @param procaffiliation the procaffiliation to set
     */
    public void setProcess_affiliation(String procaffiliation) {
        this.process_affiliation = procaffiliation;
    }

    /**
     * @return the projaffiliation
     */
    public String getProject_affiliation() {
        return project_affiliation;
    }

    /**
     * @param projaffiliation the projaffiliation to set
     */
    public void setProject_affiliation(String projaffiliation) {
        this.project_affiliation = projaffiliation;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
