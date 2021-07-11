/*
這份 js 來源已經不可考,感謝創作者的辛勞
*/

var city=new Array(35);
var town=new Array(35);
town[0]=new Array(12);town[1]=new Array(29);town[2]=new Array(7);town[3]=new Array(12);town[4]=new Array(13);
town[5]=new Array(1);town[6]=new Array(13);town[7]=new Array(18);town[8]=new Array(8);town[9]=new Array(21);
town[10]=new Array(13);town[11]=new Array(26);town[12]=new Array(20);town[13]=new Array(1);town[14]=new Array(18);
town[15]=new Array(7);town[16]=new Array(31);town[17]=new Array(11);town[18]=new Array(27);town[19]=new Array(33);
town[20]=new Array(13);town[21]=new Array(16);town[22]=new Array(6);town[23]=new Array(6);town[24]=new Array(4);
town[25]=new Array(6);town[26]=new Array(18);town[27]=new Array(3);town[28]=new Array(50);town[29]=new Array(1);
town[30]=new Array(1);town[31]=new Array(1);town[32]=new Array(1);town[33]=new Array(1);town[34]=new Array(1);

city[0]=new Option('台北市','0');town[0][0]=new Option('100中正區','0');town[0][1]=new Option('103大同區','1');town[0][2]=new Option('104中山區','2');town[0][3]=new Option('105松山區','3');town[0][4]=new Option('106大安區','4');town[0][5]=new Option('108萬華區','5');town[0][6]=new Option('110信義區','6');town[0][7]=new Option('111士林區','7');town[0][8]=new Option('112北投區','8');town[0][9]=new Option('114內湖區','9');town[0][10]=new Option('115南港區','10');town[0][11]=new Option('116文山區','11');
city[1]=new Option('新北市','1');town[1][0]=new Option('207萬里區','0');town[1][1]=new Option('208金山區','1');town[1][2]=new Option('220板橋區','2');town[1][3]=new Option('221汐止區','3');town[1][4]=new Option('222深坑區','4');town[1][5]=new Option('223石碇區','5');town[1][6]=new Option('224瑞芳區','6');town[1][7]=new Option('226平溪區','7');town[1][8]=new Option('227雙溪區','8');town[1][9]=new Option('228貢寮區','9');town[1][10]=new Option('231新店區','10');town[1][11]=new Option('232坪林區','11');town[1][12]=new Option('233烏來區','12');town[1][13]=new Option('234永和區','13');town[1][14]=new Option('235中和區','14');town[1][15]=new Option('236土城區','15');town[1][16]=new Option('237三峽區','16');town[1][17]=new Option('238樹林區','17');town[1][18]=new Option('239鶯歌區','18');town[1][19]=new Option('241三重區','19');town[1][20]=new Option('242新莊區','20');town[1][21]=new Option('243泰山區','21');town[1][22]=new Option('244林口區','22');town[1][23]=new Option('247蘆洲區','23');town[1][24]=new Option('248五股區','24');town[1][25]=new Option('249八里區','25');town[1][26]=new Option('251淡水區','26');town[1][27]=new Option('252三芝區','27');town[1][28]=new Option('253石門區','28');
city[2]=new Option('基隆市','2');town[2][0]=new Option('200仁愛區','0');town[2][1]=new Option('201信義區','1');town[2][2]=new Option('202中正區','2');town[2][3]=new Option('203中山區','3');town[2][4]=new Option('204安樂區','4');town[2][5]=new Option('205暖暖區','5');town[2][6]=new Option('206七堵區','6');
city[3]=new Option('宜蘭縣','3');town[3][0]=new Option('260宜蘭市','0');town[3][1]=new Option('261頭城鎮','1');town[3][2]=new Option('262礁溪鄉','2');town[3][3]=new Option('263壯圍鄉','3');town[3][4]=new Option('264員山鄉','4');town[3][5]=new Option('265羅東鎮','5');town[3][6]=new Option('266三星鄉','6');town[3][7]=new Option('267大同鄉','7');town[3][8]=new Option('268五結鄉','8');town[3][9]=new Option('269冬山鄉','9');town[3][10]=new Option('270蘇澳鎮','10');town[3][11]=new Option('272南澳鄉','11');
city[4]=new Option('桃園市','4');town[4][0]=new Option('320中壢市','0');town[4][1]=new Option('324平鎮市','1');town[4][2]=new Option('325龍潭鄉','2');town[4][3]=new Option('326楊梅鎮','3');town[4][4]=new Option('327新屋鄉','4');town[4][5]=new Option('328觀音鄉','5');town[4][6]=new Option('330桃園市','6');town[4][7]=new Option('333龜山鄉','7');town[4][8]=new Option('334八德市','8');town[4][9]=new Option('335大溪鎮','9');town[4][10]=new Option('336復興鄉','10');town[4][11]=new Option('337大園鄉','11');town[4][12]=new Option('338蘆竹鄉','12');
city[5]=new Option('300新竹市','5');town[5][0]=new Option('300新竹區','0');
city[6]=new Option('新竹縣','6');town[6][0]=new Option('302竹北市','0');town[6][1]=new Option('303湖口鄉','1');town[6][2]=new Option('304新豐鄉','2');town[6][3]=new Option('305新埔鎮','3');town[6][4]=new Option('306關西鎮','4');town[6][5]=new Option('307芎林鄉','5');town[6][6]=new Option('308寶山鄉','6');town[6][7]=new Option('310竹東鎮','7');town[6][8]=new Option('311五峰鄉','8');town[6][9]=new Option('312橫山鄉','9');town[6][10]=new Option('313尖石鄉','10');town[6][11]=new Option('314北埔鄉','11');town[6][12]=new Option('315峨眉鄉','12');
city[7]=new Option('苗栗縣','7');town[7][0]=new Option('350竹南鎮','0');town[7][1]=new Option('351頭份鎮','1');town[7][2]=new Option('352三灣鄉','2');town[7][3]=new Option('353南庄鄉','3');town[7][4]=new Option('354獅潭鄉','4');town[7][5]=new Option('356後龍鎮','5');town[7][6]=new Option('357通宵鎮','6');town[7][7]=new Option('358苑裡鎮','7');town[7][8]=new Option('360苗栗市','8');town[7][9]=new Option('361造橋鄉','9');town[7][10]=new Option('362頭屋鄉','10');town[7][11]=new Option('363公館鄉','11');town[7][12]=new Option('364大湖鄉','12');town[7][13]=new Option('365泰安鄉','13');town[7][14]=new Option('366銅鑼鄉','14');town[7][15]=new Option('367三義鄉','15');town[7][16]=new Option('368西湖鄉','16');town[7][17]=new Option('369卓蘭鎮','17');
city[8]=new Option('台中市','8');town[8][0]=new Option('400中區','0');town[8][1]=new Option('401東區','1');town[8][2]=new Option('402南區','2');town[8][3]=new Option('403西區','3');town[8][4]=new Option('404北區','4');town[8][5]=new Option('406北屯區','5');town[8][6]=new Option('407西屯區','6');town[8][7]=new Option('408南屯區','7');
city[9]=new Option('台中縣','9');town[9][0]=new Option('411太平市','0');town[9][1]=new Option('412大里市','1');town[9][2]=new Option('413霧峰鄉','2');town[9][3]=new Option('414烏日鄉','3');town[9][4]=new Option('420豐原市','4');town[9][5]=new Option('421后里鄉','5');town[9][6]=new Option('422石岡鄉','6');town[9][7]=new Option('423東勢鎮','7');town[9][8]=new Option('424和平鄉','8');town[9][9]=new Option('426新社鄉','9');town[9][10]=new Option('427潭子鄉','10');town[9][11]=new Option('428大雅鄉','11');town[9][12]=new Option('429神岡鄉','12');town[9][13]=new Option('432大肚鄉','13');town[9][14]=new Option('433沙鹿鎮','14');town[9][15]=new Option('434龍井鄉','15');town[9][16]=new Option('435梧棲鎮','16');town[9][17]=new Option('436清水鎮','17');town[9][18]=new Option('437大甲鎮','18');town[9][19]=new Option('438外埔鄉','19');town[9][20]=new Option('439大安鄉','20');
city[10]=new Option('南投縣','10');town[10][0]=new Option('540南投市 ','0');town[10][1]=new Option('541中寮鄉','1');town[10][2]=new Option('542草屯鎮','2');town[10][3]=new Option('544國姓鄉','3');town[10][4]=new Option('545埔里鎮','4');town[10][5]=new Option('546仁愛鄉','5');town[10][6]=new Option('511名間','6');town[10][7]=new Option('552集集鎮','7');town[10][8]=new Option('553水里鄉','8');town[10][9]=new Option('555魚池鄉','9');town[10][10]=new Option('556信義鄉','10');town[10][11]=new Option('557竹山鎮','11');town[10][12]=new Option('558鹿谷鄉','12');
city[11]=new Option('彰化縣','11');town[11][0]=new Option('500彰化市','0');town[11][1]=new Option('502芬園鄉','1');town[11][2]=new Option('503花壇鄉','2');town[11][3]=new Option('504秀水鄉','3');town[11][4]=new Option('505鹿港鎮','4');town[11][5]=new Option('506福興鄉','5');town[11][6]=new Option('507線西鄉','6');town[11][7]=new Option('508和美鄉','7');town[11][8]=new Option('509伸港鄉','8');town[11][9]=new Option('510員林鎮','9');town[11][10]=new Option('511社頭鄉','10');town[11][11]=new Option('512永靖鄉','11');town[11][12]=new Option('513埔心鄉','12');town[11][13]=new Option('514溪湖鎮','13');town[11][14]=new Option('515大村鄉','14');town[11][15]=new Option('516埔鹽鄉','15');town[11][16]=new Option('520田中鎮','16');town[11][17]=new Option('521北斗鎮','17');town[11][18]=new Option('522田尾鄉','18');town[11][19]=new Option('523埤頭鄉','19');town[11][20]=new Option('524溪洲','20');town[11][21]=new Option('525竹塘鄉','21');town[11][22]=new Option('526二林鎮','22');town[11][23]=new Option('527大城','23');town[11][24]=new Option('528芳苑鄉','24');town[11][25]=new Option('530二水鄉','25');
city[12]=new Option('雲林縣','12');town[12][0]=new Option('530斗南鎮','0');town[12][1]=new Option('631大埤鄉','1');town[12][2]=new Option('632虎尾鎮','2');town[12][3]=new Option('633土庫鎮','3');town[12][4]=new Option('634褒忠鄉','4');town[12][5]=new Option('635東勢鄉','5');town[12][6]=new Option('636台西鄉','6');town[12][7]=new Option('637崙背鄉','7');town[12][8]=new Option('638麥寮鄉','8');town[12][9]=new Option('640斗六市','9');town[12][10]=new Option('643林內鄉','10');town[12][11]=new Option('646古坑鄉','11');town[12][12]=new Option('647薊桐','12');town[12][13]=new Option('648西螺鎮','13');town[12][14]=new Option('649二崙鄉','14');town[12][15]=new Option('651北港鎮','15');town[12][16]=new Option('652水林鄉','16');town[12][17]=new Option('653口湖鄉','17');town[12][18]=new Option('654四湖鄉','18');town[12][19]=new Option('655元長鄉','19');
city[13]=new Option('嘉義市','13');town[13][0]=new Option('600','0');
city[14]=new Option('嘉義縣','14');town[14][0]=new Option('602番路鄉','0');town[14][1]=new Option('603梅山鄉','1');town[14][2]=new Option('604竹崎鄉','2');town[14][3]=new Option('605阿里山','3');town[14][4]=new Option('606中埔鄉','4');town[14][5]=new Option('607大埔鄉','5');town[14][6]=new Option('608水上鄉','6');town[14][7]=new Option('611鹿草鄉','7');town[14][8]=new Option('612太保市','8');town[14][9]=new Option('613朴子市','9');town[14][10]=new Option('614東石鄉','10');town[14][11]=new Option('615六腳鄉','11');town[14][12]=new Option('616新港鄉','12');town[14][13]=new Option('621民雄鄉','13');town[14][14]=new Option('622大林鎮','14');town[14][15]=new Option('623溪口鄉','15');town[14][16]=new Option('624義竹鄉','16');town[14][17]=new Option('625布袋鎮','17');
city[15]=new Option('台南市','15');town[15][0]=new Option('700中區','0');town[15][1]=new Option('701東區','1');town[15][2]=new Option('702南區','2');town[15][3]=new Option('703西區','3');town[15][4]=new Option('704北區','4');town[15][5]=new Option('708安平區','5');town[15][6]=new Option('709安南區','6');
city[16]=new Option('台南縣','16');town[16][0]=new Option('710永康市','0');town[16][1]=new Option('711歸仁鄉','1');town[16][2]=new Option('712新化鎮','2');town[16][3]=new Option('713左鎮鄉','3');town[16][4]=new Option('714玉井鄉','4');town[16][5]=new Option('715楠西鄉','5');town[16][6]=new Option('716南化鄉','6');town[16][7]=new Option('717仁德鄉','7');town[16][8]=new Option('718關廟鄉','8');town[16][9]=new Option('719龍崎鄉','9');town[16][10]=new Option('720官田鄉','10');town[16][11]=new Option('721麻豆鎮','11');town[16][12]=new Option('722佳里鎮','12');town[16][13]=new Option('723西港鄉','13');town[16][14]=new Option('724七股鄉','14');town[16][15]=new Option('725將軍鄉','15');town[16][16]=new Option('726學甲鎮','16');town[16][17]=new Option('727北門鄉','17');town[16][18]=new Option('730新營市','18');town[16][19]=new Option('731後壁鄉','19');town[16][20]=new Option('732白河鎮','20');town[16][21]=new Option('733東山鄉','21');town[16][22]=new Option('734六甲鄉','22');town[16][23]=new Option('735下營鄉','23');town[16][24]=new Option('731柳營鄉','24');town[16][25]=new Option('737鹽水鎮','25');town[16][26]=new Option('741善化鎮','26');town[16][27]=new Option('742大內鄉','27');town[16][28]=new Option('743山上鄉','28');town[16][29]=new Option('745安定鄉','29');town[16][30]=new Option('744新市鄉','30');
city[17]=new Option('高雄市','17');town[17][0]=new Option('800新興區','0');town[17][1]=new Option('801前金區','1');town[17][2]=new Option('802苓雅區','2');town[17][3]=new Option('803鹽埕區','3');town[17][4]=new Option('804鼓山區','4');town[17][5]=new Option('805旗津區','5');town[17][6]=new Option('806前鎮區','6');town[17][7]=new Option('807三民區','7');town[17][8]=new Option('811楠梓區','8');town[17][9]=new Option('812小港區','9');town[17][10]=new Option('813左營區','10');
city[18]=new Option('高雄縣','18');town[18][0]=new Option('814仁武鄉','0');town[18][1]=new Option('815大社鄉','1');town[18][2]=new Option('820岡山鎮','2');town[18][3]=new Option('821路竹鄉','3');town[18][4]=new Option('822阿蓮鄉','4');town[18][5]=new Option('823田寮鄉','5');town[18][6]=new Option('824燕巢鄉','6');town[18][7]=new Option('825橋頭鄉','7');town[18][8]=new Option('826梓官鄉','8');town[18][9]=new Option('827彌陀鄉','9');town[18][10]=new Option('828永安鄉','10');town[18][11]=new Option('829湖內鄉','11');town[18][12]=new Option('830鳳山市','12');town[18][13]=new Option('831大寮鄉','13');town[18][14]=new Option('832林園鄉','14');town[18][15]=new Option('833鳥松鄉','15');town[18][16]=new Option('840大樹鄉','16');town[18][17]=new Option('842旗山鎮','17');town[18][18]=new Option('843美濃鎮','18');town[18][19]=new Option('844六龜鄉','19');town[18][20]=new Option('845內門鄉','20');town[18][21]=new Option('846杉林鄉','21');town[18][22]=new Option('847甲仙鄉','22');town[18][23]=new Option('848桃源鄉','23');town[18][24]=new Option('849三民鄉','24');town[18][25]=new Option('851茂林鄉','25');town[18][26]=new Option('852茄萣鄉','26');
city[19]=new Option('屏東縣','19');town[19][0]=new Option('900屏東市','0');town[19][1]=new Option('901三地門','1');town[19][2]=new Option('902霧臺鄉','2');town[19][3]=new Option('903瑪家鄉','3');town[19][4]=new Option('904九如鄉','4');town[19][5]=new Option('905里港鄉','5');town[19][6]=new Option('906高樹鄉','6');town[19][7]=new Option('907鹽埔鄉','7');town[19][8]=new Option('908長治鄉','8');town[19][9]=new Option('909麟洛鄉','9');town[19][10]=new Option('911竹田鄉','10');town[19][11]=new Option('912內埔鄉','11');town[19][12]=new Option('913萬丹鄉','12');town[19][13]=new Option('920潮州鎮','13');town[19][14]=new Option('921泰武鄉','14');town[19][15]=new Option('922來義鄉','15');town[19][16]=new Option('923萬巒鄉','16');town[19][17]=new Option('924嵌頂鄉','17');town[19][18]=new Option('925新埤鄉','18');town[19][19]=new Option('926南州鄉','19');town[19][20]=new Option('927林邊鄉','20');town[19][21]=new Option('928東港鎮','21');town[19][22]=new Option('929琉球鄉','22');town[19][23]=new Option('931佳冬鄉','23');town[19][24]=new Option('932新園鄉','24');town[19][25]=new Option('940枋寮鄉','25');town[19][26]=new Option('941枋山鄉','26');town[19][27]=new Option('942春日鄉','27');town[19][28]=new Option('943獅子鄉','28');town[19][29]=new Option('944車城鄉','29');town[19][30]=new Option('945牡丹鄉','30');town[19][31]=new Option('946恆春鎮','31');town[19][32]=new Option('947滿洲鄉','32');
city[20]=new Option('花蓮縣','20');town[20][0]=new Option('970花蓮市','0');town[20][1]=new Option('971新城鄉','1');town[20][2]=new Option('972秀林鄉','2');town[20][3]=new Option('973吉安鄉','3');town[20][4]=new Option('974壽豐鄉','4');town[20][5]=new Option('975鳳林鎮','5');town[20][6]=new Option('976光復鄉','6');town[20][7]=new Option('977豐濱鄉','7');town[20][8]=new Option('978瑞穗鄉','8');town[20][9]=new Option('979萬榮鄉','9');town[20][10]=new Option('981玉里鎮','10');town[20][11]=new Option('982卓溪鄉','11');town[20][12]=new Option('983富里鄉','12');
city[21]=new Option('台東縣','21');town[21][0]=new Option('950台東市','0');town[21][1]=new Option('951綠島鄉','1');town[21][2]=new Option('952蘭嶼鄉','2');town[21][3]=new Option('953延平鄉','3');town[21][4]=new Option('954卑南鄉','4');town[21][5]=new Option('955鹿野鄉','5');town[21][6]=new Option('956關山鎮','6');town[21][7]=new Option('957海端鄉','7');town[21][8]=new Option('958池上鄉','8');town[21][9]=new Option('959東河鄉','9');town[21][10]=new Option('961成功鎮','10');town[21][11]=new Option('962長濱鄉','11');town[21][12]=new Option('963太麻里鄉','12');town[21][13]=new Option('964金峰鄉','13');town[21][14]=new Option('965大武鄉','14');town[21][15]=new Option('966達仁鄉','15');
city[22]=new Option('澎湖縣','22');town[22][0]=new Option('880馬公市','0');town[22][1]=new Option('881西嶼鄉','1');town[22][2]=new Option('882望安鄉','2');town[22][3]=new Option('883七美鄉','3');town[22][4]=new Option('884白沙鄉','4');town[22][5]=new Option('885湖西鄉','5');
city[23]=new Option('金門縣','23');town[23][0]=new Option('890金沙鎮','0');town[23][1]=new Option('891金湖鎮','1');town[23][2]=new Option('892金寧鄉','2');town[23][3]=new Option('893金城鎮','3');town[23][4]=new Option('894烈嶼鄉','4');town[23][5]=new Option('896烏坵','5');
city[24]=new Option('連江縣','24');town[24][0]=new Option('209南竿鄉','0');town[24][1]=new Option('210北竿鄉','1');town[24][2]=new Option('211莒光鄉','2');town[24][3]=new Option('212東引鄉','3');
city[25]=new Option('南海群島','25');town[25][0]=new Option('290釣魚台','0');town[25][1]=new Option('817東沙','1');town[25][2]=new Option('819南沙','2');town[25][3]=new Option('山上','3');town[25][4]=new Option('新市','4');town[25][5]=new Option('安定','5');
city[26]=new Option('中國','26');town[26][0]=new Option('北京','0');town[26][1]=new Option('上海','1');town[26][2]=new Option('蘇州','2');town[26][3]=new Option('昆山','3');town[26][4]=new Option('天津','4');town[26][5]=new Option('重慶','5');town[26][6]=new Option('廈門','6');town[26][7]=new Option('福州','7');town[26][8]=new Option('漳州','8');town[26][9]=new Option('廣州','9');town[26][10]=new Option('深圳','10');town[26][11]=new Option('東莞','11');town[26][12]=new Option('珠海','12');town[26][13]=new Option('中山','13');town[26][14]=new Option('惠州','14');town[26][15]=new Option('汕頭','15');town[26][16]=new Option('香港','16');town[26][17]=new Option('澳門','17');
city[27]=new Option('亞洲','27');town[27][0]=new Option('日本','0');town[27][1]=new Option('韓國','1');town[27][2]=new Option('泰國','2');
city[28]=new Option('美國','28');town[28][0]=new Option('Alabama','0');town[28][1]=new Option('Alaska','1');town[28][2]=new Option('Arizona','2');town[28][3]=new Option('Arkansas','3');town[28][4]=new Option('California','4');town[28][5]=new Option('Colorado','5');town[28][6]=new Option('Connecticut','6');town[28][7]=new Option('Delaware','7');town[28][8]=new Option('District of Columbia','8');town[28][9]=new Option('Florida','9');town[28][10]=new Option('Georgia','10');town[28][11]=new Option('Idaho','11');town[28][12]=new Option('Illinois','12');town[28][13]=new Option('Indiana','13');town[28][14]=new Option('Iowa','14');town[28][15]=new Option('Kansas','15');town[28][16]=new Option('Kentucky','16');town[28][17]=new Option('Louisiana','17');town[28][18]=new Option('Maine','18');town[28][19]=new Option('Maryland','19');town[28][20]=new Option('Massachusetts','20');town[28][21]=new Option('Michigan','21');town[28][22]=new Option('Minnesota','22');town[28][23]=new Option('Mississippi','23');town[28][24]=new Option('Missouri','24');town[28][25]=new Option('Montana','25');town[28][26]=new Option('Nebraska','26');town[28][27]=new Option('Nevada','27');town[28][28]=new Option('New Hampshire','28');town[28][29]=new Option('New Jersey','29');town[28][30]=new Option('New Mexico','30');town[28][31]=new Option('New York','31');town[28][32]=new Option('North Carolina','32');town[28][33]=new Option('North Dakota','33');town[28][34]=new Option('Ohio','34');town[28][35]=new Option('Oklahoma','35');town[28][36]=new Option('Oregon','36');town[28][37]=new Option('Pennsylvania','37');town[28][38]=new Option('Rhode Island','38');town[28][39]=new Option('South Carolina','39');town[28][40]=new Option('South Dakota','40');town[28][41]=new Option('Tennessee','41');town[28][42]=new Option('Texas','42');town[28][43]=new Option('Utah','43');town[28][44]=new Option('Vermont','44');town[28][45]=new Option('Virginia','45');town[28][46]=new Option('Washington','46');town[28][47]=new Option('West Virginia','47');town[28][48]=new Option('Wisconsin','48');town[28][49]=new Option('Wyoming','49');
city[29]=new Option('加拿大','29');town[29][0]=new Option('','0');
city[30]=new Option('中南美洲','30');town[30][0]=new Option('','0');
city[31]=new Option('歐洲','31');town[31][0]=new Option('','0');
city[32]=new Option('澳洲','32');town[32][0]=new Option('','0');
city[33]=new Option('非洲','33');town[33][0]=new Option('','0');
city[34]=new Option('城市名','34');town[34][0]=new Option('','0');
function cityOnChange(cityObj,townObj){
	var cityIndex=cityObj.options.selectedIndex;
	var oldTownLen=townObj.options.length;
	var newTownLen=town[cityIndex].length;
	var sIndex;
	
	for(i=oldTownLen-1; i>0 ;i--){
		townObj.options[i]=null;
	}
	
	for(i=0; i<newTownLen ;i++){
		townObj.options[i]=new Option(town[cityIndex][i].text, town[cityIndex][i].value);
	}
	
}

