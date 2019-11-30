import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import sun.management.counter.Units;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        File[] files = new File[20];
        FileOutputStream[] fileOutputStreams = new FileOutputStream[20];
        for (int i = 0; i < 20; i++) {
            files[i] = new File("redis_" + i + ".txt");
            if (!files[i].exists()) {
                if (!files[i].createNewFile()) {
                    continue;
                }
            }
            fileOutputStreams[i] = new FileOutputStream(files[i]);
        }

        //Jedis jedis = new Jedis("10.144.25.28");
        Jedis jedis = new Jedis("localhost");
        jedis.select(1);

        // 游标初始值为0
        String cursor = ScanParams.SCAN_POINTER_START;
        String key = "*";
        ScanParams scanParams = new ScanParams();
        scanParams.match(key);// 匹配以 test:xttblog:* 为前缀的 key
        scanParams.count(1);

        int index = 0;

        while (true){
            //使用scan命令获取500条数据，使用cursor游标记录位置，下次循环使用
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            cursor = scanResult.getCursor();// 返回0 说明遍历完成
            List<String> list = scanResult.getResult();
            for(int m = 0;m < list.size();m++){
                String mapentry = list.get(m);
                index = index % 20;
                System.out.println(mapentry);
                fileOutputStreams[index].write(mapentry.getBytes());
                fileOutputStreams[index].write("\r\n".getBytes());
                fileOutputStreams[index].flush();
                ++index;
            }
            if ("0".equals(cursor)){
                break;
            }
        }

        for (int i = 0; i < 20; i++) {
            fileOutputStreams[i].flush();
            fileOutputStreams[i].close();
        }
    }
}
