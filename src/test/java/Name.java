import com.gateway.service.SqlService;
import com.gateway.utils.ConnectionPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Name {
    @Autowired
    SqlService sqlService;

    @Test
    public void testStream() {
        System.out.println(Arrays.asList(1, 3, 5, 7).stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
    }

    @Test
    public void getConnection() throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.addDataBase(
                Datasource.builder()
                        .id(1)
                        .port(1521)
                        .ipAddress("127.0.0.1")
                        .username("sys as sysdba")
                        .password("Oracle2020")
                        .dbName("oracle")
                        .type("Oracle")
                        .build());
        System.out.println(connectionPool.getDataSource(1).getConnection());
        connectionPool.removeDataSource(1);
    }

    @Test
    public void tmpGen(){
        System.out.println("随机温度生成器");
        for(int i = 0;i<100;i++){
            System.out.println(((358+(int)(Math.random()*7))/10.0)+"\t"+((358+(int)(Math.random()*7))/10.0));
        }
    }

    @Test
    public void testList(){
        List<String> cols = new ArrayList<>();
        cols.add("姓名");
        cols.add("年龄");
        List<String> params = new ArrayList<>();
        params.add("zzz");
        params.add("xxx");
        params=params.stream().map(x->"\""+x+"\"").collect(Collectors.toList());

        System.out.println("select "+ cols.toString().substring(1, cols.toString().length() - 1) +" from "+"table");
        System.out.println("insert into user ("+ cols.toString().substring(1, cols.toString().length() - 1) +
                ") values ("+params.toString().substring(1,params.toString().length()-1)+")");
    }

    @Test
    void stringToList(){
        List<String> cols = new ArrayList<>();

//        cols.add("id");
//        cols.add("user_name");
        String s = cols.toString();
        System.out.println(s);
        System.out.println(Arrays.asList(s.substring(1, s.length() - 1).split(", ")));

    }
}
