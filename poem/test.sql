/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-01-09 21:19:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `poet_table`
-- ----------------------------
DROP TABLE IF EXISTS `poet_table`;
CREATE TABLE `poet_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poet` varchar(255) DEFAULT NULL,
  `msg` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poet_table
-- ----------------------------
INSERT INTO `poet_table` VALUES ('1', '李白', '李白（701年－762年） ，字太白，号青莲居士，又号“谪仙人”，唐代伟大的浪漫主义诗人，被后人誉为“诗仙”，与杜甫并称为“李杜”，为了与另两位诗人李商隐与杜牧即“小李杜”区别，杜甫与李白又合称“大李杜”。据《新唐书》记载，李白为兴圣皇帝（凉武昭王李暠）九世孙，与李唐诸王同宗。其人爽朗大方，爱饮酒作诗，喜交友。李白深受黄老列庄思想影响，有《李太白集》传世，诗作中多以醉时写的，代表作有《望庐山瀑布》《行路难》《蜀道难》《将进酒》《明堂赋》《早发白帝城》等多首。');
INSERT INTO `poet_table` VALUES ('2', '杜甫', '杜甫（712－770），字子美，自号少陵野老，世称“杜工部”、“杜少陵”等，汉族，河南府巩县（今河南省巩义市）人，唐代伟大的现实主义诗人，杜甫被世人尊为“诗圣”，其诗被称为“诗史”。杜甫与李白合称“李杜”，为了跟另外两位诗人李商隐与杜牧即“小李杜”区别开来，杜甫与李白又合称“大李杜”。他忧国忧民，人格高尚，他的约1400余首诗被保留了下来，诗艺精湛，在中国古典诗歌中备受推崇，影响深远。759-766年间曾居成都，后世有杜甫草堂纪念。');
INSERT INTO `poet_table` VALUES ('3', '苏轼', '1037年1月8日-1101年8月24日）字子瞻、和仲，号铁冠道人、东坡居士，世称苏东坡、苏仙，汉族，眉州眉山（四川省眉山市）人，祖籍河北栾城，北宋著名文学家、书法家、画家，历史治水名人。苏轼是北宋中期文坛领袖，在诗、词、散文、书、画等方面取得很高成就。文纵横恣肆；诗题材广阔，清新豪健，善用夸张比喻，独具风格，与黄庭坚并称“苏黄”；词开豪放一派，与辛弃疾同是豪放派代表，并称“苏辛”；散文著述宏富，豪放自如，与欧阳修并称“欧苏”，为“唐宋八大家”之一。苏轼善书，“宋四家”之一；擅长文人画，尤擅墨竹、怪石、枯木等。作品有《东坡七集》《东坡易传》《东坡乐府》《潇湘竹石图卷》《古木怪石图卷》等。');
INSERT INTO `poet_table` VALUES ('4', '李商隐', '李商隐（约813年-约858年），字义山，号玉溪（谿）生、樊南生，唐代著名诗人，祖籍河内（今河南省焦作市）沁阳，出生于郑州荥阳。他擅长诗歌写作，骈文文学价值也很高，是晚唐最出色的诗人之一，和杜牧合称“小李杜”，与温庭筠合称为“温李”，因诗文与同时期的段成式、温庭筠风格相近，且三人都在家族里排行第十六，故并称为“三十六体”。其诗构思新奇，风格秾丽，尤其是一些爱情诗和无题诗写得缠绵悱恻，优美动人，广为传诵。但部分诗歌过于隐晦迷离，难于索解，至有“诗家总爱西昆好，独恨无人作郑笺”之说。因处于牛李党争的夹缝之中，一生很不得志。死后葬于家乡沁阳（今河南焦作市沁阳与博爱县交界之处）。作品收录为《李义山诗集》。');
INSERT INTO `poet_table` VALUES ('5', '白居易', '白居易（772年－846年），字乐天，号香山居士，又号醉吟先生，祖籍太原，到其曾祖父时迁居下邽，生于河南新郑。是唐代伟大的现实主义诗人，唐代三大诗人之一。白居易与元稹共同倡导新乐府运动，世称“元白”，与刘禹锡并称“刘白”。白居易的诗歌题材广泛，形式多样，语言平易通俗，有“诗魔”和“诗王”之称。官至翰林学士、左赞善大夫。公元846年，白居易在洛阳逝世，葬于香山。有《白氏长庆集》传世，代表诗作有《长恨歌》、《卖炭翁》、《琵琶行》等');
INSERT INTO `poet_table` VALUES ('6', '李清照 ', '李清照（1084年3月13日～1155年5月12日）号易安居士，汉族，山东省济南章丘人。宋代（南北宋之交）女词人，婉约词派代表，有“千古第一才女”之称。所作词，前期多写其悠闲生活，后期多悲叹身世，情调感伤。形式上善用白描手法，自辟途径，语言清丽。论词强调协律，崇尚典雅，提出词“别是一家”之说，反对以作诗文之法作词。能诗，留存不多，部分篇章感时咏史，情辞慷慨，与其词风不同。有《易安居士文集》《易安词》，已散佚。后人有《漱玉词》辑本。今有《李清照集校注》。');
INSERT INTO `poet_table` VALUES ('7', '辛弃疾', '辛弃疾（1140－1207），南宋词人。原字坦夫，改字幼安，别号稼轩，汉族，历城（今山东济南）人。出生时，中原已为金兵所占。21岁参加抗金义军，不久归南宋。历任湖北、江西、湖南、福建、浙东安抚使等职。一生力主抗金。曾上《美芹十论》与《九议》，条陈战守之策。其词抒写力图恢复国家统一的爱国热情，倾诉壮志难酬的悲愤，对当时执政者的屈辱求和颇多谴责；也有不少吟咏祖国河山的作品。题材广阔又善化用前人典故入词，风格沉雄豪迈又不乏细腻柔媚之处。由于辛弃疾的抗金主张与当政的主和派政见不合，后被弹劾落职，退隐江西带湖。');
INSERT INTO `poet_table` VALUES ('8', '王维', '王维（701年－761年，一说699年—761年），字摩诘，号摩诘居士。汉族，河东蒲州（今山西运城）人，祖籍山西祁县，唐朝诗人，有“诗佛”之称。苏轼评价其：“味摩诘之诗，诗中有画；观摩诘之画，画中有诗。”开元九年（721年）中进士，任太乐丞。王维是盛唐诗人的代表，今存诗400余首，重要诗作有《相思》《山居秋暝》等。王维精通佛学，受禅宗影响很大。佛教有一部《维摩诘经》，是王维名和字的由来。王维诗书画都很有名，多才多艺，音乐也很精通。与孟浩然合称“王孟”。');
INSERT INTO `poet_table` VALUES ('9', '纳兰性德', '纳兰性德（1655－1685），满洲人，字容若，号楞伽山人，清代最著名词人之一。其诗词“纳兰词”在清代以至整个中国词坛上都享有很高的声誉，在中国文学史上也占有光彩夺目的一席。他生活于满汉融合时期，其贵族家庭兴衰具有关联于王朝国事的典型性。虽侍从帝王，却向往经历平淡。特殊的生活环境背景，加之个人的超逸才华，使其诗词创作呈现出独特的个性和鲜明的艺术风格。流传至今的《木兰花令·拟古决绝词》——“人生若只如初见，何事秋风悲画扇？等闲变却故人心，却道故人心易变。”富于意境，是其众多代表作之一。');
INSERT INTO `poet_table` VALUES ('10', '陆游 ', '陆游（1125—1210），字务观，号放翁。汉族，越州山阴（今浙江绍兴）人，南宋著名诗人。少时受家庭爱国思想熏陶，高宗时应礼部试，为秦桧所黜。孝宗时赐进士出身。中年入蜀，投身军旅生活，官至宝章阁待制。晚年退居家乡。创作诗歌今存九千多首，内容极为丰富。著有《剑南诗稿》、《渭南文集》、《南唐书》、《老学庵笔记》等。');
INSERT INTO `poet_table` VALUES ('11', '陶渊明', '陶渊明（约365～427年），字元亮，晚年更名潜，字渊明。别号五柳先生，私谥靖节，世称靖节先生。浔阳柴桑人（今江西九江）人。东晋末到刘宋初杰出的诗人、辞赋家、散文家。被誉为“隐逸诗人之宗”、“田园诗派之鼻祖”。是江西首位文学巨匠。曾任江州祭酒、建威参军、镇军参军、彭泽县令等职，最末一次出仕为彭泽县令，八十多天便弃职而去，从此归隐田园。他是中国第一位田园诗人，被称为“古今隐逸诗人之宗”，有《陶渊明集》。');
INSERT INTO `poet_table` VALUES ('12', '刘禹锡', '刘禹锡（772－842），字梦得，汉族，中国唐朝彭城（今徐州）人，祖籍洛阳，唐朝文学家，哲学家，自称是汉中山靖王后裔，曾任监察御史，是王叔文政治改革集团的一员。唐代中晚期著名诗人，有“诗豪”之称。他的家庭是一个世代以儒学相传的书香门第。政治上主张革新，是王叔文派政治革新活动的中心人物之一。后来永贞革新失败被贬为朗州司马（今湖南常德）。据湖南常德历史学家、收藏家周新国先生考证刘禹锡被贬为朗州司马其间写了著名的“汉寿城春望”。');
INSERT INTO `poet_table` VALUES ('13', '杜牧', '杜牧（公元803－约852年），字牧之，号樊川居士，汉族，京兆万年（今陕西西安）人，唐代诗人。杜牧人称“小杜”，以别于杜甫。与李商隐并称“小李杜”。因晚年居长安南樊川别墅，故后世称“杜樊川”，著有《樊川文集》。');

