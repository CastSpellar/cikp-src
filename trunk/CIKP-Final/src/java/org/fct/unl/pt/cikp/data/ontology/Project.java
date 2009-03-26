package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType;

/**
 *
 * @author Paulo Figueiras
 */

public class Project {

    private String location ;
    private String project_delivery_method ;
    private XSDDateType project_closing_date ;
    private String name ;
    private XSDDateType project_starting_date ;
    private int project_total_investiment ;
    private String project_type ;
    private String product_affiliation ;

    public Project() {}

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
     * @return the project_delivery_method
     */
    public String getProject_delivery_method() {
        return project_delivery_method;
    }

    /**
     * @param project_delivery_method the project_delivery_method to set
     */
    public void setProject_delivery_method(String project_delivery_method) {
        this.project_delivery_method = project_delivery_method;
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
     * @return the project_total_investiment
     */
    public int getProject_total_investiment() {
        return project_total_investiment;
    }

    /**
     * @param project_total_investiment the project_total_investiment to set
     */
    public void setProject_total_investiment(int project_total_investiment) {
        this.project_total_investiment = project_total_investiment;
    }

    /**
     * @return the project_type
     */
    public String getProject_type() {
        return project_type;
    }

    /**
     * @param project_type the project_type to set
     */
    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    /**
     * @return the product_affiliation
     */
    public String getProduct_affiliation() {
        return product_affiliation;
    }

    /**
     * @param product_affiliation the product_affiliation to set
     */
    public void setProduct_affiliation(String product_affiliation) {
        this.product_affiliation = product_affiliation;
    }

    /**
     * @return the project_closing_date
     */
    public XSDDateType getProject_closing_date() {
        return project_closing_date;
    }

    /**
     * @param project_closing_date the project_closing_date to set
     */
    public void setProject_closing_date(XSDDateType project_closing_date) {
        this.project_closing_date = project_closing_date;
    }

    /**
     * @return the project_starting_date
     */
    public XSDDateType getProject_starting_date() {
        return project_starting_date;
    }

    /**
     * @param project_starting_date the project_starting_date to set
     */
    public void setProject_starting_date(XSDDateType project_starting_date) {
        this.project_starting_date = project_starting_date;
    }

    
}
