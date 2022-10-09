/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : zhangcqmis15

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 09/10/2022 20:53:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zhangcq_class15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_class15`;
CREATE TABLE `zhangcq_class15`  (
  `zcq_Classno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Classname15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Classno15`) USING BTREE,
  UNIQUE INDEX `zcq_Classno15`(`zcq_Classno15`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_class15
-- ----------------------------
INSERT INTO `zhangcq_class15` VALUES ('001', '软工01');
INSERT INTO `zhangcq_class15` VALUES ('002', '软工02');
INSERT INTO `zhangcq_class15` VALUES ('003', '计科01');
INSERT INTO `zhangcq_class15` VALUES ('004', '网工01');
INSERT INTO `zhangcq_class15` VALUES ('005', '电信01');
INSERT INTO `zhangcq_class15` VALUES ('006', '数媒01');
INSERT INTO `zhangcq_class15` VALUES ('099', '物联网01');

-- ----------------------------
-- Table structure for zhangcq_colleges15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_colleges15`;
CREATE TABLE `zhangcq_colleges15`  (
  `zcq_Collegeno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Collegename15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Collegeno15`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_colleges15
-- ----------------------------
INSERT INTO `zhangcq_colleges15` VALUES ('001', '计算机科学与技术学院');
INSERT INTO `zhangcq_colleges15` VALUES ('002', '信息工程学院');
INSERT INTO `zhangcq_colleges15` VALUES ('003', '机械工程学院');

-- ----------------------------
-- Table structure for zhangcq_courses15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_courses15`;
CREATE TABLE `zhangcq_courses15`  (
  `zcq_Courseno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Coursename15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Collegeno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Ccredit15` double NULL DEFAULT NULL,
  `zcq_Chours15` int NULL DEFAULT NULL,
  `zcq_Cassessment15` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Courseno15`) USING BTREE,
  UNIQUE INDEX `zcq_Courseno15`(`zcq_Courseno15`) USING BTREE,
  INDEX `College_Course`(`zcq_Collegeno15`) USING BTREE,
  CONSTRAINT `College_Course` FOREIGN KEY (`zcq_Collegeno15`) REFERENCES `zhangcq_teachers15` (`zcq_Collegeno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_courses15
-- ----------------------------
INSERT INTO `zhangcq_courses15` VALUES ('001', '数据库系统', '001', 3, 48, '考试');
INSERT INTO `zhangcq_courses15` VALUES ('002', 'C++程序设计', '001', 4, 64, '考试');
INSERT INTO `zhangcq_courses15` VALUES ('003', '电路控制', '002', 4, 64, '考试');
INSERT INTO `zhangcq_courses15` VALUES ('004', '计算机发展历史', '001', 2, 32, '考查');
INSERT INTO `zhangcq_courses15` VALUES ('099', '计算机组成原理', '001', 3, 64, '考试');

-- ----------------------------
-- Table structure for zhangcq_grade15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_grade15`;
CREATE TABLE `zhangcq_grade15`  (
  `zcq_Sno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Courseno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Grade15` int NULL DEFAULT NULL,
  `zcq_Tno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Cterm15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Sno15`, `zcq_Courseno15`, `zcq_Tno15`) USING BTREE,
  INDEX `Course_Grade`(`zcq_Courseno15`) USING BTREE,
  INDEX `Teacher_Grade`(`zcq_Tno15`) USING BTREE,
  CONSTRAINT `Course_Grade` FOREIGN KEY (`zcq_Courseno15`) REFERENCES `zhangcq_courses15` (`zcq_Courseno15`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Student_Grade` FOREIGN KEY (`zcq_Sno15`) REFERENCES `zhangcq_students15` (`zcq_Sno15`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Teacher_Grade` FOREIGN KEY (`zcq_Tno15`) REFERENCES `zhangcq_teachers15` (`zcq_Tno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_grade15
-- ----------------------------
INSERT INTO `zhangcq_grade15` VALUES ('001', '001', 60, '001', '2020(1)');
INSERT INTO `zhangcq_grade15` VALUES ('001', '002', 0, '001', '2021(1)');
INSERT INTO `zhangcq_grade15` VALUES ('001', '099', 99, '001', '2020(2)');
INSERT INTO `zhangcq_grade15` VALUES ('002', '001', 62, '001', '2020(1)');
INSERT INTO `zhangcq_grade15` VALUES ('002', '002', 0, '001', '2021(1)');
INSERT INTO `zhangcq_grade15` VALUES ('002', '003', 0, '001', '2020(2)');
INSERT INTO `zhangcq_grade15` VALUES ('002', '099', 88, '001', '2020(2)');
INSERT INTO `zhangcq_grade15` VALUES ('009', '099', 77, '001', '2021(1)');
INSERT INTO `zhangcq_grade15` VALUES ('010', '099', 66, '001', '2021(1)');
INSERT INTO `zhangcq_grade15` VALUES ('013', '099', 55, '001', '2021(1)');
INSERT INTO `zhangcq_grade15` VALUES ('099', '099', 44, '001', '2020(2)');

-- ----------------------------
-- Table structure for zhangcq_majors15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_majors15`;
CREATE TABLE `zhangcq_majors15`  (
  `zcq_Mno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Mname15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Collegeno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Mno15`) USING BTREE,
  INDEX `Major_College`(`zcq_Collegeno15`) USING BTREE,
  CONSTRAINT `Major_College` FOREIGN KEY (`zcq_Collegeno15`) REFERENCES `zhangcq_colleges15` (`zcq_Collegeno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_majors15
-- ----------------------------
INSERT INTO `zhangcq_majors15` VALUES ('001', '软件工程', '001');
INSERT INTO `zhangcq_majors15` VALUES ('002', '计算机科学与技术', '001');
INSERT INTO `zhangcq_majors15` VALUES ('003', '网络工程', '001');
INSERT INTO `zhangcq_majors15` VALUES ('004', '电子信息', '002');
INSERT INTO `zhangcq_majors15` VALUES ('099', '物联网工程', '001');

-- ----------------------------
-- Table structure for zhangcq_setupinfo15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_setupinfo15`;
CREATE TABLE `zhangcq_setupinfo15`  (
  `zcq_Courseno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Classno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`zcq_Classno15`, `zcq_Courseno15`) USING BTREE,
  INDEX `Setupinfo_Course`(`zcq_Courseno15`) USING BTREE,
  CONSTRAINT `Setupinfo_Course` FOREIGN KEY (`zcq_Courseno15`) REFERENCES `zhangcq_courses15` (`zcq_Courseno15`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Setupinfo_Teacher` FOREIGN KEY (`zcq_Classno15`) REFERENCES `zhangcq_class15` (`zcq_Classno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_setupinfo15
-- ----------------------------
INSERT INTO `zhangcq_setupinfo15` VALUES ('001', '001');
INSERT INTO `zhangcq_setupinfo15` VALUES ('002', '001');
INSERT INTO `zhangcq_setupinfo15` VALUES ('003', '001');
INSERT INTO `zhangcq_setupinfo15` VALUES ('099', '001');
INSERT INTO `zhangcq_setupinfo15` VALUES ('099', '004');

-- ----------------------------
-- Table structure for zhangcq_students15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_students15`;
CREATE TABLE `zhangcq_students15`  (
  `zcq_Sno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Mno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Sname15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Ssex15` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Sage15` int NULL DEFAULT NULL,
  `zcq_Savggpa15` double NULL DEFAULT NULL,
  `zcq_Scredit15` double NULL DEFAULT NULL,
  `zcq_Sphone15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Shometown15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Spwd15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Sno15`) USING BTREE,
  UNIQUE INDEX `zcq_Sno15`(`zcq_Sno15`) USING BTREE,
  INDEX `Student_Major`(`zcq_Mno15`) USING BTREE,
  INDEX `Student_Class`(`zcq_Class`) USING BTREE,
  CONSTRAINT `Student_Class` FOREIGN KEY (`zcq_Class`) REFERENCES `zhangcq_class15` (`zcq_Classno15`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Student_Major` FOREIGN KEY (`zcq_Mno15`) REFERENCES `zhangcq_majors15` (`zcq_Mno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_students15
-- ----------------------------
INSERT INTO `zhangcq_students15` VALUES ('001', '001', '张成强', 'M', 22, 2.95, 6, '1234567890', '浙江温州', '1234567', '001');
INSERT INTO `zhangcq_students15` VALUES ('002', '001', '小明', 'M', 23, 2.5, 6, '1234567890', '浙江杭州', '123456', '001');
INSERT INTO `zhangcq_students15` VALUES ('003', '001', '小红', 'F', 23, 0, 0, '1234567890', '浙江温州', '123456', '002');
INSERT INTO `zhangcq_students15` VALUES ('004', '001', '小绿', 'M', 22, 0, 0, '1234567890', '浙江温州', '123456', '002');
INSERT INTO `zhangcq_students15` VALUES ('005', '002', '小军', 'M', 21, 0, 0, '1234567890', '浙江杭州', '123456', '003');
INSERT INTO `zhangcq_students15` VALUES ('006', '002', '小蓝', 'F', 22, 0, 0, '1234567890', '浙江宁波', '123456', '003');
INSERT INTO `zhangcq_students15` VALUES ('007', '002', '小美', 'F', 23, 0, 0, '1234567890', '浙江杭州', '123456', '003');
INSERT INTO `zhangcq_students15` VALUES ('008', '002', '小狗', 'M', 21, 0, 0, '1234567890', '浙江温州', '123456', '003');
INSERT INTO `zhangcq_students15` VALUES ('009', '003', '小一', 'F', 21, 2.7, 3, '1234567890', '浙江温州', '123456', '004');
INSERT INTO `zhangcq_students15` VALUES ('010', '003', '小二', 'M', 22, 1.6, 3, '1234567890', '浙江杭州', '123456', '004');
INSERT INTO `zhangcq_students15` VALUES ('011', '004', '小三', 'M', 21, 0, 0, '1234567890', '浙江杭州', '123456', '005');
INSERT INTO `zhangcq_students15` VALUES ('012', '004', '小四', 'M', 22, 0, 0, '1234567890', '浙江杭州', '123456', '005');
INSERT INTO `zhangcq_students15` VALUES ('013', '003', '小白', 'M', 22, NULL, NULL, '1234567890', '浙江温州', '123456', '004');
INSERT INTO `zhangcq_students15` VALUES ('099', '001', '马邦德', 'M', 20, NULL, NULL, '12345680', '浙江杭州', '123456', '001');

-- ----------------------------
-- Table structure for zhangcq_teachers15
-- ----------------------------
DROP TABLE IF EXISTS `zhangcq_teachers15`;
CREATE TABLE `zhangcq_teachers15`  (
  `zcq_Tno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zcq_Tname15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Tsex15` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Tprofess15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Tphone15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Tauthority15` int NULL DEFAULT NULL,
  `zcq_Tpwd15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zcq_Tage15` int NULL DEFAULT NULL,
  `zcq_Collegeno15` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zcq_Tno15`) USING BTREE,
  UNIQUE INDEX `zcq_Tno15`(`zcq_Tno15`) USING BTREE,
  INDEX `Teacher_College`(`zcq_Collegeno15`) USING BTREE,
  CONSTRAINT `Teacher_College` FOREIGN KEY (`zcq_Collegeno15`) REFERENCES `zhangcq_colleges15` (`zcq_Collegeno15`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangcq_teachers15
-- ----------------------------
INSERT INTO `zhangcq_teachers15` VALUES ('001', '师一', 'M', '讲师', '1234567890', 1, '1234567', 42, '001');
INSERT INTO `zhangcq_teachers15` VALUES ('002', '师二', 'M', '讲师', '1234567890', 1, '123456', 47, '001');
INSERT INTO `zhangcq_teachers15` VALUES ('003', '师三', 'F', '副教授', '1234567890', 1, '123456', 52, '001');
INSERT INTO `zhangcq_teachers15` VALUES ('004', '师四', 'F', '院长', '1234567890', 2, '123456', 57, '001');
INSERT INTO `zhangcq_teachers15` VALUES ('005', '师五', 'M', '讲师', '1234567890', 1, '123456', 32, '002');
INSERT INTO `zhangcq_teachers15` VALUES ('006', '师六', 'M', '讲师', '1234567890', 1, '123456', 37, '002');
INSERT INTO `zhangcq_teachers15` VALUES ('007', '师七', 'M', '院长', '1234567890', 2, '123456', 47, '002');
INSERT INTO `zhangcq_teachers15` VALUES ('099', '张牧之', 'M', '讲师', '1234567890', 1, '123456', 39, '001');

-- ----------------------------
-- View structure for zhangcq_couinfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_couinfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_couinfo15` AS select distinct `zhangcq_courses15`.`zcq_Courseno15` AS `zcq_Courseno15`,`zhangcq_courses15`.`zcq_Coursename15` AS `zcq_Coursename15`,`zhangcq_courses15`.`zcq_Ccredit15` AS `zcq_Ccredit15`,`zhangcq_grade15`.`zcq_Cterm15` AS `zcq_Cterm15`,`zhangcq_teachers15`.`zcq_Tname15` AS `zcq_Tname15`,`zhangcq_colleges15`.`zcq_Collegename15` AS `zcq_Collegename15`,`zhangcq_courses15`.`zcq_Cassessment15` AS `zcq_Cassessment15` from (((`zhangcq_courses15` join `zhangcq_colleges15`) join `zhangcq_teachers15`) join `zhangcq_grade15`) where ((`zhangcq_courses15`.`zcq_Courseno15` = `zhangcq_grade15`.`zcq_Courseno15`) and (`zhangcq_courses15`.`zcq_Collegeno15` = `zhangcq_colleges15`.`zcq_Collegeno15`) and (`zhangcq_grade15`.`zcq_Tno15` = `zhangcq_teachers15`.`zcq_Tno15`));

-- ----------------------------
-- View structure for zhangcq_grainfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_grainfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_grainfo15` AS select `zhangcq_grade15`.`zcq_Sno15` AS `zcq_Sno15`,`zhangcq_students15`.`zcq_Sname15` AS `zcq_Sname15`,`zhangcq_courses15`.`zcq_Coursename15` AS `zcq_Coursename15`,`zhangcq_grade15`.`zcq_Grade15` AS `zcq_Grade15`,`zhangcq_grade15`.`zcq_Tno15` AS `zcq_Tno15`,`zhangcq_teachers15`.`zcq_Tname15` AS `zcq_Tname15`,`zhangcq_grade15`.`zcq_Cterm15` AS `zcq_Cterm15`,`zhangcq_class15`.`zcq_Classname15` AS `zcq_Classname15`,`zhangcq_grade15`.`zcq_Courseno15` AS `zcq_Courseno15` from ((((`zhangcq_grade15` join `zhangcq_courses15`) join `zhangcq_teachers15`) join `zhangcq_students15`) join `zhangcq_class15`) where ((`zhangcq_grade15`.`zcq_Sno15` = `zhangcq_students15`.`zcq_Sno15`) and (`zhangcq_grade15`.`zcq_Courseno15` = `zhangcq_courses15`.`zcq_Courseno15`) and (`zhangcq_students15`.`zcq_Class` = `zhangcq_class15`.`zcq_Classno15`) and (`zhangcq_grade15`.`zcq_Tno15` = `zhangcq_teachers15`.`zcq_Tno15`));

-- ----------------------------
-- View structure for zhangcq_setinfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_setinfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_setinfo15` AS select `zhangcq_courses15`.`zcq_Coursename15` AS `zcq_Coursename15`,`zhangcq_class15`.`zcq_Classname15` AS `zcq_Classname15` from ((`zhangcq_setupinfo15` join `zhangcq_courses15`) join `zhangcq_class15`) where ((`zhangcq_setupinfo15`.`zcq_Classno15` = `zhangcq_class15`.`zcq_Classno15`) and (`zhangcq_setupinfo15`.`zcq_Courseno15` = `zhangcq_courses15`.`zcq_Courseno15`));

-- ----------------------------
-- View structure for zhangcq_stuinfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_stuinfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_stuinfo15` AS select `zhangcq_students15`.`zcq_Sno15` AS `zcq_Sno15`,`zhangcq_majors15`.`zcq_Mname15` AS `zcq_Mname15`,`zhangcq_students15`.`zcq_Sname15` AS `zcq_Sname15`,`zhangcq_students15`.`zcq_Ssex15` AS `zcq_Ssex15`,`zhangcq_class15`.`zcq_Classname15` AS `zcq_Classname15`,`zhangcq_students15`.`zcq_Sphone15` AS `zcq_Sphone15`,`zhangcq_students15`.`zcq_Shometown15` AS `zcq_Shometown15` from ((`zhangcq_students15` join `zhangcq_class15`) join `zhangcq_majors15`) where ((`zhangcq_students15`.`zcq_Class` = `zhangcq_class15`.`zcq_Classno15`) and (`zhangcq_students15`.`zcq_Mno15` = `zhangcq_majors15`.`zcq_Mno15`));

-- ----------------------------
-- View structure for zhangcq_teainfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_teainfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_teainfo15` AS select `zhangcq_teachers15`.`zcq_Tno15` AS `zcq_Tno15`,`zhangcq_teachers15`.`zcq_Tname15` AS `zcq_Tname15`,`zhangcq_teachers15`.`zcq_Tsex15` AS `zcq_Tsex15`,`zhangcq_teachers15`.`zcq_Tprofess15` AS `zcq_Tprofess15`,`zhangcq_teachers15`.`zcq_Tphone15` AS `zcq_Tphone15`,`zhangcq_teachers15`.`zcq_Tage15` AS `zcq_Tage15`,`zhangcq_colleges15`.`zcq_Collegename15` AS `zcq_Collegename15` from (`zhangcq_teachers15` join `zhangcq_colleges15`) where (`zhangcq_teachers15`.`zcq_Collegeno15` = `zhangcq_colleges15`.`zcq_Collegeno15`);

-- ----------------------------
-- View structure for zhangcq_workinfo15
-- ----------------------------
DROP VIEW IF EXISTS `zhangcq_workinfo15`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `zhangcq_workinfo15` AS select `zhangcq_grade15`.`zcq_Sno15` AS `zcq_Sno15`,`zhangcq_grade15`.`zcq_Tno15` AS `zcq_Tno15`,`zhangcq_teachers15`.`zcq_Tname15` AS `zcq_Tname15`,`zhangcq_grade15`.`zcq_Cterm15` AS `zcq_Cterm15`,`zhangcq_courses15`.`zcq_Coursename15` AS `zcq_Coursename15`,`zhangcq_courses15`.`zcq_Ccredit15` AS `zcq_Ccredit15`,`zhangcq_courses15`.`zcq_Chours15` AS `zcq_Chours15`,`zhangcq_courses15`.`zcq_Cassessment15` AS `zcq_Cassessment15` from ((`zhangcq_grade15` join `zhangcq_courses15`) join `zhangcq_teachers15`) where ((`zhangcq_grade15`.`zcq_Courseno15` = `zhangcq_courses15`.`zcq_Courseno15`) and (`zhangcq_grade15`.`zcq_Tno15` = `zhangcq_teachers15`.`zcq_Tno15`));

-- ----------------------------
-- Procedure structure for zcq_insertStu15
-- ----------------------------
DROP PROCEDURE IF EXISTS `zcq_insertStu15`;
delimiter ;;
CREATE PROCEDURE `zcq_insertStu15`(IN zcq_cno15 VARCHAR(20), IN zcq_banji15 VARCHAR(20),IN zcq_tno15 VARCHAR(20), IN zcq_cterm15 VARCHAR(20))
BEGIN
  -- 需要定义接收游标数据的变量 
  declare finished integer default 0;
	DECLARE zcq_varSno15 VARCHAR(20) DEFAULT NULL;
	DECLARE cur CURSOR FOR
	SELECT zcq_Sno15
	FROM zhangcq_students15
	WHERE zcq_Class=zcq_banji15;
	declare continue handler for not found set finished = 1;
	OPEN cur;
	get_Sno:LOOP
	FETCH cur INTO zcq_varSno15;
	IF finished = 1 then 
	LEAVE get_Sno;
	END IF;
	INSERT INTO zhangcq_grade15 VALUES(zcq_varSno15, zcq_cno15, 0, zcq_tno15, zcq_cterm15);
	END LOOP get_Sno;
	CLOSE cur;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for zcq_updateAge15
-- ----------------------------
DROP PROCEDURE IF EXISTS `zcq_updateAge15`;
delimiter ;;
CREATE PROCEDURE `zcq_updateAge15`()
BEGIN
  -- 需要定义接收游标数据的变量 
	UPDATE zhangcq_students15
	SET zcq_Sage15 = zcq_Sage15+1;
	UPDATE zhangcq_teachers15
	SET zcq_Tage15 = zcq_Tage15+1;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table zhangcq_grade15
-- ----------------------------
DROP TRIGGER IF EXISTS `zcq_ins_credit`;
delimiter ;;
CREATE TRIGGER `zcq_ins_credit` AFTER UPDATE ON `zhangcq_grade15` FOR EACH ROW BEGIN
	UPDATE zhangcq_students15
	SET zcq_Scredit15=(
		SELECT SUM(zcq_Ccredit15)
		FROM zhangcq_courses15 
		WHERE zcq_Courseno15 IN (
			SELECT zcq_Courseno15 
			FROM zhangcq_grade15 
			WHERE zcq_Grade15 >= 60 and zcq_Sno15=new.zcq_Sno15)) 
	WHERE zcq_Sno15=new.zcq_Sno15;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table zhangcq_grade15
-- ----------------------------
DROP TRIGGER IF EXISTS `zcq_ins_gpa`;
delimiter ;;
CREATE TRIGGER `zcq_ins_gpa` AFTER UPDATE ON `zhangcq_grade15` FOR EACH ROW BEGIN
	UPDATE zhangcq_students15
	SET zcq_Savggpa15=(
		SELECT ROUND(SUM(((zcq_Grade15-50)/10)*zcq_Ccredit15)/SUM(zcq_Ccredit15),2)
		FROM zhangcq_courses15,zhangcq_grade15
		WHERE zhangcq_courses15.zcq_Courseno15=zhangcq_grade15.zcq_Courseno15 and zcq_Grade15 >= 60 and zcq_Sno15=new.zcq_Sno15) 
	WHERE zcq_Sno15=new.zcq_Sno15;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table zhangcq_grade15
-- ----------------------------
DROP TRIGGER IF EXISTS `zcq_del_gpa`;
delimiter ;;
CREATE TRIGGER `zcq_del_gpa` AFTER DELETE ON `zhangcq_grade15` FOR EACH ROW BEGIN
	UPDATE zhangcq_students15
	SET zcq_Savggpa15=(
		SELECT ROUND(SUM(((zcq_Grade15-50)/10)*zcq_Ccredit15)/SUM(zcq_Ccredit15),2)
		FROM zhangcq_courses15,zhangcq_grade15
		WHERE zhangcq_courses15.zcq_Courseno15=zhangcq_grade15.zcq_Courseno15 and zcq_Grade15 >= 60 and zcq_Sno15=old.zcq_Sno15) 
	WHERE zcq_Sno15=old.zcq_Sno15;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table zhangcq_grade15
-- ----------------------------
DROP TRIGGER IF EXISTS `zcq_del_credit`;
delimiter ;;
CREATE TRIGGER `zcq_del_credit` AFTER DELETE ON `zhangcq_grade15` FOR EACH ROW BEGIN
	UPDATE zhangcq_students15
	SET zcq_Scredit15=(
		SELECT SUM(zcq_Ccredit15)
		FROM zhangcq_courses15 
		WHERE zcq_Courseno15 IN (
			SELECT zcq_Courseno15 
			FROM zhangcq_grade15 
			WHERE zcq_Grade15 >= 60 and zcq_Sno15=old.zcq_Sno15)) 
	WHERE zcq_Sno15=old.zcq_Sno15;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
