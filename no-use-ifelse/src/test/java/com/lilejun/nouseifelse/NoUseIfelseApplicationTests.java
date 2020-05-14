package com.lilejun.nouseifelse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lilejun.nouseifelse.entity.GlobalMenu;
import com.lilejun.nouseifelse.entity.SiteMenu;
import com.lilejun.nouseifelse.entity.Student;
import com.lilejun.nouseifelse.entity.User;
import com.lilejun.nouseifelse.enums.BankMoneyRateEnum;
import com.lilejun.nouseifelse.service.OpBankRateService;
import com.lilejun.nouseifelse.service.impl.BankMoneyRateOpFactory;
import com.lilejun.nouseifelse.service.impl.CacluteSvipImpl;
import com.lilejun.nouseifelse.service.impl.CaculateMoney;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest
class NoUseIfelseApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OpBankRateService opBankRateService;

    @Test
    public void testOpRate() {
        System.out.println("=====枚举模式计算本息======");
        Double money = 100d;
        Double rateICBC = opBankRateService.opRateByBankEnum(BankMoneyRateEnum.ICBC_BANK.name(), money);
        System.out.println("ICBC工商银行本息应还：" + rateICBC);
        Double rateABC = opBankRateService.opRateByBankEnum(BankMoneyRateEnum.ABC_BANK.name(), money);
        System.out.println("ABC农业银行本息应还：" + rateABC);
        Double rateCCB = opBankRateService.opRateByBankEnum(BankMoneyRateEnum.CCB.name(), money);
        System.out.println("CCB建设银行本息应还：" + rateCCB);
    }

    @Test
    public void testRateByFactory() {
        System.out.println("=====工厂模式计算本息======");
        Double money = 100d;
        Double rateICBC = BankMoneyRateOpFactory.getByName(BankMoneyRateEnum.ICBC_BANK.name()).opRateByBankEnum(money);
        System.out.println("ICBC工商银行本息应还：" + rateICBC);
        Double rateABC = BankMoneyRateOpFactory.getByName(BankMoneyRateEnum.ABC_BANK.name()).opRateByBankEnum(money);
        System.out.println("ABC农业银行本息应还：" + rateABC);
        Double rateCCB = BankMoneyRateOpFactory.getByName(BankMoneyRateEnum.CCB.name()).opRateByBankEnum(money);
        System.out.println("CCB建设银行本息应还：" + rateCCB);
    }

    @Autowired
    private CaculateMoney caculateMoney;

    @Test
    public void testStrategy(){
        //测试策略模式计算不同用户应付金额
        double money = caculateMoney.cacluteMoneyByUserType("svip", 100);
        System.out.println("当前计算的金额是："+money);
    }


    @Test
    public void testStrcontains() {
        GlobalMenu globalMenu = new GlobalMenu();
        globalMenu.setName("王五");
        globalMenu.setLink("12");
        GlobalMenu globalMenu1 = new GlobalMenu();
        globalMenu1.setName("zhaoliu");
        globalMenu1.setLink("");
        GlobalMenu globalMenu2 = new GlobalMenu();
        globalMenu2.setName("李四");
        globalMenu2.setLink("abc");
        GlobalMenu globalMenu3 = new GlobalMenu();
        globalMenu3.setName("李四");
        List<GlobalMenu> globalMenuList = new ArrayList<>();
        globalMenuList.add(globalMenu);
        globalMenuList.add(globalMenu1);
        globalMenuList.add(globalMenu2);
        globalMenuList.add(globalMenu3);

        Iterator<GlobalMenu> it = globalMenuList.iterator();
        while (it.hasNext()) {
            GlobalMenu menu = it.next();
            if (StringUtils.isBlank(menu.getLink())) {
                menu.setLink("");
            }
            String link = menu.getLink();
            if (StringUtils.isBlank(link) || isNotContainNumber(link)) {
                //filter为空或者不包含数字直接删除当前Neighborhoods
                it.remove();
            }
        }
        System.out.println(JSON.toJSON(globalMenuList));
    }

    public boolean isNotContainNumber(String company) {
        if (StringUtils.isBlank(company)) {
            return true;
        }
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(company);
        if (m.find()) {
            return false;
        }
        return true;
    }

    @Test
    public void testPattern() {
        String a = "3";
        boolean bool = isNotContainNumber(a);
        System.out.println(bool);
    }

    public List<User> initUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", "男", 24, "武汉大 学",26.464309367526013));
        userList.add(new User("张三", "男", 24, "武汉大学",26.409664498874932));
        userList.add(new User("李四", "男", 25, "武汉大学",26.544789459894012));
        userList.add(new User("赵六", "男", 20, "武汉大学",26.44533135641237));
        userList.add(new User("王丽", "女", 24, "武汉大学",24.879002722223063));
        userList.add(new User("李雪", "女", 22, "华中科技大学",22.93708299837208));
        userList.add(new User("刘红", "女", 26, "华中科技大学",21.89874293747005));
        userList.add(new User("孙宇", "男", 20, "长江大学",20.629371054321425));
        userList.add(new User("曹雨", "女", 21, "长江大学",20.452960548761833));
        return userList;
    }

    @Test
    public void testStream() {
        List<User> userList = initUserList();
        //filter过滤出所有武汉大学的用户
        List<User> wuhanUserList = userList.stream().filter(user -> "武汉大学".equals(user.getSchool()))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(wuhanUserList));

        //distinct对象去重:必须重写hashcode和equals方法
        List<User> distinctUserList = userList.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSON(distinctUserList));

        //limit:返回筛选结果的前几条
        List<User> limitUserList = userList.stream().filter(user -> "武汉大学".equals(user.getSchool()))
                .distinct()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(limitUserList));

        //sorted排序
        List<User> sortedUserList = userList.stream().filter(user -> user.getAge() > 21).distinct()
                .sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(sortedUserList));
        //map操作:获取所有年龄大于22岁的用户的姓名
        List<String> mapUserList = userList.stream().filter(user -> user.getAge() > 22)
                .distinct().map(user -> user.getName() + user.getAge())
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(mapUserList));

        //判断操作
        //allMatch：检查集合中是否全部元素满足某个条件
        //检查是否集合中用户的年龄全部超过21岁
        boolean boolAllMatch = userList.stream().allMatch(user -> user.getAge() > 21);
        System.out.println(boolAllMatch);

        //anyMatch：检查集合中存在某条件的元素
        //检查是否有长江大学的用户
        boolean boolAnyMatch = userList.stream().anyMatch(user -> "长江大学".equals(user.getSchool()));
        System.out.println(boolAnyMatch);

        //noneMathch：检查是否不存在某种元素
        boolean boolNoneMathch = userList.stream().noneMatch(user -> "湖北大学".equals(user.getSchool()));
        System.out.println(boolNoneMathch);

        //findFirst：返回过滤结果的第一个元素
        Optional<User> firstOptional = userList.stream().filter(user -> user.getAge() > 22).distinct().
                sorted((s2, s1) -> s1.getAge() - s2.getAge())
                .findFirst();
        System.out.println(JSON.toJSON(firstOptional.get()));

        //findAny：返回任意一个
        Optional<User> anyOptional = userList.stream().filter(user -> user.getAge() > 22).distinct()
                .findAny();
        System.out.println(JSON.toJSON(anyOptional.get()));

        //归约操作
        //分别求年龄最大和最小的
        Optional<User> ageMaxUser = userList.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        Optional<User> ageMinUser = userList.stream().collect(Collectors.minBy((s1, s2) -> s1.getAge() - s2.getAge()));
        System.out.println("年龄最大的是：" + JSON.toJSON(ageMaxUser.get()));
        System.out.println("年龄最小的是：" + JSON.toJSON(ageMinUser.get()));

        //年龄总和
        int userSum = userList.stream().collect(Collectors.summingInt(user -> user.getAge()));
        System.out.println("年龄总和是：" + userSum);

        //属性拼接，就是类似字符串拼接
        //名称按照逗号拼接
        String nameJoin = userList.stream().map(user -> user.getName()).collect(Collectors.joining(","));
        System.out.println("逗号拼接后的字符串：" + nameJoin);

        //分组
        Map<String, List<User>> groupBySchool = userList.stream()
                .collect(Collectors.groupingBy(user -> user.getSchool().replaceAll(" +", "")));
        System.out.println("根据学校分组后的结果：" + JSON.toJSON(groupBySchool));
    }

    public List<Student> initStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "高一", 93));
        studentList.add(new Student(2, "李四", "高三", 94));
        studentList.add(new Student(5, "李四2", "高三", 94));
        studentList.add(new Student(3, "王五", "高一", 90));
        studentList.add(new Student(4, "赵六", "高二", 92));
        return studentList;
    }

    @Test
    public void testComparable() {
        List<Student> studentList = initStudent();
        Collections.sort(studentList);
        System.out.println(JSON.toJSON(studentList));
    }

    @Test
    public void foreachMap(){
        Map<String,User> map = new HashMap<>();
        map.put("1",new User("张三", "男", 24, "武汉大学",1.22));
        map.put("2",new User("张四", "男", 24, "武汉大学",2.33));
        for (Map.Entry<String,User> entry:map.entrySet()){
            String key = entry.getKey();
            User user = entry.getValue();
            System.out.println("键key="+key+",值value="+JSON.toJSON(user));
        }
    }

    @Test
    public void testFormatter(){
        String a ="2800.0";
        Formatter formatter = new Formatter();
        Formatter f = formatter.format("$%,d",a);
        System.out.println("格式化之后的值：="+f.toString());
    }

    @Test
    public void sortByScore(){
        List<User> userList = initUserList();
        List<User> sortedUserList = userList.stream()
                .sorted((s1, s2) -> s2.getScore().compareTo(s1.getScore()))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(sortedUserList));
    }
    @Test
    public void subStringStr(){
        String a = "htaatp://www.baidu.com";
        System.out.println(a.contains("https"));
        a=a.replace("http","https");
        System.out.println(a);
        List<User> userList = initUserList();
        for (User user:userList) {
            user.setName("123456");
        }
        System.out.println(JSON.toJSON(userList));
    }

    //测试一下提交
}
