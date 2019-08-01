package com.example.restcrud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.*;

//@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class SpringbootRestcrudApplicationTests {


//	@Autowired
//	DataSource dataSource;
//
//	@Test
//	public void contextLoads() throws SQLException {
//		System.out.println(dataSource.getClass());
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
//	}

    /**
     * StringUtils.trimAllWhitespace(String str)  去掉str 的所有空格
     * StringUtils.commaDelimitedListToStringArray(String str) 将逗号分隔的str转化为到StringArray数组
     * StringUtils.collectionToCommaDelimitedString(Collection<?> coll)  将逗号分隔的集合转换为逗号分隔的字符串
     */
    @Test
    public void test02(){
        String basename = "  me s sa ge ,messa ge1,messag e2";
        String trimAllWhitespace = StringUtils.trimAllWhitespace(basename);
        System.out.println(trimAllWhitespace);
        String[] strings = StringUtils.commaDelimitedListToStringArray(trimAllWhitespace);
        for (String string : strings) {
            System.out.println(string);
        }
        String collectionToCommaDelimitedString = StringUtils.collectionToCommaDelimitedString(Arrays.asList(strings));
        System.out.println(collectionToCommaDelimitedString);
    }

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void logTest() {
        //System.out.println();
        //日志的级别；
        //由低到高 trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别

        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");

        log.debug("这是lombok的debug日志...");
        log.info("这是lombok的info日志...");
        log.warn("这是lombok的warn日志...");
        log.error("这是lombok的error日志...");
    }

    /**
     *       /* 是拦截所有的文件夹，不包含子文件夹
     *       /** 是拦截所有的文件夹及里面的子文件夹
     */
    @Test
    public void System_arraycopy() {
        String[] SERVLET_RESOURCE_LOCATIONS = {"/"};

        String[] CLASSPATH_RESOURCE_LOCATIONS = {
                "classpath:/META-INF/resources/", "classpath:/resources/",
                "classpath:/static/", "classpath:/public/"};

        String[] RESOURCE_LOCATIONS;

        {
            RESOURCE_LOCATIONS = new String[CLASSPATH_RESOURCE_LOCATIONS.length
                    + SERVLET_RESOURCE_LOCATIONS.length];
            log.info("RESOURCE_LOCATIONS======" + RESOURCE_LOCATIONS);
            // System.arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);用法： 复制数组
            System.arraycopy(SERVLET_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS, 0,
                    SERVLET_RESOURCE_LOCATIONS.length);

            log.info("RESOURCE_LOCATIONS======" + RESOURCE_LOCATIONS);

            System.arraycopy(CLASSPATH_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS,
                    SERVLET_RESOURCE_LOCATIONS.length, CLASSPATH_RESOURCE_LOCATIONS.length);

            log.info("RESOURCE_LOCATIONS======" + RESOURCE_LOCATIONS);
        }

    }

    /**
     *   Collections.singletonMap()  创建一个只有一个key=value对元素的map,再次添加元素会报 java.lang.UnsupportedOperationException
     *   Collections.unmodifiableList() 创建一个无法更改的List，再次添加元素会报 java.lang.UnsupportedOperationException
     */
    @Test
    public void singletonMap() {
        Map<String, String> map = Collections.singletonMap("key1", "value1");
        System.out.println(map);
//        map.put("key2","value2");//如果再次添加就会报异常： java.lang.UnsupportedOperationException

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        List<Object> list = Collections.unmodifiableList(arrayList);
        System.out.println(list);
//        list.add("3");//如果再次添加就会报异常： java.lang.UnsupportedOperationException
    }




}
