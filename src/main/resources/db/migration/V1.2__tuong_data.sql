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

-- Insert Stock --
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

-- Insert history_export --
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
