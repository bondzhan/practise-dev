/**   
* @Title: RSAUtil.java 
* @Package com.bond.dev 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年2月23日 下午3:59:16 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/** 
* @ClassName: RSAUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017年2月23日 下午3:59:16 
*  
*/
public class RSAUtil {

	/** 指定加密算法为RSA */  
    private static final String ALGORITHM = "RSA";  
    /** 指定公钥存放文件 */  
    private static String PUBLIC_KEY_FILE = "PublicKey";  
    /** 指定私钥存放文件 */  
    private static String PRIVATE_KEY_FILE = "PrivateKey";  
  
    public static void main(String[] args) throws Exception {  
          
//        String source = "{\"retCode\":200,\"retMsg\":\"OK\",\"retEntity\":{\"freightTotal\":\"0.00\",\"checkShopcar\":\"0\",\"cartTotal\":0,\"detailNum\":15,\"pages\":0,\"singleLimit\":{\"1\":\"200000\",\"2\":\"200000\",\"3\":null,\"4\":null},\"categoryCount\":7,\"priceTotal\":\"5133.95\",\"buyNumTotal\":54,\"cartResult\":[{\"fgoodsShopcarId\":544,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"SJS20216-Y\",\"fskuSn\":null,\"fgoodsName\":\"goldnust 越南 歌娜 腰果系列  227g\",\"fgoodsPrice\":2933,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":15,\"fgoodsType\":3,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":\"詹先生\",\"fdeliveryAddr\":\"软件产业园基地\",\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":\"15012681079\",\"fdeliveryCardid\":\"421111111111111111\",\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":43995,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":439.95,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"15\",\"fpicFile\":\"M00/00/1C/eEwrGVg-p8qAd2kcAABSU2RZMco006.jpg\",\"priceList\":[{\"frangeEnd\":14,\"findex\":21387,\"frangeStart\":1,\"fmemberAmount\":\"32.00\"},{\"frangeEnd\":15,\"findex\":21389,\"frangeStart\":15,\"fmemberAmount\":\"29.33\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":96,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":510000,\"farea\":510109,\"fcity\":510100,\"maxBuyNum\":15,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":423,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS17151-J\",\"fskuSn\":null,\"fgoodsName\":\"Nutrilon 荷兰 牛栏 奶粉 3段 铁罐装 10-12个月  800g\",\"fgoodsPrice\":13300,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":4,\"fgoodsType\":2,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":53200,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":532,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"4\",\"fmaxNo\":\"4\",\"fpicFile\":\"M00/00/47/eEwrGVhJTWSAKZosAAFqxoYFSTc786.jpg\",\"priceList\":[{\"frangeEnd\":4,\"findex\":20627,\"frangeStart\":4,\"fmemberAmount\":\"133.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":4,\"minBuyNum\":4,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":421,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"HJD04858-J\",\"fskuSn\":null,\"fgoodsName\":\"BRITA 德国 碧然德 净水壶 蓝色  2.4L\",\"fgoodsPrice\":14100,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":15,\"fgoodsType\":2,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":211500,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":2115,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"-1\",\"fpicFile\":\"M00/00/51/eEwrGVhOD46AGBeiAAA3I6x1nog080.jpg\",\"priceList\":[{\"findex\":23753,\"frangeStart\":1,\"fmemberAmount\":\"141.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":155,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":-1,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":416,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"GMH04132-B\",\"fskuSn\":null,\"fgoodsName\":\"日本 绢肌物语豆乳化妆水 170ml\",\"fgoodsPrice\":4000,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":4000,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":40,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"20\",\"fpicFile\":\"M00/00/50/eEwrGVhKtM2AQK7xAAAUCpVmiTA585.jpg\",\"priceList\":[{\"frangeEnd\":20,\"findex\":18725,\"frangeStart\":1,\"fmemberAmount\":\"40.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":20,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":415,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"GCX16038-Y\",\"fskuSn\":null,\"fgoodsName\":\"kissme 日本 伊势半眉笔-深棕色\",\"fgoodsPrice\":4500,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":2,\"fgoodsType\":3,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":9000,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":60,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"-1\",\"fpicFile\":\"M00/00/2D/eEwrGVg_y8GAC2vWAAAt2T0e3wE222.jpg\",\"priceList\":[{\"frangeEnd\":1,\"findex\":21937,\"frangeStart\":1,\"fmemberAmount\":\"36.00\"},{\"findex\":21939,\"frangeStart\":2,\"fmemberAmount\":\"30.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":162,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":-1,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":385,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"GMH18488-J\",\"fskuSn\":null,\"fgoodsName\":\"FORENCOS 韩国 宋钟基代言面膜-7DAYS-星期一燕窝面膜 10片\",\"fgoodsPrice\":9800,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":2,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":9800,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":98,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"-1\",\"fpicFile\":\"M00/00/59/eEwrGVhbn0eAIgCbAAA1Wc6tuPQ783.jpg\",\"priceList\":[{\"findex\":21299,\"frangeStart\":1,\"fmemberAmount\":\"98.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":58,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":-1,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":194,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"GMH04194-B\",\"fskuSn\":null,\"fgoodsName\":\"JAYJUN 韩国 水光干细胞面膜 25ml*10\",\"fgoodsPrice\":9900,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":9900,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":99,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"-1\",\"fpicFile\":\"M00/00/50/eEwrGVhLwNqAcKisAACot7wwdRs028.jpg\",\"priceList\":[{\"findex\":21093,\"frangeStart\":1,\"fmemberAmount\":\"99.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":-1,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":160,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"HCP18239-Y\",\"fskuSn\":null,\"fgoodsName\":\"CHANTE CLAIR 意大利 公鸡头 马赛洗衣皂  300g\",\"fgoodsPrice\":2600,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":3,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":2600,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":26,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"10\",\"fpicFile\":\"M00/00/31/eEwrGVg_4GWAQZrPAAAx1LEckd0160.jpg\",\"priceList\":[{\"frangeEnd\":10,\"findex\":14357,\"frangeStart\":1,\"fmemberAmount\":\"26.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":10,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":159,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"HCP18239-Y\",\"fskuSn\":null,\"fgoodsName\":\"CHANTE CLAIR 意大利 公鸡头 马赛洗衣皂  300g\",\"fgoodsPrice\":2600,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":3,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":2600,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":26,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"10\",\"fpicFile\":\"M00/00/31/eEwrGVg_4GWAQZrPAAAx1LEckd0160.jpg\",\"priceList\":[{\"frangeEnd\":10,\"findex\":14357,\"frangeStart\":1,\"fmemberAmount\":\"26.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":10,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":104,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"GMH04194-B\",\"fskuSn\":null,\"fgoodsName\":\"JAYJUN 韩国 水光干细胞面膜 25ml*10\",\"fgoodsPrice\":9900,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":\"詹先生\",\"fdeliveryAddr\":\"软件产业园基地\",\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":\"15012681079\",\"fdeliveryCardid\":\"421111111111111111\",\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":9900,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":99,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"-1\",\"fpicFile\":\"M00/00/50/eEwrGVhLwNqAcKisAACot7wwdRs028.jpg\",\"priceList\":[{\"findex\":21093,\"frangeStart\":1,\"fmemberAmount\":\"99.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":440000,\"farea\":440305,\"fcity\":440300,\"maxBuyNum\":-1,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":30,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS03719-B\",\"fskuSn\":null,\"fgoodsName\":\"Aptamil 德国 爱他美 奶粉 3段（10-12个月）  800g\",\"fgoodsPrice\":15200,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":15200,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":149,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"6\",\"fpicFile\":\"M00/00/44/eEwrGVhHqP2ALggIAAEbBPcLZk0847.jpg\",\"priceList\":[{\"frangeEnd\":1,\"findex\":23981,\"frangeStart\":1,\"fmemberAmount\":\"149.00\"},{\"frangeEnd\":6,\"findex\":23983,\"frangeStart\":2,\"fmemberAmount\":\"141.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":6,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":26,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS17151-J\",\"fskuSn\":null,\"fgoodsName\":\"荷兰牛栏Nutrilon奶粉 3段 铁罐装（10-12个月）800g\",\"fgoodsPrice\":13300,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":4,\"fgoodsType\":2,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":53200,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":532,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"4\",\"fmaxNo\":\"4\",\"fpicFile\":\"M00/00/47/eEwrGVhJTWSAKZosAAFqxoYFSTc786.jpg\",\"priceList\":[{\"frangeEnd\":4,\"findex\":20627,\"frangeStart\":4,\"fmemberAmount\":\"133.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":4,\"minBuyNum\":4,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":25,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS17151-J\",\"fskuSn\":null,\"fgoodsName\":\"荷兰牛栏Nutrilon奶粉 3段 铁罐装（10-12个月）800g\",\"fgoodsPrice\":13300,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":4,\"fgoodsType\":2,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":\"詹先生\",\"fdeliveryAddr\":\"软件产业园基地\",\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":\"15012681079\",\"fdeliveryCardid\":\"421111111111111111\",\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":53200,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":532,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"4\",\"fmaxNo\":\"4\",\"fpicFile\":\"M00/00/47/eEwrGVhJTWSAKZosAAFqxoYFSTc786.jpg\",\"priceList\":[{\"frangeEnd\":4,\"findex\":20627,\"frangeStart\":4,\"fmemberAmount\":\"133.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":440000,\"farea\":440305,\"fcity\":440300,\"maxBuyNum\":4,\"minBuyNum\":4,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":0,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":19,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS03935-B\",\"fskuSn\":null,\"fgoodsName\":\"新西兰A2奶粉白金装 3段（1岁以上）900g\",\"fgoodsPrice\":14500,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":1,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":14500,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":162,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"6\",\"fpicFile\":\"M00/00/74/eEwrGViWhrmATaNCAAH347CH7Zs102.jpg\",\"priceList\":[{\"frangeEnd\":1,\"findex\":22789,\"frangeStart\":1,\"fmemberAmount\":\"162.00\"},{\"frangeEnd\":6,\"findex\":22791,\"frangeStart\":2,\"fmemberAmount\":\"155.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":0,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":6,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null},{\"fgoodsShopcarId\":16,\"fuserId\":null,\"forderSource\":null,\"fgoodsAddMode\":null,\"fskuId\":\"MBS03927-B\",\"fskuSn\":null,\"fgoodsName\":\"英国牛栏Cow & Gate奶粉 4段（2-3岁）800g\",\"fgoodsPrice\":12000,\"fgoodsRealPrice\":null,\"goodsPrice\":null,\"goodsRealPrice\":null,\"fstandardDesc\":null,\"fgoodsPromotionDesc\":null,\"fbuyNum\":2,\"fgoodsType\":1,\"ffreightId\":null,\"ffreightDesc\":null,\"flogisticsOrder\":null,\"fcompanyId\":null,\"fdeliveryName\":null,\"fdeliveryAddr\":null,\"fdeliveryPostcode\":null,\"fdeliveryTel\":null,\"fdeliveryMobile\":null,\"fdeliveryCardid\":null,\"fremarkId\":null,\"fbuyerRemark\":null,\"fcardUrlFront\":null,\"fcardUrlBack\":null,\"forderActiveDiscountAmount\":null,\"ffreightTotal\":0,\"forderTotalAmount\":24000,\"orderActiveDiscountAmount\":null,\"freightTotal\":0,\"orderTotalAmount\":224,\"fisDelete\":null,\"fcreateTime\":null,\"fmodifyTime\":null,\"fregionId\":null,\"freserveNum\":null,\"fminNo\":\"1\",\"fmaxNo\":\"6\",\"fpicFile\":\"M00/00/36/eEwrGVhFLI-AW7-LAAGlCqUZoLU399.jpg\",\"priceList\":[{\"frangeEnd\":1,\"findex\":24033,\"frangeStart\":1,\"fmemberAmount\":\"120.00\"},{\"frangeEnd\":6,\"findex\":24035,\"frangeStart\":2,\"fmemberAmount\":\"112.00\"}],\"fskuIdcare\":0,\"fskuStockNumShow\":42,\"funame\":null,\"fmobile\":null,\"fcreditId\":null,\"fprovince\":null,\"farea\":null,\"fcity\":null,\"maxBuyNum\":6,\"minBuyNum\":1,\"fmerchantName\":null,\"fmerchantOrderId\":null,\"fskuPutaway\":1,\"fskuIsDelete\":0,\"fdeliveryAddrId\":null,\"fdraft\":null}],\"imgIp\":\"http://img1.xyb2b.com/\"}}";// 要加密的字符串
    	String source = "{asdfasd:asdfasdf, asdfasdf:asdfasdfas,sign:nhDjU1qdlZ+WlfpR41qG8+Lh2RsQ7ZwaBX1Bdr174mo027x6bsFUAcJCJ4zGpUtW+z3NawkntORRqqKgQM5SRobPXBzx7K0CdoT8l8qFyNnCyg+ufGLlGdg5YiiHtLgWnQuJSr5Jt9cG+eLR0xuC+6a1ySyvtvq6aMs4EPccLtM=}";
        System.out.println("加密前数据:" + source);
        String encryptStr = encryptByPublicKey(source.getBytes());
        System.out.println("加密后数据:" + encryptStr);
        String decryptStr = decrypt(encryptStr);
        System.out.println("解密密后数据:" + decryptStr);

        
//        System.out.println("准备用公钥加密的字符串为：" + source);  
//          
//        String cryptograph = encrypt(source);// 生成的密文  
//        System.out.print("用公钥加密后的结果为:" + cryptograph);  
//        System.out.println();  
//         
//        String target = decrypt(cryptograph);// 解密密文  
//        System.out.println("用私钥解密后的字符串为：" + target);  
//        System.out.println();     
    }  
      
