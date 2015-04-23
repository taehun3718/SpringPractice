계정	:	BOARDSCHEME
비번	:	3278
<ENCODING : MS949>
ALTER TABLE BOARDSCHEME.BOARD
 DROP PRIMARY KEY CASCADE;

DROP TABLE BOARDSCHEME.BOARD CASCADE CONSTRAINTS;

CREATE TABLE BOARDSCHEME.BOARD
(
  ID           INTEGER                          NOT NULL,
  SUBJECT      VARCHAR2(200 BYTE)               NOT NULL,
  CONTENT      VARCHAR2(4000 BYTE)              NOT NULL,
  UPLOAD_FILE  VARCHAR2(500 BYTE)               NOT NULL
)
TABLESPACE SYSTEM
RESULT_CACHE (MODE DEFAULT)
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX BOARDSCHEME.BOARD_PK ON BOARDSCHEME.BOARD
(ID)
LOGGING
TABLESPACE SYSTEM
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MAXSIZE          UNLIMITED
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOPARALLEL;

ALTER TABLE BOARDSCHEME.BOARD ADD (
  CONSTRAINT BOARD_PK
  PRIMARY KEY
  (ID)
  USING INDEX BOARDSCHEME.BOARD_PK
  ENABLE VALIDATE);