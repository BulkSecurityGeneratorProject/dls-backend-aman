/*********************************************
 ******** DOMAIN VALUES (APPL_EXPERIENCE) ****
 *********************************************
 *********************************************/

DELETE FROM SYS_DOMAIN_VALUE
 WHERE DOMAIN_ID = (SELECT ID FROM SYS_DOMAIN WHERE CODE = 'APPL_EXPERIENCE');

INSERT INTO SYS_DOMAIN_VALUE (ID,VALUE,DESCRIPTION,SORT_ORDER,DOMAIN_ID,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES(DOVA_SEQ.NEXTVAL,'LESS_THAN_TWO','{"ar":"اقل من سنتين","en":"Less than 2 years"}',1,(SELECT ID FROM SYS_DOMAIN WHERE CODE = 'APPL_EXPERIENCE'),'DLS_SYSTEM',SYSDATE,'DLS_SYSTEM',SYSDATE);

INSERT INTO SYS_DOMAIN_VALUE (ID,VALUE,DESCRIPTION,SORT_ORDER,DOMAIN_ID,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES(DOVA_SEQ.NEXTVAL,'BETWEEN_TWO_AND_FIVE','{"ar":"ما بين سنتين و خمس سنوات","en":"Between 2 and 5 years"}',2,(SELECT ID FROM SYS_DOMAIN WHERE CODE = 'APPL_EXPERIENCE'),'DLS_SYSTEM',SYSDATE,'DLS_SYSTEM',SYSDATE);

INSERT INTO SYS_DOMAIN_VALUE (ID,VALUE,DESCRIPTION,SORT_ORDER,DOMAIN_ID,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES(DOVA_SEQ.NEXTVAL,'MORE_THAN_FIVE','{"ar":"أكبر من 5 سنوات","en":"More than 5 years"}',3,(SELECT ID FROM SYS_DOMAIN WHERE CODE = 'APPL_EXPERIENCE'),'DLS_SYSTEM',SYSDATE,'DLS_SYSTEM',SYSDATE);