    /** 
     * 加密方法 
     * @param source 源数据 
     * @return 
     * @throws Exception 
     */  
    public static String encrypt(String source) throws Exception {  
          
        Key publicKey = getKey(PUBLIC_KEY_FILE);  
  
        /** 得到Cipher对象来实现对源数据的RSA加密 */  
        Cipher cipher = Cipher.getInstance(ALGORITHM);  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        byte[] b = source.getBytes();  
        /** 执行加密操作 */  
        byte[] b1 = cipher.doFinal(b);  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(b1);  
    }  
  
    /**
     * 公钥加密 
    * @Title: encryptByPublicKey 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param data
    * @param @return
    * @param @throws Exception  参数说明 
    * @return String    返回类型 
    * @author bond
    * @throws
     */
    public static String encryptByPublicKey(byte[] data)  
            throws Exception {  
    	Key pk = getKey(PUBLIC_KEY_FILE);  
        /** 得到Cipher对象来实现对源数据的RSA加密 */  
        Cipher cipher = Cipher.getInstance(ALGORITHM);  
        cipher.init(Cipher.ENCRYPT_MODE, pk);  
        int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > 117) {  
                cache = cipher.doFinal(data, offSet, 117);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * 117;  
        }  
        byte[] encryptedData = out.toByteArray();
        out.close();  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(encryptedData);  
    }  
    
    /**
     * 私钥解密 
     * @param encryptedData 已加密数据 
     * @param privateKey 私钥(BASE64编码) 
     * @return 
     * @throws Exception 
     */  
    public static String decryptByPrivateKey(byte[] encryptedData)  
            throws Exception {  
    	 Key prikey = getKey(PRIVATE_KEY_FILE);  
    	  
         /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */  
         Cipher cipher = Cipher.getInstance(ALGORITHM);  
         cipher.init(Cipher.DECRYPT_MODE, prikey);  
         BASE64Decoder decoder = new BASE64Decoder();  
        encryptedData = decoder.decodeBuffer(new String(encryptedData));  
        int inputLen = encryptedData.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > 128) {  
                cache = cipher.doFinal(encryptedData, offSet, 128);  
            } else {  
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * 128;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return new String(decryptedData);  
    }  
    
    /** 
     * 解密算法 
     * @param cryptograph    密文 
     * @return 
     * @throws Exception 
     */  
    public static String decrypt(String cryptograph) throws Exception {  
          
        Key privateKey = getKey(PRIVATE_KEY_FILE);  
  
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */  
        Cipher cipher = Cipher.getInstance(ALGORITHM);  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        BASE64Decoder decoder = new BASE64Decoder();  
        byte[] b1 = decoder.decodeBuffer(cryptograph);  
  
        /** 执行解密操作 */  
        byte[] b = cipher.doFinal(b1);  
        return new String(b);  
    }  
      
    private static Key getKey(String fileName) throws Exception, IOException {  
        Key key;  
        ObjectInputStream ois = null;  
        try {  
            /** 将文件中的私钥对象读出 */  
            ois = new ObjectInputStream(new FileInputStream(fileName));  
            key = (Key) ois.readObject();  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            ois.close();  
        }  
        return key;  
    }  

}
