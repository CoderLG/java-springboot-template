package lg.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://zhuanlan.zhihu.com/p/88745085


@RestController("调用c动态库")
@Slf4j
public class Jna {
    private static final String JNA_LIBRARY_PATH = "jna.library.path";

    public interface CLibrary extends Library {
        CLibrary INSTTANCE = (CLibrary) Native.loadLibrary("Dll3" , CLibrary.class);

        int Add(int a,int b);
        int Sub(int a,int b);
    }

    public interface OsgbCLibrary extends Library {
        OsgbCLibrary INSTTANCE = (OsgbCLibrary) Native.loadLibrary("buildOsgbIndex" , OsgbCLibrary.class);
        int buildOsgbIndex(String dataPath, String configFile, String output);
    }


    /**
     * 直接访问resources中的
     */
    @GetMapping("seyHello")
     public void  seyHello(){
         int sum = CLibrary.INSTTANCE.Add(3, 6);
         int sub = CLibrary.INSTTANCE.Sub(3, 2);
         log.info("sum = " + sum);
         log.info("sub = " + sub);
     }

    /**
     * 多依赖直接引用
     *
     */
    public static void main(String[] args) {
//        int sum = CLibrary.INSTTANCE.Add(3, 6);
//        int sub = CLibrary.INSTTANCE.Sub(3, 2);
//        log.info("sum = " + sum);
//        log.info("sub = " + sub);

        System.setProperty(JNA_LIBRARY_PATH, "C:\\Users\\imlg\\Desktop\\dll-lib");
        System.setProperty("jna.debug_load", "true");
        String jnaPath = System.getProperty(JNA_LIBRARY_PATH);
        System.err.println("jna.library.path:" + jnaPath);

        String dataDir="C:\\burning\\geovis-data\\osgb";
        String configFileName = "C:\\burning\\geovis-data\\osgb\\config.txt";
        String output = "output.osg";
        int sub = OsgbCLibrary.INSTTANCE.buildOsgbIndex(dataDir, configFileName,output);
        System.out.println(sub);
    }

}
