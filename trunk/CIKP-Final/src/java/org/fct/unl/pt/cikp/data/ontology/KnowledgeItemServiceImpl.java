package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType;
import com.hp.hpl.jena.datatypes.xsd.impl.XSDTimeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */

public class KnowledgeItemServiceImpl implements  KnowledgeItemService{

    private OntService ont ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem ki, PersistentOntology p) {
        try {
            OntService onts = getOnt();
            String kikey = ki.getName() + "_" + ki.getKnowledge_item_source();
            onts.createIndividual(ki.getKnowledge_item_type(), kikey, p);
            if(ki.getKnowledge_item_author() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Author", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Author", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Author", kikey, (ki.getKnowledge_item_author() == null ? "" : ki.getKnowledge_item_author()), p);
            }
            if(ki.getKnowledge_item_composition_language() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, (ki.getKnowledge_item_composition_language() == null ? "" : ki.getKnowledge_item_author()), p);
            }
            if(ki.getKnowledge_item_copyright_owner() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Copyright_Owner", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Copyright_Owner", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Copyright_Owner", kikey, (ki.getKnowledge_item_copyright_owner() == null ? "" : ki.getKnowledge_item_copyright_owner()), p);
            }
            if(ki.getKnowledge_item_creation_date() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Creation_Date", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Creation_Date", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Creation_Date", kikey, (ki.getKnowledge_item_creation_date() == null ? "" : ki.getKnowledge_item_creation_date()), p);
            }
            if(ki.getKnowledge_item_creation_time() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Creation_Time", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Creation_Time", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Creation_Time", kikey, (ki.getKnowledge_item_creation_time() == null ? "" : ki.getKnowledge_item_creation_time()), p);
            }
            if(ki.getKnowledge_item_destination() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Destination", kikey, (ki.getKnowledge_item_destination() == null ? "" : ki.getKnowledge_item_destination()), p);
            }
            if(Integer.toString(ki.getKnowledge_item_file_size()) != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_File_Size", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_File_Size", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_File_Size", kikey, ki.getKnowledge_item_file_size(), p);
            }
            if(ki.getKnowledge_item_file_type() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_File_Type", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_File_Type", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_File_Type", kikey, (ki.getKnowledge_item_file_type() == null ? "" : ki.getKnowledge_item_file_type()), p);
            }
            if (!ki.getKnowledge_item_keyword().isEmpty()) {
                Iterator iter = ki.getKnowledge_item_keyword().iterator();
                while (iter.hasNext()) {
                    onts.addLiteralByProperty("has_Knowledge_Item_Keyword", kikey, iter.next(), p);
                }
            }
            if(ki.getName() != null) {
                onts.removeLiteralByProperty("has_Name", kikey, p, onts.getLiteralByProperty("has_Name", kikey, p)) ;
                onts.addLiteralByProperty("has_Name", kikey, ki.getName(), p);
            }
            if(ki.getKnowledge_item_security_clearance() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Security_Clearance", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Security_Clearance", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Security_Clearance", kikey, (ki.getKnowledge_item_security_clearance() == null ? "" : ki.getKnowledge_item_security_clearance()), p);
            }
            if(ki.getKnowledge_item_source() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Source", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Source", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Source", kikey, (ki.getKnowledge_item_source() == null ? "" : ki.getKnowledge_item_source()), p);
            }
            if(ki.getSubject_domain() != null) {
                onts.removeLiteralByProperty("has_Subject_Domain", kikey, p, onts.getLiteralByProperty("has_Subject_Domain", kikey, p)) ;
                onts.addLiteralByProperty("has_Subject_Domain", kikey, (ki.getSubject_domain() == null ? "" : ki.getSubject_domain()), p);
            }
            if(ki.getKnowledge_item_type() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Type", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Type", kikey, p)) ;
                onts.addLiteralByProperty("has_Knowledge_Item_Type", kikey, (ki.getKnowledge_item_type() == null ? "" : ki.getKnowledge_item_type()), p);
            }
            if(ki.getEvent_affiliation() != null) {
                onts.removeLiteralByProperty("has_Event_Affiliation", kikey, p, onts.getLiteralByProperty("has_Event_Affiliation", kikey, p)) ;
                onts.addLiteralByProperty("has_Event_Affiliation", kikey, (ki.getEvent_affiliation() == null ? "" : ki.getEvent_affiliation()), p);
            }
            if(ki.getGeographic_affiliation()!= null) {
                onts.removeLiteralByProperty("has_Geographic_Affiliation", kikey, p, onts.getLiteralByProperty("has_Geographic_Affiliation", kikey, p)) ;
                onts.addLiteralByProperty("has_Geographic_Affiliation", kikey, (ki.getGeographic_affiliation() == null ? "" : ki.getGeographic_affiliation()), p);
            }
            if(ki.getProduct_affiliation() != null) {
                onts.removeLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p, onts.getLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, p)) ;
                onts.addLiteralByProperty("has_Product_Affiliation", kikey, (ki.getProduct_affiliation() == null ? "" : ki.getProduct_affiliation()), p);
            }
            if(ki.getProject_affiliation() != null) {
                onts.removeLiteralByProperty("has_Project_Affiliation", kikey, p, onts.getLiteralByProperty("has_Project_Affiliation", kikey, p)) ;
                onts.addLiteralByProperty("has_Project_Affiliation", kikey, (ki.getProject_affiliation() == null ? "" : ki.getProject_affiliation()), p);
            }
            return ki;
        } catch (IOException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    public KnowledgeItem getKnowledgeItem(String entityname, PersistentOntology p) {
        OntService onts = getOnt() ;
        KnowledgeItem item = new KnowledgeItem() ;
        try {
            if(onts.getIndividual(entityname, p) != null) {
                item.setEvent_affiliation((String) onts.getLiteralByProperty(entityname, "has_Event_Affiliation", p));
                item.setGeographic_affiliation((String)onts.getLiteralByProperty(entityname, "has_Geographic_Affiliation", p));
                item.setKnowledge_item_author((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Author", p));
                item.setKnowledge_item_composition_language((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Composition_Language", p));
                item.setKnowledge_item_copyright_owner((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Copyright_Owner", p));
                item.setKnowledge_item_creation_date((XSDDateType)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Creation_Date", p));
                item.setKnowledge_item_creation_time((XSDTimeType)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Creation_Time", p));
                item.setKnowledge_item_destination((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Destination", p));
                item.setKnowledge_item_file_size((Integer)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_File_Size", p));
                item.setKnowledge_item_file_type((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_File_Type", p));
                ArrayList<String> list = new ArrayList<String>() ;
                while(onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Keyword", p) != null) {
                    list.add((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Keyword", p));
                }
                item.setKnowledge_item_keyword(list);
                item.setKnowledge_item_security_clearance((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Security_Clearance", p));
                item.setKnowledge_item_source((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Source", p));
                item.setKnowledge_item_type((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Type", p));
                item.setName((String)onts.getLiteralByProperty(entityname, "has_Name", p));
                item.setProduct_affiliation((String)onts.getLiteralByProperty(entityname, "has_Product_Affiliation", p));
                item.setProject_affiliation((String)onts.getLiteralByProperty(entityname, "has_Project_Affiliation", p));
                item.setSubject_domain((String)onts.getLiteralByProperty(entityname, "has_Subject_Domain", p));
                return item ;
            }
            else return null ;
        } catch (IOException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        }
        
    }

    /**
     * @return the ont
     */
    public OntService getOnt() {
        return new OntServiceImpl() ;
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntService ont) {
        this.ont = ont;
    }
}
