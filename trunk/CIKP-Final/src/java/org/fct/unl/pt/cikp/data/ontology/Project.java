package org.fct.unl.pt.cikp.data.ontology;

/**
 *
 * @author Paulo Figueiras
 */

public class Project {

    private String location ;
    private String deliverymethod ;
    private String closingdate ;
    private String name ;
    private String startingdate ;
    private String totalinvestiment ;
    private String type ;
    private String prodaffiliation ;

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
     * @return the deliverymethod
     */
    public String getDeliverymethod() {
        return deliverymethod;
    }

    /**
     * @param deliverymethod the deliverymethod to set
     */
    public void setDeliverymethod(String deliverymethod) {
        this.deliverymethod = deliverymethod;
    }

    /**
     * @return the closingdate
     */
    public String getClosingdate() {
        return closingdate;
    }

    /**
     * @param closingdate the closingdate to set
     */
    public void setClosingdate(String closingdate) {
        this.closingdate = closingdate;
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
     * @return the startingdate
     */
    public String getStartingdate() {
        return startingdate;
    }

    /**
     * @param startingdate the startingdate to set
     */
    public void setStartingdate(String startingdate) {
        this.startingdate = startingdate;
    }

    /**
     * @return the totalinvestiment
     */
    public String getTotalinvestiment() {
        return totalinvestiment;
    }

    /**
     * @param totalinvestiment the totalinvestiment to set
     */
    public void setTotalinvestiment(String totalinvestiment) {
        this.totalinvestiment = totalinvestiment;
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

    /**
     * @return the prodaffiliation
     */
    public String getProdaffiliation() {
        return prodaffiliation;
    }

    /**
     * @param prodaffiliation the prodaffiliation to set
     */
    public void setProdaffiliation(String prodaffiliation) {
        this.prodaffiliation = prodaffiliation;
    }
}
