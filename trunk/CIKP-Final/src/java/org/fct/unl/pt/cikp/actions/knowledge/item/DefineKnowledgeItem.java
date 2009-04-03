/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.knowledge.item;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.portal.FilePortal;
import org.fct.unl.pt.cikp.data.portal.KeywordPortal;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;
import org.fct.unl.pt.cikp.utils.FileUtils;

/**
 *
 * @author Figueiras
 */
public class DefineKnowledgeItem extends ActionSupport implements SessionAware, ModelDriven<KnowledgeItem>, ApplicationAware {

    private Map appVars ;

    private CikpService cikpService ;

    private String uploadFileName ;
    private File upload ;
    private KnowledgeItem knowledge_item = new KnowledgeItem() ;

    private Map session ;

    @Override
    public String execute() throws Exception {
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        }else {
            po.reopenCon();
        }
        setKiSource() ;
        setKiName();
        getCikpService().createKnowledgeItem(knowledge_item, po) ;
        FilePortal fp = createFilePortal() ;
        KnowledgeItemPortal kip = createKiObj(fp) ;
        getCikpService().createKnowledgeItemPortal(kip) ;
        return SUCCESS ;
    }

    private void setKiSource() {
        UserPortal u = (UserPortal) session.get(Constants.USER) ;
        knowledge_item.setKnowledge_item_source(u.getUserUsername()) ;
    }

    private void setKiName() {
        knowledge_item.setName(this.uploadFileName) ;
    }

    private FilePortal createFilePortal() {
        FilePortal fp = new FilePortal() ;
        fp.setFileName(getUploadFileName()) ;
        fp.setFile(FileUtils.getBytesFromFile(getUpload())) ;
        return fp ;
    }

    private KnowledgeItemPortal createKiObj(FilePortal fp) {
        UserPortal user = (UserPortal) session.get(Constants.USER) ;
        KnowledgeItemPortal kip = new KnowledgeItemPortal() ;
        kip.setUserPortal(user) ;
        kip.setName(knowledge_item.getName()) ;
        kip.setKnowledgeItemSource(knowledge_item.getKnowledge_item_source()) ;
        kip.setKnowledgeItemType(knowledge_item.getKnowledge_item_type()) ;
        kip.setKnowledgeItemFileType(knowledge_item.getKnowledge_item_file_type()) ;
        kip.setSubjectDomain(knowledge_item.getSubject_domain()) ;
        Set<KeywordPortal> keyWords = new HashSet<KeywordPortal>(0) ;
        for(String keyword: knowledge_item.getKnowledge_item_keyword()) {
            KeywordPortal k = new KeywordPortal() ;
            k.setKeyword(keyword) ;
            keyWords.add(k) ;
        }
        kip.setKeywordPortals(keyWords) ;
        kip.setFilePortal(fp);
        kip.setKnowledgeItemAuthor(kip.getKnowledgeItemSource()) ;
        Date today = new Date() ;
        kip.setKnowledgeItemCreationDate(today);
        kip.setKnowledgeItemCreationTime(today);
        return kip ;
    }

    public void setSession(Map arg0) {
        this.session = arg0;
    }

    /**
     * @return the cikpService
     */
    public CikpService getCikpService() {
        return new CikpServiceImpl();
    }

    /**
     * @param cikpService the cikpService to set
     */
    public void setCikpService(CikpService cikpService) {
        this.cikpService = cikpService;
    }

    /**
     * @return the uploadFileName
     */
    public String getUploadFileName() {
        return uploadFileName;
    }

    /**
     * @param uploadFileName the uploadFileName to set
     */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    /**
     * @return the file
     */
    public File getUpload() {
        return upload;
    }

    /**
     * @param file the file to set
     */
    public void setUpload(File file) {
        this.upload = file;
    }

    public KnowledgeItem getModel() {
        return knowledge_item ;
    }

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }
}
