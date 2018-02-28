package pers.springcloud.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.springcloud.common.ReturnDTO;
import pers.springcloud.user.entity.User;
import pers.springcloud.user.service.IUserService;
import pers.springcloud.user.service.impl.UserServiceImpl;
import pers.springcloud.utils.JsonUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * 用户服务的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
    /**
     * 姓氏
     */
    private static String[] first = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "公孙", "慕容", "郁", "虞", "高", "刘", "轩辕", "令狐", "单于", "皇甫", "闻人", "夏侯", "诸葛", "端木"};
    /**
     * 名字第一位
     */
    private static String[] second = {"彦", "浩", "章", "子", "法", "晨", "奕", "玉", "昕", "洋", "恒", "思", "海", "雨", "鸿", "玉"};
    /**
     * 名字第二位
     */
    private static String[] thired = {"龙", "鹏", "洪", "晨", "敏", "熙", "东", "南", "西", "北", "中", "杰", "嘉", "祖", "艺"};
    /**
     * 邮箱后缀
     */
    private static String[] mailSuffix = {"@qq.com", "@139.com", "@126.com", "@gmail.com", "@yahoo.com", "@msn.com", "@hotmail.com", "@163.com", "@263.com", "@sina.com", "@sohu.com"};
    /**
     * 模拟邮箱长度
     */
    private String[] emailParams = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    /**
     * 格式化日期
     */
    private static SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
    /**
     * 格式化时间
     */
    private static SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");

    @Autowired
    private IUserService userService;

    public void testQueryUserById() {

    }

    /**
     * 准备数据
     */
    @Test
    public void dataInit() {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= 2000; i++) {
            User user = new User();
            user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setUserName(getName());
            user.setBirthday(getBirthday());
            user.setGender(getGender());
            user.setCreateDate(getDate());
            user.setCreateTime(getTime());
            user.setSalary(getSalary());
            user.setBonus(getBonus());
            users.add(user);
            System.out.println(JsonUtils.object2JsonString(user));
        }
        System.out.println("=========================================================");
        ReturnDTO dto = userService.addUsers(users);
        System.out.println(JsonUtils.object2JsonString(dto));
    }

    /**
     * 模拟工资
     *
     * @return
     */
    private String getSalary() {
        String price = null;
        Random ran = new Random();
        int result = ran.nextInt(14500) + 350;
        BigDecimal b = new BigDecimal(result).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        price = b.toString();
        return price;
    }

    /**
     * 模拟奖金
     *
     * @return
     */
    private String getBonus() {
        String bonus = null;
        Random ran = new Random();
        int bo = ran.nextInt(785) + 1500;
        BigDecimal a = new BigDecimal(bo).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        bonus = a.toString();
        return bonus;
    }

    /**
     * 模拟当前日期   yyyyMMdd
     */
    private String getDate() {
        String date = formatDate.format(new Date());
        return date;
    }

    /**
     * 模拟获取当前时间   HHddmm
     *
     * @return
     */
    private String getTime() {
        String time = formatTime.format(new Date());
        return time;
    }

    /**
     * 模拟用户性别
     *
     * @return
     */
    private String getGender() {
        Random ran = new Random();
        int sex = ran.nextInt(20);
        String gender = "女";
        if (sex % 2 == 0) {
            gender = "男";
        }
        return gender;
    }

    /**
     * 模拟用户名字
     *
     * @return
     */
    private String getName() {
        String name = null;
        Random ran = new Random();
        StringBuffer sb = new StringBuffer(first[ran.nextInt(first.length - 1)]);
        int num = ran.nextInt(2) % 2;
        if (num == 0) {
            sb.append(second[ran.nextInt(second.length - 1)]);
        } else {
            sb.append(second[ran.nextInt(second.length - 1)]).append(thired[ran.nextInt(thired.length - 1)]);
        }
        name = sb.toString();
        return name;
    }

    /**
     * 模拟出生日期
     *
     * @return
     */
    private String getBirthday() {
        String birthday = null;
        Random ran = new Random();
        List<String> years = getYears();
        List<String> months = getMonths();
        String year = years.get(ran.nextInt(years.size() - 1) + 1);
        String month = months.get(ran.nextInt(months.size() - 1) + 1);
        int maxDaysByMonth = getMonthLastDay(Integer.parseInt(year), Integer.parseInt(month));
        List<String> days = getDays(maxDaysByMonth);
        String day = days.get(ran.nextInt(days.size() - 1) + 1);
        StringBuffer sb = new StringBuffer();
        sb.append(year).append(month).append(day);
        birthday = sb.toString();
        return birthday;
    }

    /**
     * 模拟年份列表
     *
     * @return
     */
    private List<String> getYears() {
        List<String> years = new ArrayList<String>();
        for (int i = 1970; i < 2001; i++) {
            String year = String.valueOf(i);
            years.add(year);
        }
        return years;
    }

    /**
     * 模拟月份列表
     *
     * @return
     */
    private List<String> getMonths() {
        List<String> months = new ArrayList<String>();
        for (int i = 1; i < 13; i++) {
            String month = null;
            if (i < 10) {
                month = "0" + i;
            } else {
                month = String.valueOf(i);
            }
            months.add(month);
        }
        return months;
    }

    /**
     * 模拟天数列表
     *
     * @param max
     * @return
     */
    private List<String> getDays(int max) {
        List<String> days = new ArrayList<String>();
        for (int i = 1; i <= max; i++) {
            String day = null;
            if (i < 10) {
                day = "0" + i;
            } else {
                day = String.valueOf(i);
            }
            days.add(day);
        }
        return days;
    }

    /**
     * 获取置顶年月的最大天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
}