function cityOnLoad(cityObj,townObj){
	var cityIndex=cityObj.options.selectedIndex;
	var townIndex=townObj.options.selectedIndex;
	var oldTownLen=townObj.options.length;
	var newTownLen=town[cityIndex].length;
	
	for(i=oldTownLen-1; i>0 ;i--){
		townObj.options[i]=null;
	}
	
	for(i=0; i<newTownLen ;i++){
		townObj.options[i]=new Option(town[cityIndex][i].text, town[cityIndex][i].value);
	}
	
	if(townIndex>=newTownLen){
		townIndex=0;
	}
	
	//townObj.options[townIndex].selected=true;
	
	cityOnChange(cityObj,townObj);
}

	

function townValue(cityObj,townObj){
	var cityIndex=cityObj.options.selectedIndex;
	var townIndex=townObj.options.selectedIndex;
	var oldTownLen=townObj.options.length;
	var newTownLen=town[cityIndex].length;
	
	for(i=oldTownLen-1; i>0 ;i--){
		townObj.options[i]=null;
	}
	
	for(i=0; i<newTownLen ;i++){
		townObj.options[i]=new Option(town[cityIndex][i].text, town[cityIndex][i].value);
	}
	
	townObj.options[townIndex].selected=true;
	
	var townVal='';
	
	townVal=townObj.options[townIndex].text;
	return townVal;
}
