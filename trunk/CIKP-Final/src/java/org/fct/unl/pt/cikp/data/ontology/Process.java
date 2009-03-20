
package org.fct.unl.pt.cikp.data.ontology;

/**
 *
 * @author Paulo Figueiras
 */
public class Process {
    
    private String location ;
    private String subjectdomain ;
    private int proccost ;
    private String procendingtime ;
    private String procstartingtime ;
    private String proctype ;
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
     * @return the subjectdomain
     */
    public String getSubjectdomain() {
        return subjectdomain;
    }

    /**
     * @param subjectdomain the subjectdomain to set
     */
    public void setSubjectdomain(String subjectdomain) {
        this.subjectdomain = subjectdomain;
    }

    /**
     * @return the proccost
     */
    public int getProccost() {
        return proccost;
    }

    /**
     * @param proccost the proccost to set
     */
    public void setProccost(int proccost) {
        this.proccost = proccost;
    }

    /**
     * @return the procendingtime
     */
    public String getProcendingtime() {
        return procendingtime;
    }

    /**
     * @param procendingtime the procendingtime to set
     */
    public void setProcendingtime(String procendingtime) {
        this.procendingtime = procendingtime;
    }

    /**
     * @return the procstartingtime
     */
    public String getProcstartingtime() {
        return procstartingtime;
    }

    /**
     * @param procstartingtime the procstartingtime to set
     */
    public void setProcstartingtime(String procstartingtime) {
        this.procstartingtime = procstartingtime;
    }

    /**
     * @return the proctype
     */
    public String getProctype() {
        return proctype;
    }

    /**
     * @param proctype the proctype to set
     */
    public void setProctype(String proctype) {
        this.proctype = proctype;
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

}
