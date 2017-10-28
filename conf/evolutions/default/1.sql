# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ac_detail (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  type                          integer,
  aircosaver                    integer,
  vrvvrf                        integer,
  deleted                       boolean default false not null,
  constraint pk_ac_detail primary key (id)
);

create table area (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  witel_id                      bigint,
  deleted                       boolean default false not null,
  constraint pk_area primary key (id)
);

create table asset (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  function                      varchar(255),
  capacity                      float,
  unit                          varchar(255),
  merk                          varchar(255),
  type                          varchar(255),
  series                        varchar(255),
  quantity                      integer,
  unit_price                    float,
  performance                   float,
  installation_date             timestamptz,
  used_year                     integer,
  guarantee_number              varchar(255),
  guarantee_period              timestamptz,
  guarantee_expire_date         timestamptz,
  status_asset                  integer,
  description                   varchar(255),
  asset_type_id                 bigint,
  vendor_id                     bigint,
  location_id                   bigint,
  deleted                       boolean default false not null,
  constraint pk_asset primary key (id)
);

create table asset_type (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  deleted                       boolean default false not null,
  constraint pk_asset_type primary key (id)
);

create table device (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  status                        integer,
  witel_id                      bigint,
  electricity_pam_id            bigint,
  deleted                       boolean default false not null,
  constraint uq_device_electricity_pam_id unique (electricity_pam_id),
  constraint pk_device primary key (id)
);

create table electricity_pam (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  address                       varchar(255),
  status                        integer,
  deleted                       boolean default false not null,
  constraint pk_electricity_pam primary key (id)
);

create table electricity_pam_detail (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  period                        timestamptz,
  rate                          varchar(255),
  power                         float,
  start_total                   float,
  end_total                     float,
  used                          float,
  price                         float,
  electricity_pam_id            bigint,
  deleted                       boolean default false not null,
  constraint pk_electricity_pam_detail primary key (id)
);

create table employee (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  deleted                       boolean default false not null,
  constraint pk_employee primary key (id)
);

create table fm_gsd (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  contact                       varchar(255),
  office_address                varchar(255),
  operation_manager             varchar(255),
  contact_operation_manager     varchar(255),
  deleted                       boolean default false not null,
  constraint pk_fm_gsd primary key (id)
);

create table fuel (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  capacity                      float,
  stock                         float,
  status                        varchar(255),
  deleted                       boolean default false not null,
  constraint pk_fuel primary key (id)
);

create table location (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  floor                         integer not null,
  room_name                     varchar(255),
  office_id                     bigint,
  deleted                       boolean default false not null,
  constraint pk_location primary key (id)
);

create table maintenance (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  maintenance_contract_url      varchar(255),
  start_contract                timestamptz,
  end_contract                  timestamptz,
  asset_id                      bigint,
  deleted                       boolean default false not null,
  constraint pk_maintenance primary key (id)
);

create table maintenance_detail (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  maintenance_date              timestamptz,
  maintenance_document_url      varchar(255),
  maintenance_report            varchar(255),
  status_asset                  integer,
  maintenance_id                bigint,
  deleted                       boolean default false not null,
  constraint pk_maintenance_detail primary key (id)
);

create table menu (
  id                            varchar(255) not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  title                         varchar(255),
  link                          varchar(255),
  url                           varchar(255),
  icon                          varchar(255),
  is_home                       boolean default false not null,
  is_group                      boolean default false not null,
  parent                        integer not null,
  deleted                       boolean default false not null,
  constraint pk_menu primary key (id)
);

create table office (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  address                       varchar(255),
  phone_number                  varchar(255),
  witel_id                      bigint,
  electricity_id                bigint,
  pam_id                        bigint,
  deleted                       boolean default false not null,
  constraint uq_office_electricity_id unique (electricity_id),
  constraint uq_office_pam_id unique (pam_id),
  constraint pk_office primary key (id)
);

create table progress_detail (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  survey_location               varchar(255),
  reoffering                    boolean default false not null,
  reoffering_document_url       varchar(255),
  reoffering_date               timestamptz,
  reoffering_price              float,
  budget_type                   integer,
  progress_status               varchar(255),
  deleted                       boolean default false not null,
  constraint pk_progress_detail primary key (id)
);

create table fam_evaluation (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  fam_evaluation                boolean default false not null,
  fam_evaluation_document_url   varchar(255),
  fam_evaluation_price          float,
  progress_detail_id            bigint,
  deleted                       boolean default false not null,
  constraint pk_fam_evaluation primary key (id)
);

create table role (
  created_at                    timestamptz,
  updated_at                    timestamptz,
  deleted                       boolean default false not null
);

create table spb (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  document_url                  varchar(255),
  status                        varchar(255),
  spkpr_id                      bigint,
  deleted                       boolean default false not null,
  constraint pk_spb primary key (id)
);

