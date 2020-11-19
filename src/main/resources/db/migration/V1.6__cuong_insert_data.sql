-- Insert Notification
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'The whole company is entitled to have a holiday', '2020-05-11', 'Holiday Notice', 'Normal', '2');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'On 21/10/2020 Codegym Center will organize teambuilding', '2020-06-12', 'Teambuilding', 'Normal', '1');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'On October 22, 2020, power off the whole city', '2020-11-16', 'power outage schedule', 'Normal', '3');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'ceremony of cooperation between the two companies', '2020-11-05', 'contract with company:', 'vip', '4');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', ' February 30, 2022 for Tet holiday. Wishing the whole New Year Center', '2020-11-11', 'Tet holidaytle', 'Normal', '5');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'the wife of the director who gives birth to the whole company.', '2020-11-13', 'Special noticetle', 'vip', '1');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'the wife of the deputy director gives birth to the whole company', '2020-11-06', 'Special notice', 'vip', '6');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'director gives birth to the whole company', '2020-01-01', 'Special notice', 'vip', '7');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'On November 27, 2020, signing cooperation', '2020-12-11', 'contract of AXX', 'Normal', '8');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'the contract of ATC company: On 28/11/2020, signed cooperation', '2020-11-11', 'contract of ATC company', 'Normal', '9');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'On 29/11/2020, signed cooperation in SG', '2020-10-11', 'contract of company', 'Normal', '8');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'Notice of signing CTG company contract', '2020-09-11', 'Notice of contract', 'vip', '7');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'whole company retires to play with children', '2020-08-11', 'New Year holidays', 'Normal', '6');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'On December 2, 2020, the whole company took leave', '2020-07-11', 'Notice for Childrens', 'vip', '5');
INSERT INTO `c04piggy`.`notification` (`description`, `is_deleted`, `content`, `create_date`, `title`, `type`, `employee_id`) VALUES ('Hello men', '0', 'The whole company took a public holiday for you', '2020-06-11', 'Holiday notice', 'Normal', '4');


-- Insert Diseases
INSERT INTO `c04piggy`.`diseases` (`description`, `is_deleted`, `name`) VALUES ('d', '0', 'Psittacosis');
INSERT INTO `c04piggy`.`diseases` (`description`, `is_deleted`, `name`) VALUES ('d', '0', 'Trichinosis');
INSERT INTO `c04piggy`.`diseases` (`description`, `is_deleted`, `name`) VALUES ('d', '0', 'Histoplasmosis');
INSERT INTO `c04piggy`.`diseases` (`description`, `is_deleted`, `name`) VALUES ('d', '0', 'Blastomycosis');
INSERT INTO `c04piggy`.`diseases` (`description`, `is_deleted`, `name`) VALUES ('d', '0', 'Bioterrorism');


-- Insert Vacxin
INSERT INTO `c04piggy`.`vacxin` (`name`) VALUES ('corrona');
INSERT INTO `c04piggy`.`vacxin` (`name`) VALUES ('skyway');
INSERT INTO `c04piggy`.`vacxin` (`name`) VALUES ('chinese');
INSERT INTO `c04piggy`.`vacxin` (`name`) VALUES ('blue ocean');
INSERT INTO `c04piggy`.`vacxin` (`name`) VALUES ('new time');

-- Insert Treatment_vacxin
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'John Mike', '1', '1', '1', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Lana Lane', '2', '2', '2', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'John Mike', '3', '3', '3', '3');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Lana Lane', '1', '2', '3', '4');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Raul Gonzela', '1', '2', '2', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Lana Lane', '1', '3', '2', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'John Mike', '1', '2', '3', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Lana Lane', '1', '3', '1', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Raul Gonzela', '2', '1', '2', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Lana Lane', '3', '2', '1', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'John Mike', '1', '2', '1', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`, `pig_id`, `vacxin_id`) VALUES ('d', '0', '2020-01-01', 'treatment', 'Raul Gonzela', '2', '1', '1', '3');

INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'v', '1', '3');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Raul Gonzela', '2', '3');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'John Mike', '1', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Lana Lane', '3', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'John Mike', '1', '3');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Raul Gonzela', '2', '4');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Lana Lane', '3', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Raul Gonzela', '3', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'John Mike', '3', '3');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Lana Lane', '4', '1');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'Raul Gonzela', '4', '2');
INSERT INTO `c04piggy`.`treatment_vacxin` (`description`, `is_deleted`, `treat_date`, `type`, `veterinary`, `cote_id`, `diseases_id`) VALUES ('d', '0', '2020-01-01', 'vacxin', 'John Mike', '4', '3');

