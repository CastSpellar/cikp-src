package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType;
import com.hp.hpl.jena.datatypes.xsd.impl.XSDTimeType;
import java.util.ArrayList;

/**
 *
 * @author Paulo Figueiras
 */

public class KnowledgeItem {

    private String name ;
    private XSDDateType knowledge_item_creation_date ;
    private XSDTimeType knowledge_item_creation_time ;
    private int knowledge_item_file_size ;
    private ArrayList<String> knowledge_item_keyword ;
    private String knowledge_item_author ;
    private String knowledge_item_composition_language ;
    private String knowledge_item_copyright_owner ;
    private String knowledge_item_destination ;
    private String knowledge_item_file_type ;
    private String knowledge_item_security_clearance ;
    private String knowledge_item_source ;
    private String knowledge_item_type ;
    private String subject_domain ;
    private String event_affiliation ;
    private String geographic_affiliation ;
    private String product_affiliation ;
    private String project_affiliation ;

    public KnowledgeItem() {}

    /**
     * @return the knowledge_item_name
     */
    public String getName() {
        return name;
    }

    /**
     * @param knowledge_item_name the knowledge_item_name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the knowledge_item_creation_date
     */
    

    /**
     * @return the knowledge_item_file_size
     */
    public int getKnowledge_item_file_size() {
        return knowledge_item_file_size;
    }

    /**
     * @param knowledge_item_file_size the knowledge_item_file_size to set
     */
    public void setKnowledge_item_file_size(int knowledge_item_file_size) {
        this.knowledge_item_file_size = knowledge_item_file_size;
    }

    /**
     * @return the knowledge_item_keyword
     */
    public ArrayList<String> getKnowledge_item_keyword() {
        return knowledge_item_keyword;
    }

    /**
     * @param knowledge_item_keyword the knowledge_item_keyword to set
     */
    public void setKnowledge_item_keyword(ArrayList<String> knowledge_item_keyword) {
        this.knowledge_item_keyword = knowledge_item_keyword;
    }

    /**
     * @return the knowledge_item_author
     */
    public String getKnowledge_item_author() {
        return knowledge_item_author;
    }

    /**
     * @param knowledge_item_author the knowledge_item_author to set
     */
    public void setKnowledge_item_author(String knowledge_item_author) {
        this.knowledge_item_author = knowledge_item_author;
    }

    /**
     * @return the knowledge_item_composition_language
     */
    public String getKnowledge_item_composition_language() {
        return knowledge_item_composition_language;
    }

    /**
     * @param knowledge_item_composition_language the knowledge_item_composition_language to set
     */
    public void setKnowledge_item_composition_language(String knowledge_item_composition_language) {
        this.knowledge_item_composition_language = knowledge_item_composition_language;
    }

    /**
     * @return the knowledge_item_copyright_owner
     */
    public String getKnowledge_item_copyright_owner() {
        return knowledge_item_copyright_owner;
    }

    /**
     * @param knowledge_item_copyright_owner the knowledge_item_copyright_owner to set
     */
    public void setKnowledge_item_copyright_owner(String knowledge_item_copyright_owner) {
        this.knowledge_item_copyright_owner = knowledge_item_copyright_owner;
    }

    /**
     * @return the knowledge_item_destination
     */
    public String getKnowledge_item_destination() {
        return knowledge_item_destination;
    }

    /**
     * @param knowledge_item_destination the knowledge_item_destination to set
     */
    public void setKnowledge_item_destination(String knowledge_item_destination) {
        this.knowledge_item_destination = knowledge_item_destination;
    }

    /**
     * @return the knowledge_item_file_type
     */
    public String getKnowledge_item_file_type() {
        return knowledge_item_file_type;
    }

    /**
     * @param knowledge_item_file_type the knowledge_item_file_type to set
     */
    public void setKnowledge_item_file_type(String knowledge_item_file_type) {
        this.knowledge_item_file_type = knowledge_item_file_type;
    }

    /**
     * @return the knowledge_item_security_clearance
     */
    public String getKnowledge_item_security_clearance() {
        return knowledge_item_security_clearance;
    }

    /**
     * @param knowledge_item_security_clearance the knowledge_item_security_clearance to set
     */
    public void setKnowledge_item_security_clearance(String knowledge_item_security_clearance) {
        this.knowledge_item_security_clearance = knowledge_item_security_clearance;
    }

    /**
     * @return the knowledge_item_source
     */
    public String getKnowledge_item_source() {
        return knowledge_item_source;
    }

    /**
     * @param knowledge_item_source the knowledge_item_source to set
     */
    public void setKnowledge_item_source(String knowledge_item_source) {
        this.knowledge_item_source = knowledge_item_source;
    }

    /**
     * @return the knowledge_item_type
     */
    public String getKnowledge_item_type() {
        return knowledge_item_type;
    }

    /**
     * @param knowledge_item_type the knowledge_item_type to set
     */
    public void setKnowledge_item_type(String knowledge_item_type) {
        this.knowledge_item_type = knowledge_item_type;
    }

    /**
     * @return the knowledge_item_subject_domain
     */
    public String getSubject_domain() {
        return subject_domain;
    }

    /**
     * @param knowledge_item_subject_domain the knowledge_item_subject_domain to set
     */
    public void setSubject_domain(String subject_domain) {
        this.subject_domain = subject_domain;
    }

    /**
     * @return the event_affiliation
     */
    public String getEvent_affiliation() {
        return event_affiliation;
    }

    /**
     * @param event_affiliation the event_affiliation to set
     */
    public void setEvent_affiliation(String event_affiliation) {
        this.event_affiliation = event_affiliation;
    }

    /**
     * @return the geographic_affiliation
     */
    public String getGeographic_affiliation() {
        return geographic_affiliation;
    }

    /**
     * @param geographic_affiliation the geographic_affiliation to set
     */
    public void setGeographic_affiliation(String geographic_affiliation) {
        this.geographic_affiliation = geographic_affiliation;
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
     * @return the project_affiliation
     */
    public String getProject_affiliation() {
        return project_affiliation;
    }

    /**
     * @param project_affiliation the project_affiliation to set
     */
    public void setProject_affiliation(String project_affiliation) {
        this.project_affiliation = project_affiliation;
    }

    /**
     * @return the knowledge_item_creation_date
     */
    public XSDDateType getKnowledge_item_creation_date() {
        return knowledge_item_creation_date;
    }

    /**
     * @param knowledge_item_creation_date the knowledge_item_creation_date to set
     */
    public void setKnowledge_item_creation_date(XSDDateType knowledge_item_creation_date) {
        this.knowledge_item_creation_date = knowledge_item_creation_date;
    }

    /**
     * @return the knowledge_item_creation_time
     */
    public XSDTimeType getKnowledge_item_creation_time() {
        return knowledge_item_creation_time;
    }

    /**
     * @param knowledge_item_creation_time the knowledge_item_creation_time to set
     */
    public void setKnowledge_item_creation_time(XSDTimeType knowledge_item_creation_time) {
        this.knowledge_item_creation_time = knowledge_item_creation_time;
    }

   
}
