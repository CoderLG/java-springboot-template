package lg.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * author: LG
 * date: 2019-09-25 15:27
 * desc:
 */
@Slf4j
public class OshiControllerTest {



    @Test
    public void addCache() {
        System.out.println("start");
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        System.out.println(os);
        log.info("检查 CPU...");
        CentralProcessor processor = hal.getProcessor();
        double[] loadAverage = processor.getSystemLoadAverage(3);
        System.out.println(loadAverage);
        System.out.println(loadAverage.clone().toString());

        System.out.println(loadAverage[1]);
        System.out.println(loadAverage[2]);
    }

    @Test
    public void t (){

        String extList = "sdf";
        String[] split = extList.split(";");
        String resStr = "";
        for (String s : split) {
            resStr = resStr + "." + s + ",";

        }
        System.out.println(resStr.substring(0,resStr.length()-1));


    }

    @Test
    public void testFormat(){
        String str = "{\"code\":\"00000\",\"message\":\"成功\",\"datetime\":1594691700,\"data\":{\"fileName\":\"world_rivers.zip\",\"children\":[{\"id\":1,\"createTime\":\"2020-07-14 09:50:26\",\"updateTime\":\"2020-07-14 09:50:26\",\"itemName\":\"world_rivers.shp\",\"itemSize\":1794000,\"displayId\":-100,\"dataType\":\"vectorZip\",\"dataNote\":null,\"parseInfo\":{\"geo\":\"POLYGON ((-164.90347246002037 75.79348379113986, 177.5203567006342 75.79348379113986, 177.5203567006342 -52.157728773964294, -164.90347246002037 -52.157728773964294, -164.90347246002037 75.79348379113986))\",\"maxX\":177.5203567006342,\"maxY\":75.79348379113986,\"minX\":-164.90347246002037,\"minY\":-52.157728773964294,\"gridSet\":\"EPSG:4326\",\"shpType\":\"MultiLineString\",\"charCode\":\"UTF-8\",\"dataType\":\"vectorZip\",\"fileName\":\"world_rivers.shp\",\"dataLabel\":\"other\",\"dataScale\":\"\",\"dataFormat\":\"ZIP\",\"dataType_ch\":\"矢量\",\"dataEntityId\":5,\"iconFileName\":\"1fb-836b-f5bff62f2a86_largeThumb.png\",\"dataSubType_ch\":\"原始数据\",\"fileRelativePath\":\"world_rivers.shp\",\"iconRelativePath\":\"/parseData/2020/7/14/7//1fb-836b-f5bff62f2a86_largeThumb.png\",\"thumbnailFileName\":\"1fb-836b-f5bff62f2a86_smallThumb.png\",\"thumbnailRelativePath\":\"/parseData/2020/7/14/7//1fb-836b-f5bff62f2a86_smallThumb.png\"},\"dfsPath\":\"/home/iCenter/data/user-data/lxzh_yanzheng/07_vector_zip/world_rivers.zip\",\"dfsRealPath\":\"/GEOVIS/iCenter//data/user-data/lxzh_yanzheng/07_vector_zip/world_rivers.zip\",\"imageGsdMin\":null,\"imageGsdMax\":null,\"uploadFileInfo\":{\"id\":5,\"createTime\":\"2020-07-14 09:50:22\",\"updateTime\":\"2020-07-14 09:50:22\",\"dfsPath\":\"/home/iCenter/data/user-data/lxzh_yanzheng/07_vector_zip/world_rivers.zip\",\"dfsRealPath\":\"/GEOVIS/iCenter//data/user-data/lxzh_yanzheng/07_vector_zip/world_rivers.zip\",\"fileSize\":1794000,\"typeIdentify\":\"vectorZip\",\"md5Num\":\"32cc57834866f771e20991021a6a4cc7\",\"displayId\":-100},\"shootingTime\":\"2020-07-14 09:50:26\",\"storageTime\":\"2020-07-14 09:50:26\",\"userId\":\"0\",\"tag\":null,\"scale\":\"vectorScaleother\"}],\"filePath\":\"/home/iCenter/data/user-data/lxzh_yanzheng/07_vector_zip/world_rivers.zip\",\"dataEntityId\":7,\"status\":2}}";

        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject obj = jsonObject.getJSONObject("data");
        JSONObject children = obj.getJSONArray("children").getJSONObject(0);

        System.out.println(children.getString("id"));

    }

}