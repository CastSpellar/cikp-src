package org.fct.unl.pt.cikp.data.ontology;

import java.util.ArrayList;

/**
 *
 * @author Paulo Figueiras
 */

public class KnowledgeItem {

    private String name ;
    private String creationdate ;
    private String creationtime ;
    private int filesize ;
    private ArrayList<String> keywords ;
    private String author ;
    private String complanguage ;
    private String copyrightowner ;
    private String destination ;
    private String filetype ;
    private String securityclearance ;
    private String source ;
    private String type ;
    private String subjectdom ;
    private String eventaffiliation ;
    private String geoaffiliation ;
    private String prodaffiliation ;
    private String projectaffiliation ;

    public KnowledgeItem() {}

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
     * @return the creationdate
     */
    public String getCreationdate() {
        return creationdate;
    }

    /**
     * @param creationdate the creationdate to set
     */
    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * @return the creationtime
     */
    public String getCreationtime() {
        return creationtime;
    }

    /**
     * @param creationtime the creationtime to set
     */
    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    /**
     * @return the filesize
     */
    public int getFilesize() {
        return filesize;
    }

    /**
     * @param filesize the filesize to set
     */
    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    /**
     * @return the keywords
     */
    public ArrayList<String> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the complanguage
     */
    public String getComplanguage() {
        return complanguage;
    }

    /**
     * @param complanguage the complanguage to set
     */
    public void setComplanguage(String complanguage) {
        this.complanguage = complanguage;
    }

    /**
     * @return the copyrightowner
     */
    public String getCopyrightowner() {
        return copyrightowner;
    }

    /**
     * @param copyrightowner the copyrightowner to set
     */
    public void setCopyrightowner(String copyrightowner) {
        this.copyrightowner = copyrightowner;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the filetype
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * @param filetype the filetype to set
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    /**
     * @return the securityclearance
     */
    public String getSecurityclearance() {
        return securityclearance;
    }

    /**
     * @param securityclearance the securityclearance to set
     */
    public void setSecurityclearance(String securityclearance) {
        this.securityclearance = securityclearance;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
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
     * @return the subjectdom
     */
    public String getSubjectdom() {
        return subjectdom;
    }

    /**
     * @param subjectdom the subjectdom to set
     */
    public void setSubjectdom(String subjectdom) {
        this.subjectdom = subjectdom;
    }

    /**
     * @return the eventaffiliation
     */
    public String getEventaffiliation() {
        return eventaffiliation;
    }

    /**
     * @param eventaffiliation the eventaffiliation to set
     */
    public void setEventaffiliation(String eventaffiliation) {
        this.eventaffiliation = eventaffiliation;
    }

    /**
     * @return the geoaffiliation
     */
    public String getGeoaffiliation() {
        return geoaffiliation;
    }

    /**
     * @param geoaffiliation the geoaffiliation to set
     */
    public void setGeoaffiliation(String geoaffiliation) {
        this.geoaffiliation = geoaffiliation;
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

    /**
     * @return the projectaffiliation
     */
    public String getProjectaffiliation() {
        return projectaffiliation;
    }

    /**
     * @param projectaffiliation the projectaffiliation to set
     */
    public void setProjectaffiliation(String projectaffiliation) {
        this.projectaffiliation = projectaffiliation;
    }
}
