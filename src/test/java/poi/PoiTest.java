package poi;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import system.controller.comm.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：POI测试
 */
public class PoiTest {


    public static void main(String[] args) throws Exception {
//        List<String> list = testGetFiles("E:\\poi");
//        testPoi();


//        Date date1 = new Date();
        testPoi();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println(sdf.parse("2016-10-1 12:11"));
    }

    /**
     * 描述：获取Excel 文件列表地址
     *
     * @param fileName 文件夹地址
     * @return
     * @throws Exception
     */
    private static List<String> testGetFiles(String fileName) throws Exception {
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        for (String str : file.list()) {
            list.add(StringUtils.assemblyString(fileName, "\\", str));
        }
        return list;
    }


    private static void testPoi() throws Exception {
        //1.创建poi对象
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("E:\\poi\\技术中心10月考勤.xls"));
        //2.得到工作簿对象
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //3.得到Excel工作表对象
        HSSFSheet sheet = wb.getSheetAt(0);
        //4.创建Map保存参数
        Map<String, Object> map = new HashMap<>();
        //5.初始化 map
        initMap(map);
        //6.获取总行数
        int rowCount = sheet.getLastRowNum();
        //7.循环设置值
        for (int i = 0; i < rowCount; i++) {
            HSSFRow row = sheet.getRow(i);
            HSSFCell cell = row.getCell(0);
            String name = cell.getStringCellValue();
            if (map.keySet().contains(name)) {
                String date = row.getCell(1).getStringCellValue();
                String startTime = row.getCell(2).getStringCellValue();
                String endTime = row.getCell(3).getStringCellValue();
                if (!endTime.equals("晚补")&&!startTime.equals("晚补")&&!startTime.equals(null) && !endTime .equals(null)  && !startTime .equals("")&& !endTime .equals("") ) {
                    System.out.println(date +":"+startTime + "---"+endTime);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    long l = sdf.parse(StringUtils.assemblyString(date, " ", endTime)).getTime() - sdf.parse(StringUtils.assemblyString(date, " ", startTime)).getTime();
                    map.put(name, l+ (long)map.get(name));
                }

            }
        }

        mapToString(map);
    }


    /**
     * 描述：初始化map
     *
     * @param map map
     * @return
     * @throws Exception
     */
    private static Map<String, Object> initMap(Map<String, Object> map) throws Exception {
        map.put("黎力豪", 0l);
        map.put("余顺伟", 0l);
        map.put("王晓", 0l);
        map.put("丁小红", 0l);
        return map;
    }

    /**
     * 描述:输出map
     *
     * @param map
     * @throws Exception
     */
    private static void mapToString(Map<String, Object> map) throws Exception {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("名称：" + entry.getKey() + "时间:" + entry.getValue());
        }
    }
}

