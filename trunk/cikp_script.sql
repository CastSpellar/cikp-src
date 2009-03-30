DROP TABLE IF EXISTS `cikp`.`knowledge_item_keyword_portal`;
DROP TABLE IF EXISTS `cikp`.`keyword_portal`;
DROP TABLE IF EXISTS `cikp`.`knowledge_item_subscription_portal`;
DROP TABLE IF EXISTS `cikp`.`knowledge_item_portal`;
DROP TABLE IF EXISTS `cikp`.`file_portal`;
DROP TABLE IF EXISTS `cikp`.`subscription_portal`;
DROP TABLE IF EXISTS `cikp`.`user_portal`;
DROP TABLE IF EXISTS `cikp`.`ontology_controls_portal`;

CREATE TABLE  `cikp`.`user_portal` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_firstname` varchar(50) NOT NULL,
  `user_lastname` varchar(50) NOT NULL,
  `user_company` varchar(50) NOT NULL,
  `user_telephone` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_username` varchar(20) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_uri` varchar(50) DEFAULT NULL,
  `user_organization` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
                                              
CREATE TABLE  `cikp`.`file_portal` (
  `File_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `File` blob NOT NULL,
  `FileName` varchar(255) NOT NULL,
  PRIMARY KEY (`File_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`keyword_portal` (
  `Keyword_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Keyword` varchar(100) NOT NULL,
  PRIMARY KEY (`Keyword_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`knowledge_item_portal` (
  `Knowledge_Item_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Knowledge_Item_File_Size` int(10) unsigned NOT NULL,
  `Knowledge_Item_Creation_Time` time NOT NULL,
  `Knowledge_Item_Creation_Date` date NOT NULL,
  `Knowledge_Item_Author` varchar(20) NOT NULL,
  `Knowledge_Item_Composition_Language` varchar(20) DEFAULT NULL,
  `Knowledge_Item_Copyright_Owner` varchar(200) DEFAULT NULL,
  `Knowledge_Item_Destination` varchar(100) DEFAULT NULL,
  `Knowledge_Item_File_Type` varchar(50) NOT NULL,
  `Knowledge_Item_Security_Clearance` varchar(100) DEFAULT NULL,
  `Knowledge_Item_Source` varchar(20) DEFAULT NULL,
  `Knowledge_Item_Type` varchar(100) NOT NULL,
  `Subject_Domain` varchar(100) DEFAULT NULL,
  `File_ID` int(10) unsigned NOT NULL,
  `User_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Knowledge_Item_ID`) USING BTREE,
  KEY `FK_Knowledge_item_File` (`File_ID`),
  KEY `FK_Knowledge_item_User` (`User_ID`),
  CONSTRAINT `FK_Knowledge_item_File` FOREIGN KEY (`File_ID`) REFERENCES `file_portal` (`File_ID`),
  CONSTRAINT `FK_Knowledge_item_User` FOREIGN KEY (`User_ID`) REFERENCES `user_portal` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`knowledge_item_keyword_portal` (
  `Knowledge_Item_ID` int(10) unsigned NOT NULL,
  `Keyword_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Knowledge_Item_ID`,`Keyword_ID`),
  KEY `FK_Knowledge_Item_Keyword_Keyword` (`Keyword_ID`),
  KEY `FK_Knowledge_Item_Keyword_Knowledge_Item` (`Knowledge_Item_ID`),
  CONSTRAINT `FK_Knowledge_Item_Keyword_Keyword` FOREIGN KEY (`Keyword_ID`) REFERENCES `keyword_portal` (`Keyword_ID`),
  CONSTRAINT `FK_Knowledge_Item_Keyword_Knowledge_Item` FOREIGN KEY (`Knowledge_Item_ID`) REFERENCES `knowledge_item_portal` (`Knowledge_Item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`subscription_portal` (
  `Subscription_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Knowledge_Item_File_Size` int(10) unsigned DEFAULT NULL,
  `Knowledge_Item_Creation_Time` time DEFAULT NULL,
  `Knowledge_Item_Creation_Date` date DEFAULT NULL,
  `Knowledge_Item_Author` varchar(200) DEFAULT NULL,
  `Knowledge_Item_Composition_Language` varchar(100) DEFAULT NULL,
  `Knowledge_Item_Copyright_Owner` varchar(200) DEFAULT NULL,
  `Knowledge_Item_Destination` varchar(100) DEFAULT NULL,
  `Knowledge_Item_File_Type` varchar(50) DEFAULT NULL,
  `Knowledge_Item_Security_Clearance` varchar(100) DEFAULT NULL,
  `Knowledge_Item_Source` varchar(20) DEFAULT NULL,
  `Knowledge_Item_Type` varchar(100) DEFAULT NULL,
  `Subject_Domain` varchar(100) DEFAULT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Subscription_ID`),
  KEY `FK_subscription_portal_user` (`user_id`),
  CONSTRAINT `FK_subscription_portal_user` FOREIGN KEY (`user_id`) REFERENCES `user_portal` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`ontology_controls_portal` (
  `Ontology_Controls_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Control_Type` varchar(45) NOT NULL,
  `Control_Id` varchar(100) NOT NULL,
  `Property_Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Ontology_Controls_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE  `cikp`.`knowledge_item_subscription_portal` (
  `Knowledge_Item_ID` int(10) unsigned NOT NULL,
  `Subscription_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Knowledge_Item_ID`,`Subscription_ID`),
  KEY `FK_knowledge_item_subscription_portal_subscription` (`Subscription_ID`),
  CONSTRAINT `FK_knowledge_item_subscription_portal_knowledge_item` FOREIGN KEY (`Knowledge_Item_ID`) REFERENCES `knowledge_item_portal` (`Knowledge_Item_ID`),
  CONSTRAINT `FK_knowledge_item_subscription_portal_subscription` FOREIGN KEY (`Subscription_ID`) REFERENCES `subscription_portal` (`Subscription_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;