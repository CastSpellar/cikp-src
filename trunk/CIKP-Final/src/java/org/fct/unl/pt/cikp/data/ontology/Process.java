
package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType;
import com.hp.hpl.jena.datatypes.xsd.impl.XSDTimeType;

/**
 *
 * @author Paulo Figueiras
 */
public class Process {
    
    private String location ;
    private String subject_domain ;
    private int process_cost ;
    private XSDTimeType process_ending_time ;
    private XSDDateType process_starting_time ;
    private String process_type ;
    private String username ;

    public Process() {}

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
     * @return the subject_domain
     */
    public String getSubject_domain() {
        return subject_domain;
    }

    /**
     * @param subject_domain the subject_domain to set
     */
    public void setSubject_domain(String subject_domain) {
        this.subject_domain = subject_domain;
    }

    /**
     * @return the process_cost
     */
    public int getProcess_cost() {
        return process_cost;
    }

    /**
     * @param process_cost the process_cost to set
     */
    public void setProcess_cost(int process_cost) {
        this.process_cost = process_cost;
    }

    

    /**
     * @return the process_type
     */
    public String getProcess_type() {
        return process_type;
    }

    /**
     * @param process_type the process_type to set
     */
    public void setProcess_type(String process_type) {
        this.process_type = process_type;
    }

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
     * @return the process_ending_time
     */
    public XSDTimeType getProcess_ending_time() {
        return process_ending_time;
    }

    /**
     * @param process_ending_time the process_ending_time to set
     */
    public void setProcess_ending_time(XSDTimeType process_ending_time) {
        this.process_ending_time = process_ending_time;
    }

    /**
     * @return the process_starting_time
     */
    public XSDDateType getProcess_starting_time() {
        return process_starting_time;
    }

    /**
     * @param process_starting_time the process_starting_time to set
     */
    public void setProcess_starting_time(XSDDateType process_starting_time) {
        this.process_starting_time = process_starting_time;
    }

    

}
