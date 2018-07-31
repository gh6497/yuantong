package cn.sprivacy.yuantong;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author cailun
 * @date 2018年 07月30日
 */
public class NormalTest {
    @Test
    public void testDatetoLong() {
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDate.now().toEpochDay());

    }
}
