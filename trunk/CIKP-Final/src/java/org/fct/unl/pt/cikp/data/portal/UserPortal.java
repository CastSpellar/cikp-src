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
 * UserPortal generated by hbm2java
 */
@Entity
@Table(name="user_portal"
    ,catalog="cikp"
)
public class UserPortal  implements java.io.Serializable {


     private Integer userId;
     private String userFirstname;
     private String userLastname;
     private String userCompany;
     private String userTelephone;
     private String userEmail;
     private String userUsername;
     private String userPassword;
     private String userUri;
     private boolean userOrganization;
     private Set<KnowledgeItemPortal> knowledgeItemPortals = new HashSet<KnowledgeItemPortal>(0);
     private Set<SubscriptionPortal> subscriptionPortals = new HashSet<SubscriptionPortal>(0);

    public UserPortal() {
    }

	
    public UserPortal(String userFirstname, String userLastname, String userCompany, String userTelephone, String userEmail, String userUsername, String userPassword, boolean userOrganization) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userCompany = userCompany;
        this.userTelephone = userTelephone;
        this.userEmail = userEmail;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userOrganization = userOrganization;
    }
    public UserPortal(String userFirstname, String userLastname, String userCompany, String userTelephone, String userEmail, String userUsername, String userPassword, String userUri, boolean userOrganization, Set<KnowledgeItemPortal> knowledgeItemPortals, Set<SubscriptionPortal> subscriptionPortals) {
       this.userFirstname = userFirstname;
       this.userLastname = userLastname;
       this.userCompany = userCompany;
       this.userTelephone = userTelephone;
       this.userEmail = userEmail;
       this.userUsername = userUsername;
       this.userPassword = userPassword;
       this.userUri = userUri;
       this.userOrganization = userOrganization;
       this.knowledgeItemPortals = knowledgeItemPortals;
       this.subscriptionPortals = subscriptionPortals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="user_id", unique=true, nullable=false)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @Column(name="user_firstname", nullable=false, length=50)
    public String getUserFirstname() {
        return this.userFirstname;
    }
    
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }
    
    @Column(name="user_lastname", nullable=false, length=50)
    public String getUserLastname() {
        return this.userLastname;
    }
    
    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }
    
    @Column(name="user_company", nullable=false, length=50)
    public String getUserCompany() {
        return this.userCompany;
    }
    
    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }
    
    @Column(name="user_telephone", nullable=false, length=50)
    public String getUserTelephone() {
        return this.userTelephone;
    }
    
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
    
    @Column(name="user_email", nullable=false, length=50)
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    @Column(name="user_username", nullable=false, length=20)
    public String getUserUsername() {
        return this.userUsername;
    }
    
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
    
    @Column(name="user_password", nullable=false, length=50)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="user_uri", length=50)
    public String getUserUri() {
        return this.userUri;
    }
    
    public void setUserUri(String userUri) {
        this.userUri = userUri;
    }
    
    @Column(name="user_organization", nullable=false)
    public boolean isUserOrganization() {
        return this.userOrganization;
    }
    
    public void setUserOrganization(boolean userOrganization) {
        this.userOrganization = userOrganization;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userPortal")
    public Set<KnowledgeItemPortal> getKnowledgeItemPortals() {
        return this.knowledgeItemPortals;
    }
    
    public void setKnowledgeItemPortals(Set<KnowledgeItemPortal> knowledgeItemPortals) {
        this.knowledgeItemPortals = knowledgeItemPortals;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userPortal")
    public Set<SubscriptionPortal> getSubscriptionPortals() {
        return this.subscriptionPortals;
    }
    
    public void setSubscriptionPortals(Set<SubscriptionPortal> subscriptionPortals) {
        this.subscriptionPortals = subscriptionPortals;
    }




}


