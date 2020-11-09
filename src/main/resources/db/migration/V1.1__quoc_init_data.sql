
-- Insert Herd
insert into herd values (1,"Bầy heo ngày 10/10/2020", 0,"H101020");
insert into herd values (2,"Bầy heo ngày 15/10/2020", 0,"H151020");
insert into herd values (3,"Bầy heo ngày 30/09/2020", 0,"H300920");
insert into herd values (4,"Bầy heo ngày 01/09/2020", 0,"H010920");
insert into herd values (5,"Bầy heo ngày 02/08/2020", 0,"H020820");
insert into herd values (6,"Bầy heo ngày 15/09/2020", 0,"H150920");
insert into herd values (7,"Bầy heo ngày 20/09/2020", 0,"H200920");
insert into herd values (8,"Bầy heo ngày 05/10/2020", 0,"H051020");
insert into herd values (9,"Bầy heo ngày 25/09/2020", 0,"H250920");
insert into herd values (10,"Bầy heo ngày 20/10/2020", 0,"H201020");
insert into herd values (11,"Bầy heo ngày 29/10/2020", 0,"H291020");
insert into herd values (12,"Bầy heo ngày 18/10/2020", 0,"H181020");
insert into herd values (13,"Bầy heo ngày 01/10/2020", 0,"H011020");
insert into herd values (14,"Bầy heo ngày 01/11/2020", 0,"H011120");
insert into herd values (15,"Bầy heo ngày 16/08/2020", 0,"H160820");