create table spk_pr (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  tor_url                       varchar(255),
  justification_url             varchar(255),
  document_url                  varchar(255),
  number                        varchar(255),
  document_date                 timestamptz,
  status                        varchar(255),
  type                          integer,
  rab_id                        bigint,
  deleted                       boolean default false not null,
  constraint pk_spk_pr primary key (id)
);

create table status_asset_detail (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  repairing_type                varchar(255),
  repairing_date                timestamptz,
  offering_price                float,
  offering_document_url         varchar(255),
  witel_id                      bigint,
  vendor_id                     bigint,
  deleted                       boolean default false not null,
  constraint pk_status_asset_detail primary key (id)
);

create table survey_location (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  survey_date                   timestamptz,
  survey_report                 varchar(255),
  survey_report_document_url    varchar(255),
  progress_detail_id            bigint,
  deleted                       boolean default false not null,
  constraint pk_survey_location primary key (id)
);

create table treg (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  deleted                       boolean default false not null,
  constraint pk_treg primary key (id)
);

create table vendor (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  vendor_pic                    varchar(255),
  contact_vendor_pic            varchar(255),
  address                       varchar(255),
  deleted                       boolean default false not null,
  constraint pk_vendor primary key (id)
);

create table witel (
  id                            bigserial not null,
  created_at                    timestamptz,
  updated_at                    timestamptz,
  name                          varchar(255),
  gm_witel                      varchar(255),
  contact_gm_witel              varchar(255),
  manager_logistic              varchar(255),
  contact_manager_logistic      varchar(255),
  treg_id                       bigint,
  fm_gsd_id                     bigint,
  deleted                       boolean default false not null,
  constraint pk_witel primary key (id)
);

alter table area add constraint fk_area_witel_id foreign key (witel_id) references witel (id) on delete restrict on update restrict;
create index ix_area_witel_id on area (witel_id);

alter table asset add constraint fk_asset_asset_type_id foreign key (asset_type_id) references asset_type (id) on delete restrict on update restrict;
create index ix_asset_asset_type_id on asset (asset_type_id);

alter table asset add constraint fk_asset_vendor_id foreign key (vendor_id) references vendor (id) on delete restrict on update restrict;
create index ix_asset_vendor_id on asset (vendor_id);

alter table asset add constraint fk_asset_location_id foreign key (location_id) references location (id) on delete restrict on update restrict;
create index ix_asset_location_id on asset (location_id);

alter table device add constraint fk_device_witel_id foreign key (witel_id) references witel (id) on delete restrict on update restrict;
create index ix_device_witel_id on device (witel_id);

alter table device add constraint fk_device_electricity_pam_id foreign key (electricity_pam_id) references electricity_pam (id) on delete restrict on update restrict;

alter table electricity_pam_detail add constraint fk_electricity_pam_detail_electricity_pam_id foreign key (electricity_pam_id) references electricity_pam (id) on delete restrict on update restrict;
create index ix_electricity_pam_detail_electricity_pam_id on electricity_pam_detail (electricity_pam_id);

alter table location add constraint fk_location_office_id foreign key (office_id) references office (id) on delete restrict on update restrict;
create index ix_location_office_id on location (office_id);

alter table maintenance add constraint fk_maintenance_asset_id foreign key (asset_id) references asset (id) on delete restrict on update restrict;
create index ix_maintenance_asset_id on maintenance (asset_id);

alter table maintenance_detail add constraint fk_maintenance_detail_maintenance_id foreign key (maintenance_id) references maintenance (id) on delete restrict on update restrict;
create index ix_maintenance_detail_maintenance_id on maintenance_detail (maintenance_id);

alter table office add constraint fk_office_witel_id foreign key (witel_id) references witel (id) on delete restrict on update restrict;
create index ix_office_witel_id on office (witel_id);

alter table office add constraint fk_office_electricity_id foreign key (electricity_id) references electricity_pam (id) on delete restrict on update restrict;

alter table office add constraint fk_office_pam_id foreign key (pam_id) references electricity_pam (id) on delete restrict on update restrict;

alter table fam_evaluation add constraint fk_fam_evaluation_progress_detail_id foreign key (progress_detail_id) references progress_detail (id) on delete restrict on update restrict;
create index ix_fam_evaluation_progress_detail_id on fam_evaluation (progress_detail_id);

alter table spb add constraint fk_spb_spkpr_id foreign key (spkpr_id) references spk_pr (id) on delete restrict on update restrict;
create index ix_spb_spkpr_id on spb (spkpr_id);

alter table spk_pr add constraint fk_spk_pr_rab_id foreign key (rab_id) references fam_evaluation (id) on delete restrict on update restrict;
create index ix_spk_pr_rab_id on spk_pr (rab_id);