-- ----------------------------
-- Table structure for `tb_idcard`
-- ----------------------------
DROP TABLE IF EXISTS `tb_idcard`;
CREATE TABLE `tb_idcard` (
  `id` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_idcard
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_node`
-- ----------------------------
DROP TABLE IF EXISTS `tb_node`;
CREATE TABLE `tb_node` (
  `pid` tinyint(30) NOT NULL,
  `fid` tinyint(30) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_node
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_orders`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
INSERT INTO `tb_orders` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `tb_person`
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `card` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `tb_poem`
-- ----------------------------
DROP TABLE IF EXISTS `tb_poem`;
CREATE TABLE `tb_poem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `dynasty` varchar(45) DEFAULT NULL,
  `poemId` int(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_poem
-- ----------------------------
INSERT INTO `tb_poem` VALUES ('76', '望庐山瀑布', '唐代', '1', '日照香炉生紫烟，遥看瀑布挂前川。飞流直下三千尺，疑是银河落九天。', '写景');
INSERT INTO `tb_poem` VALUES ('77', '黄鹤楼送孟浩然之广陵', '唐代', '1', '故人西辞黄鹤楼，烟花三月下扬州。孤帆远影碧空尽，唯见长江天际流。 (唯 通：惟)', '写景');
INSERT INTO `tb_poem` VALUES ('78', '赠汪伦', '唐代', '1', '李白乘舟将欲行，忽闻岸上踏歌声。桃花潭水深千尺，不及汪伦送我情。', '写景');
INSERT INTO `tb_poem` VALUES ('79', '望天门山', '唐代', '1', '天门中断楚江开，碧水东流至此回。两岸青山相对出，孤帆一片日边来。', '写景');
INSERT INTO `tb_poem` VALUES ('80', '清平调·其一', '唐代', '1', '云想衣裳花想容，春风拂槛露华浓。 若非群玉山头见，会向瑶台月下逢。', '咏物');
INSERT INTO `tb_poem` VALUES ('81', '早发白帝城 / 白帝下江陵', '唐代', '1', '朝辞白帝彩云间，千里江陵一日还。两岸猿声啼不住，轻舟已过万重山。', '咏物');
INSERT INTO `tb_poem` VALUES ('82', '春夜洛城闻笛 / 春夜洛阳城闻笛', '唐代', '1', '谁家玉笛暗飞声，散入春风满洛城。 此夜曲中闻折柳，何人不起故园情。', '咏物');
INSERT INTO `tb_poem` VALUES ('83', '峨眉山月歌', '唐代', '1', '峨眉山月半轮秋，影入平羌江水流。 夜发清溪向三峡，思君不见下渝州。', '咏物');
INSERT INTO `tb_poem` VALUES ('84', '独坐敬亭山', '唐代', '1', '众鸟高飞尽，孤云独去闲。相看两不厌，只有敬亭山。(只有 一作：唯有)', '咏物');
INSERT INTO `tb_poem` VALUES ('85', '夜宿山寺', '唐代', '1', '危楼高百尺，手可摘星辰。不敢高声语，恐惊天上人。', '春天');
INSERT INTO `tb_poem` VALUES ('86', '客中行 / 客中作', '唐代', '1', '兰陵美酒郁金香，玉碗盛来琥珀光。 但使主人能醉客，不知何处是他乡。', '春天');
INSERT INTO `tb_poem` VALUES ('88', '从军行·其二', '唐代', '1', '百战沙场碎铁衣，城南已合数重围。 突营射杀呼延将，独领残兵千骑归。', '春天');
INSERT INTO `tb_poem` VALUES ('89', '夏日山中', '唐代', '1', '懒摇白羽扇，裸袒青林中。脱巾挂石壁，露顶洒松风。', '春天');
INSERT INTO `tb_poem` VALUES ('90', '清平调·其二', '唐代', '1', '一枝红艳露凝香，云雨巫山枉断肠。借问汉宫谁得似，可怜飞燕倚新妆。', '春天');
INSERT INTO `tb_poem` VALUES ('91', '绝句', '宋代', '2', '两个黄鹂鸣翠柳，一行白鹭上青天。窗含西岭千秋雪，门泊东吴万里船。', '夏天');
INSERT INTO `tb_poem` VALUES ('92', '江南逢李龟年', '宋代', '2', '岐王宅里寻常见，崔九堂前几度闻。正是江南好风景，落花时节又逢君。', '夏天');
INSERT INTO `tb_poem` VALUES ('93', '江畔独步寻花', '宋代', '2', '黄四娘家花满蹊，千朵万朵压枝低。留连戏蝶时时舞，自在娇莺恰恰啼。', '夏天');
INSERT INTO `tb_poem` VALUES ('94', '江畔独步寻花·其五', '宋代', '2', '黄师塔前江水东，春光懒困倚微风。桃花一簇开无主，可爱深红爱浅红？', '夏天');
INSERT INTO `tb_poem` VALUES ('95', '赠花卿', '宋代', '2', '锦城丝管日纷纷，半入江风半入云。 此曲只应天上有，人间能得几回闻。', '夏天');
INSERT INTO `tb_poem` VALUES ('96', '八阵图', '宋代', '2', '功盖三分国，名成八阵图。（名成 一作：名高）江流石不转，遗恨失吞吴。', '秋天');
INSERT INTO `tb_poem` VALUES ('97', '绝句二首·其二', '宋代', '2', '江碧鸟逾白，山青花欲燃。今春看又过，何日是归年？', '秋天');
INSERT INTO `tb_poem` VALUES ('98', '绝句', '宋代', '2', '迟日江山丽，春风花草香。泥融飞燕子，沙暖睡鸳鸯。', '秋天');
INSERT INTO `tb_poem` VALUES ('99', '戏为六绝句·其二', '宋代', '2', '王杨卢骆当时体，轻薄为文哂未休。尔曹身与名俱灭，不废江河万古流。', '秋天');
INSERT INTO `tb_poem` VALUES ('100', '赠李白', '宋代', '2', '秋来相顾尚飘蓬，未就丹砂愧葛洪。 痛饮狂歌空度日，飞扬跋扈为谁雄。', '秋天');
INSERT INTO `tb_poem` VALUES ('101', '贫交行', '宋代', '2', '翻手作云覆手雨，纷纷轻薄何须数。(作 一作：为)君不见管鲍贫时交，此道今人弃如土。', '冬天');
INSERT INTO `tb_poem` VALUES ('102', '绝句漫兴九首·其五', '宋代', '2', '肠断江春欲尽头，杖藜徐步立芳洲。(江春 一作：春江)颠狂柳絮随风舞，轻薄桃花逐水流。(舞 一作：去)', '冬天');
INSERT INTO `tb_poem` VALUES ('103', '归雁', '宋代', '2', '东来万里客，乱定几年归？肠断江城雁，高高向北飞。', '冬天');
INSERT INTO `tb_poem` VALUES ('104', '绝句漫兴九首·其七', '宋代', '2', '糁径杨花铺白毡，点溪荷叶叠青钱。笋根雉子无人见，沙上凫雏傍母眠。', '冬天');
INSERT INTO `tb_poem` VALUES ('105', '武侯庙', '宋代', '2', '遗庙丹青落，空山草木长。犹闻辞后主，不复卧南阳。', '冬天');
INSERT INTO `tb_poem` VALUES ('106', '梅雨', '〔唐代〕', '2', '南京犀浦道，四月熟黄梅。湛湛长江去，冥冥细雨来。茅茨疏易湿，云雾密难开。竟日蛟龙喜，盘涡与岸回。', '春天');

-- ----------------------------
-- Table structure for `tb_table`
-- ----------------------------
DROP TABLE IF EXISTS `tb_table`;
CREATE TABLE `tb_table` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `age` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_table
-- ----------------------------
INSERT INTO `tb_table` VALUES ('6', '周杨智', '20185533130', '20');

-- ----------------------------
-- Table structure for `tb_task`
-- ----------------------------
DROP TABLE IF EXISTS `tb_task`;
CREATE TABLE `tb_task` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_task
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(200) DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` varchar(200) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `staus` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_user` VALUES ('15', 'admin', '1', '15', '15', '15', '15', '15', '1');
INSERT INTO `tb_user` VALUES ('16', '2', '2', '2', null, null, '2', '2', '0');
INSERT INTO `tb_user` VALUES ('17', '11', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `tb_user` VALUES ('18', '9', '9', '9', '9', '9', '9', '9', '0');
INSERT INTO `tb_user` VALUES ('19', '9', '9', '9', '9', '9', '9', '9', '0');
INSERT INTO `tb_user` VALUES ('21', 'hwl', '10', '男', '10', '10', '10', '10', '0');
INSERT INTO `tb_user` VALUES ('23', 'hwl', '10', '男', '10', '10', '10', '10', '0');
INSERT INTO `tb_user` VALUES ('24', 'hwl', '10', '男', '10', '10', '10', '10', '0');
INSERT INTO `tb_user` VALUES ('27', 'w', '1', '男', '2', '3', '4', '1', null);
INSERT INTO `tb_user` VALUES ('28', 'weilin huang', '', '男', '1', '1', '1', '1', null);
INSERT INTO `tb_user` VALUES ('29', 'hwl1', '1', '男', '18', '1965777605@qq.com', '1', '广州', null);
INSERT INTO `tb_user` VALUES ('30', '小何', '1', '男', '18', '18', '18', '18', null);
INSERT INTO `tb_user` VALUES ('31', 'lds', '123456', '男', '18', '654321', '123456', '98741', null);
INSERT INTO `tb_user` VALUES ('32', 'weilin huang', '2', '男', '1', '1', '2', '1', null);
INSERT INTO `tb_user` VALUES ('33', 'weilin huang', '', '男', '1', '1', '12121', '1', null);
INSERT INTO `tb_user` VALUES ('34', 'weilin huang', '1', '男', '1', '1', '21212121', '1', null);
INSERT INTO `tb_user` VALUES ('35', 'weilin huang', '123', '男', '1', '1965777605@qq.com', '11', '广州', null);
INSERT INTO `tb_user` VALUES ('36', 'weilin huang', '123', '男', '1', '1965777605@qq.com', '11', '广州', null);
INSERT INTO `tb_user` VALUES ('37', 'weilin huang', '123', '男', '18', '1965777605@qq.com', '1', '广州', null);
INSERT INTO `tb_user` VALUES ('38', 'weilin huang', '123', '男', '18', '1965777605@qq.com', '18', '广州', null);
INSERT INTO `tb_user` VALUES ('39', 'weilin huang', '123', '男', '1', '1', null, '广州', null);
INSERT INTO `tb_user` VALUES ('40', 'weilin huang2好', '11', '男', '1', '1', null, '广州', null);
INSERT INTO `tb_user` VALUES ('41', '我在这里', '1', '男', '1', '11111111111111111', null, '广州', null);
INSERT INTO `tb_user` VALUES ('42', 'weilin huang', '123456', '男', '18', '1965777605@qq.com', null, '广州', null);
INSERT INTO `tb_user` VALUES ('43', '小何三号机', '1', '男', '18', '11111', null, '深圳', null);
INSERT INTO `tb_user` VALUES ('44', 'å°ä½å¤§å¸å¥', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('45', 'å°ä½å¤§å¸å¥2å·', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('46', '123', '123', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('47', '%E4%BF%BA%E7%88%B8%E7%88%B8', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('48', '%E5%B0%8F%E4%BD%955%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('49', '%E5%B0%8F%E4%BD%956%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('50', '%E5%B0%8F%E4%BD%957%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('51', '%E5%B0%8F%E4%BD%958%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('52', '%E5%B0%8F%E4%BD%959%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('53', '%E5%B0%8F%E4%BD%9512%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('54', '%E5%B0%8F%E4%BD%9512%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('55', '%E5%B0%8F%E4%BD%9512%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('56', '%E5%B0%8F%E4%BD%9512%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('57', '%E5%B0%8F%E4%BD%9513%E5%8F%B7', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('59', '小何15号', '1', null, '0', null, null, null, null);
INSERT INTO `tb_user` VALUES ('60', 'åä¸ç', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `tb_user` VALUES ('61', 'åä¸ç', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `tb_user` VALUES ('62', 'ls', '123456', '1', '1', '1@qq.com', null, '1', null);
INSERT INTO `tb_user` VALUES ('63', '我叫刘东盛', '123456', '1', '1', '1@qq.com', null, '1', null);