-- Insert Account
insert into account (username, password) values ('quoc', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('huy', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('thinh', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('cuong', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('viet', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('hai', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('hieu', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('trung', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');
insert into account (username, password) values ('tuong', '$2a$10$kumXdI7LpK.1yTmmixTOq.YMDyEPg3P.UKdFEpK42MF88zQmXY0h.');


-- Insert Employee
insert into employee values (1,"",0,"1984-09-23","123456789","NV1234","abc@abc.com",1,"Anh Quốc",1);
insert into employee values (2,"",0,"1992-02-05","123456789","NV1235","abc@abc.com",1,"Nhật Huy",2);
insert into employee values (3,"",0,"1995-10-12","123456789","NV1236","abc@abc.com",1,"Văn Thịnh",3);
insert into employee values (4,"",0,"1991-02-05","123456789","NV1237","abc@abc.com",1,"Mạnh Cường",4);
insert into employee values (5,"",0,"1993-10-10","123456789","NV1238","abc@abc.com",1,"Quốc Việt",5);
insert into employee values (6,"",0,"1996-10-10","123456789","NV1239","abc@abc.com",1,"Văn Hải",6);
insert into employee values (7,"",0,"1999-10-10","123456789","NV2345","abc@abc.com",1,"Văn Hiếu",7);
insert into employee values (8,"",0,"1995-10-10","123456789","NV2346","abc@abc.com",1,"Quang Trung",8);
insert into employee values (9,"",0,"1994-10-10","123456789","NV2347","abc@abc.com",1,"Lê Tường",9);


-- Insert Permission
INSERT INTO `c04piggy`.`permission` (`is_deleted`, `name`) VALUES ('0', 'create');
INSERT INTO `c04piggy`.`permission` (`is_deleted`, `name`) VALUES ('0', 'read');
INSERT INTO `c04piggy`.`permission` (`is_deleted`, `name`) VALUES ('0', 'update');
INSERT INTO `c04piggy`.`permission` (`is_deleted`, `name`) VALUES ('0', 'delete');


-- Insert Role
INSERT INTO `c04piggy`.`role` (`name`) VALUES ('user');
INSERT INTO `c04piggy`.`role` (`name`) VALUES ('manager');
INSERT INTO `c04piggy`.`role` (`name`) VALUES ('leader');
INSERT INTO `c04piggy`.`role` (`name`) VALUES ('admin');
INSERT INTO `c04piggy`.`role` (`name`) VALUES ('super admin');


-- Insert Role_Permision
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('1', '3');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('2', '3');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('3', '3');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('1', '4');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('2', '4');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('3', '4');
INSERT INTO `c04piggy`.`role_permission` (`permission_id`, `role_id`) VALUES ('4', '4');


-- Insert Role_Account
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('1', '4');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('2', '4');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('5', '3');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('6', '3');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('3', '2');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('4', '1');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('5', '1');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('7', '1');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('8', '1');
INSERT INTO `c04piggy`.`role_account` (`account_id`, `role_id`) VALUES ('9', '1');


-- Insert Cote
insert into cote values (1,"",0,"A01","2020-10-10",null,5,"",1,1);
insert into cote values (2,"",0,"A02","2020-10-15",null,5,"",2,2);
insert into cote values (3,"",0,"A03","2020-09-30",null,5,"",3,3);
insert into cote values (4,"",0,"A04","2020-09-01",null,5,"",4,4);
insert into cote values (5,"",0,"B01","2020-08-02",null,5,"",5,5);
insert into cote values (6,"",0,"B02","2020-09-15",null,5,"",6,6);
insert into cote values (7,"",0,"B03","2020-09-20",null,5,"",7,7);
insert into cote values (8,"",0,"B04","2020-10-05",null,5,"",2,8);
insert into cote values (9,"",0,"C01","2020-09-25",null,5,"",4,9);
insert into cote values (10,"",0,"C02","2020-10-20",null,5,"",3,10);
insert into cote values (11,"",0,"C03","2020-10-29",null,5,"",7,11);
insert into cote values (12,"",0,"C04","2020-10-18",null,5,"",8,12);
insert into cote values (13,"",0,"D01","2020-10-01",null,5,"",9,13);
insert into cote values (14,"",0,"D02","2020-11-01",null,5,"",9,14);
insert into cote values (15,"",0,"D03","2020-08-16",null,5,"",4,15);


-- Insert FeedType
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('soya beans', 'Soya beans');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('rice bran', 'Rice bran');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('maize', 'Maize');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('broken rice', 'Broken rice');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('wheat bran', 'Wheat bran');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('corn bran', 'Corn bran');
INSERT INTO `c04piggy`.`feed_type` (`description`, `name`) VALUES ('fish poder', 'Fish poder');


-- Insert vendor
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 1','CPVN','CP. Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 2','CARGILLVN','CARGILL Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 3','JAPPAVN','JAPPA Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 4','DABACOVN','DABACO Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 5','CTCP','Tong Cty Chan nuoi Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 6','GREENFEEDVN','GREENFEED Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 7','DEHEUSVN','DE HEUS Viet Nam');
INSERT INTO `c04piggy`.`vendor` (`description`,`code`,`name`) VALUES ('cty so 8','MAVINAUSTFEED','MAVIN AUSTFEED Viet Nam');


-- Insert Stock
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-01', '2020-11-07', '2020-11-01', '1000', '12344323', 'kilogam', '1', '1');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('very good', '2021-01-02', '2020-11-07', '2020-11-02', '1500', '00987687', 'kilogam', '2', '2');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('wonderful', '2021-01-03', '2020-11-07', '2020-11-03', '1250', '00007612', 'kilogam', '3', '3');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('good', '2021-01-04', '2020-11-07', '2020-11-04', '1150', '00764323', 'kilogam', '4', '4');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('excelent', '2021-01-05', '2020-11-09', '2020-11-05', '1750', '00879609', 'kilogam', '5', '5');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-06', '2020-11-09', '2020-11-06', '1350', '03857982', 'kilogam', '6', '6');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-07', '2020-11-09', '2020-11-07', '1100', '82358998', 'kilogam', '7', '7');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-08', '2020-11-09', '2020-11-08', '1200', '04968284', 'kilogam', '2', '8');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-09', '2020-11-10', '2020-11-09', '1200', '95720069', 'kilogam', '2', '3');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-10', '2020-11-10', '2020-11-09', '1000', '12346768', 'kilogam', '5', '4');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-11', '2020-11-10', '2020-11-10', '900', '54732452', 'kilogam', '7', '6');
INSERT INTO `c04piggy`.`stock` (`description`, `exp_date`, `import_date`, `mfg_date`, `quantity`, `shipment_code`, `unit`, `feed_type_id`, `vendor_id`) VALUES ('special', '2021-01-12', '2020-11-10', '2020-11-11', '2500', '70878475', 'kilogam', '4', '7');


-- Insert history_export
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `employee_id`, `stock_id`) VALUES ('2020-11-12', '100', '3', 'stock', '1', '1');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-12', '200', '3', 'stock', 'kilogam', '1', '2');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-12', '200', '2', 'stock', 'kilogam', '3', '3');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-12', '150', '2', 'stock', 'kilogam', '3', '4');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-10', '50', '5', 'stock', 'kilogam', '4', '5');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-10', '100', '5', 'stock', 'kilogam', '4', '6');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-10', '150', '2', 'stock', 'kilogam', '5', '7');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-10', '250', '2', 'stock', 'kilogam', '5', '8');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-13', '150', '9', 'stock', 'kilogam', '6', '9');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-13', '300', '9', 'stock', 'kilogam', '6', '10');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-13', '200', '8', 'stock', 'kilogam', '7', '11');
INSERT INTO `c04piggy`.`history_export` (`export_date`, `quantity`, `received_employee_id`, `type`, `unit`, `employee_id`, `stock_id`) VALUES ('2020-11-13', '300', '6', 'stock', 'kilogam', '8', '12');
