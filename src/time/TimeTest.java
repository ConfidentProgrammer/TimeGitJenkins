package time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;


import javax.swing.*;

public class TimeTest {
  @Test
  public void testGetTotalSeconds() {
      String time = "10:10:10";
      int h = Time.getTotalHours(time);
      int s = Time.getSeconds(time);
      int m = Time.getTotalMinutes(time);

      Assertions.assertEquals(36610, Time.getTotalSeconds(time));
  }
  @Test
  @DisplayName("Perfect Working method for minutes")
  public void testGetTotalMinutes() {
    Assertions.assertEquals(11, Time.getTotalMinutes("11111111"));
  }

  @Test
  @DisplayName("When time.length is more than 8")
  public void testGetTotalMinutesMoreThanEight() {
    Assertions.assertThrows(NumberFormatException.class, () -> {
      Time.getTotalMinutes("33:0e:eee");
    });
  }

  @Test
  public void testGetSeconds() {
    Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
      Time.getSeconds("112e");
    });
    Assertions.assertEquals( 11, Time.getSeconds("11:11:11"));
  }
  @Test
  public void testGetTotalHours() {
    Assertions.assertEquals( 11, Time.getTotalHours("11:11:11"));

  }

  //Testing boundaries test
  @Test
  public void testGetSecondsBoundaries() {
  Assertions.assertTrue( Time.getSeconds("11:11:59") == 59);
  }
  @Test
  public void testGetMinutesBoundaries() {
    Assertions.assertTrue( Time.getSeconds("11:59:59") == 59);
  }
  @Test
  public void AllBoundariesMinutesHours() {
    int h = Time.getTotalHours("23:59:59");
    int m = Time.getSeconds("23:59:59");
    int s = Time.getTotalMinutes("23:59:59");
    Assertions.assertTrue((h == 23) && (s == 59) && (m == 59));
  }

}