alter table status_asset_detail add constraint fk_status_asset_detail_witel_id foreign key (witel_id) references witel (id) on delete restrict on update restrict;
create index ix_status_asset_detail_witel_id on status_asset_detail (witel_id);

alter table status_asset_detail add constraint fk_status_asset_detail_vendor_id foreign key (vendor_id) references vendor (id) on delete restrict on update restrict;
create index ix_status_asset_detail_vendor_id on status_asset_detail (vendor_id);

alter table survey_location add constraint fk_survey_location_progress_detail_id foreign key (progress_detail_id) references progress_detail (id) on delete restrict on update restrict;
create index ix_survey_location_progress_detail_id on survey_location (progress_detail_id);

alter table witel add constraint fk_witel_treg_id foreign key (treg_id) references treg (id) on delete restrict on update restrict;
create index ix_witel_treg_id on witel (treg_id);

alter table witel add constraint fk_witel_fm_gsd_id foreign key (fm_gsd_id) references fm_gsd (id) on delete restrict on update restrict;
create index ix_witel_fm_gsd_id on witel (fm_gsd_id);


# --- !Downs

alter table if exists area drop constraint if exists fk_area_witel_id;
drop index if exists ix_area_witel_id;

alter table if exists asset drop constraint if exists fk_asset_asset_type_id;
drop index if exists ix_asset_asset_type_id;

alter table if exists asset drop constraint if exists fk_asset_vendor_id;
drop index if exists ix_asset_vendor_id;

alter table if exists asset drop constraint if exists fk_asset_location_id;
drop index if exists ix_asset_location_id;

alter table if exists device drop constraint if exists fk_device_witel_id;
drop index if exists ix_device_witel_id;

alter table if exists device drop constraint if exists fk_device_electricity_pam_id;

alter table if exists electricity_pam_detail drop constraint if exists fk_electricity_pam_detail_electricity_pam_id;
drop index if exists ix_electricity_pam_detail_electricity_pam_id;

alter table if exists location drop constraint if exists fk_location_office_id;
drop index if exists ix_location_office_id;

alter table if exists maintenance drop constraint if exists fk_maintenance_asset_id;
drop index if exists ix_maintenance_asset_id;

alter table if exists maintenance_detail drop constraint if exists fk_maintenance_detail_maintenance_id;
drop index if exists ix_maintenance_detail_maintenance_id;

alter table if exists office drop constraint if exists fk_office_witel_id;
drop index if exists ix_office_witel_id;

alter table if exists office drop constraint if exists fk_office_electricity_id;

alter table if exists office drop constraint if exists fk_office_pam_id;

alter table if exists fam_evaluation drop constraint if exists fk_fam_evaluation_progress_detail_id;
drop index if exists ix_fam_evaluation_progress_detail_id;

alter table if exists spb drop constraint if exists fk_spb_spkpr_id;
drop index if exists ix_spb_spkpr_id;

alter table if exists spk_pr drop constraint if exists fk_spk_pr_rab_id;
drop index if exists ix_spk_pr_rab_id;

alter table if exists status_asset_detail drop constraint if exists fk_status_asset_detail_witel_id;
drop index if exists ix_status_asset_detail_witel_id;

alter table if exists status_asset_detail drop constraint if exists fk_status_asset_detail_vendor_id;
drop index if exists ix_status_asset_detail_vendor_id;

alter table if exists survey_location drop constraint if exists fk_survey_location_progress_detail_id;
drop index if exists ix_survey_location_progress_detail_id;

alter table if exists witel drop constraint if exists fk_witel_treg_id;
drop index if exists ix_witel_treg_id;

alter table if exists witel drop constraint if exists fk_witel_fm_gsd_id;
drop index if exists ix_witel_fm_gsd_id;

drop table if exists ac_detail cascade;

drop table if exists area cascade;

drop table if exists asset cascade;

drop table if exists asset_type cascade;

drop table if exists device cascade;

drop table if exists electricity_pam cascade;

drop table if exists electricity_pam_detail cascade;

drop table if exists employee cascade;

drop table if exists fm_gsd cascade;

drop table if exists fuel cascade;

drop table if exists location cascade;

drop table if exists maintenance cascade;

drop table if exists maintenance_detail cascade;

drop table if exists menu cascade;

drop table if exists office cascade;

drop table if exists progress_detail cascade;

drop table if exists fam_evaluation cascade;

drop table if exists role cascade;

drop table if exists spb cascade;

drop table if exists spk_pr cascade;

drop table if exists status_asset_detail cascade;

drop table if exists survey_location cascade;

drop table if exists treg cascade;

drop table if exists vendor cascade;

drop table if exists witel cascade;

