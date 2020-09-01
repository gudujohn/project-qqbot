create table T_MESSAGE
(
  ID          NUMBER(9) not null,
  VERSION     NUMBER(9) not null,
  TYPE        NUMBER(5),
  DESTINATION VARCHAR2(4000),
  CONTENT     VARCHAR2(4000),
  STATUS      NUMBER(3),
  CREATEDATE  DATE,
  FINISHDATE  DATE
);
comment on table T_MESSAGE is '发送的消息表';
comment on column T_MESSAGE.TYPE is '消息类型，1 qq消息；2 短信';
comment on column T_MESSAGE.DESTINATION is '发送目的地';
comment on column T_MESSAGE.CONTENT is '内容';
comment on column T_MESSAGE.STATUS is '状态 1 未发送；2 发送中；3 发送成功；4 发送失败';
comment on column T_MESSAGE.CREATEDATE is '创建时间';
comment on column T_MESSAGE.FINISHDATE is '发送时间';

create sequence SEQ_T_MESSAGE minvalue 1 maxvalue 99999999999 start with 778885 increment by 1 cache 10;