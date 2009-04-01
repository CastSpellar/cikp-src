package org.fct.unl.pt.cikp.data.portal;
// Generated 1/Abr/2009 0:12:44 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * FilePortal generated by hbm2java
 */
@Entity
@Table(name="file_portal"
    ,catalog="cikp"
)
public class FilePortal  implements java.io.Serializable {


     private Integer fileId;
     private byte[] file;
     private String fileName;
     private Set<KnowledgeItemPortal> knowledgeItemPortals = new HashSet<KnowledgeItemPortal>(0);

    public FilePortal() {
    }

	
    public FilePortal(byte[] file, String fileName) {
        this.file = file;
        this.fileName = fileName;
    }
    public FilePortal(byte[] file, String fileName, Set<KnowledgeItemPortal> knowledgeItemPortals) {
       this.file = file;
       this.fileName = fileName;
       this.knowledgeItemPortals = knowledgeItemPortals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="File_ID", unique=true, nullable=false)
    public Integer getFileId() {
        return this.fileId;
    }
    
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    
    @Column(name="File", nullable=false)
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }
    
    @Column(name="FileName", nullable=false)
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="filePortal")
    public Set<KnowledgeItemPortal> getKnowledgeItemPortals() {
        return this.knowledgeItemPortals;
    }
    
    public void setKnowledgeItemPortals(Set<KnowledgeItemPortal> knowledgeItemPortals) {
        this.knowledgeItemPortals = knowledgeItemPortals;
    }




}


