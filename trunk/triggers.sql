delimiter //
CREATE TRIGGER cikp.subscription_updatefiles AFTER INSERT ON cikp.subscription_portal
FOR EACH ROW
BEGIN
  SELECT  knowledge_item_portal.Knowledge_Item_ID INTO @ki_id FROM knowledge_item_portal
  WHERE COALESCE(knowledge_item_portal.Name, '') = COALESCE(NEW.Knowledge_Item_File_Name, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Author, '') = COALESCE(NEW.Knowledge_Item_Author, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Composition_Language, '') = COALESCE(NEW.Knowledge_Item_Composition_Language, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Copyright_Owner, '') = COALESCE(NEW.Knowledge_Item_Copyright_Owner, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Destination, '') = COALESCE(NEW.Knowledge_Item_Destination, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_File_Type, '') = COALESCE(NEW.Knowledge_Item_File_Type, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Security_Clearance, '') = COALESCE(NEW.Knowledge_Item_Security_Clearance, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Source, '') = COALESCE(NEW.Knowledge_Item_Source, '') AND
        COALESCE(knowledge_item_portal.Knowledge_Item_Type, '') = COALESCE(NEW.Knowledge_Item_Type, '') AND
        COALESCE(knowledge_item_portal.Subject_Domain, '') = COALESCE(NEW.Subject_Domain, '');
  IF(@ki_id IS NOT NULL) THEN
    INSERT INTO cikp.knowledge_item_subscription_portal(Knowledge_Item_ID, Subscription_ID)
    VALUES(@ki_id, New.Subscription_ID);
  END IF;
END//
delimiter;

  /*IF(@ki_id IS NOT NULL) THEN
    INSERT INTO cikp.knowledge_item_subscription_portal(Knowledge_Item_ID, Subscription_ID)
    VALUES(@ki_id, New.Subscription_ID)
  END IF;*/