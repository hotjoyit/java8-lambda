package patterns.delegate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculateNAVTest {

  @Test
  public void 주식가치평가() {
    final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
    assertThat(calculateNAV.computeStockWorth("SAMSUNG", 100), is(new BigDecimal("601.00")));
  }

  @Test
  public void Mock테스트() {
    final CalculateNAV calculateNAV = new CalculateNAV(MockFinance::getPrice);
    assertThat(calculateNAV.computeStockWorth("ZUM", 100), is(new BigDecimal("12300.00")));
  }

  @Test(expected = RuntimeException.class)
  public void 시세조회중_RuntimeException_테스트() {
    final CalculateNAV calculateNAV = new CalculateNAV(MockFinance::getPriceExceptionOccured);
    calculateNAV.computeStockWorth("ZUM", 100);
  }


  public static class MockFinance {
    public static BigDecimal getPrice(final String ticker) {
      return new BigDecimal("123.00");
    }

    public static BigDecimal getPriceExceptionOccured(final String ticker) {
      throw new RuntimeException("Socket Connection Timeout");
    }
  }

}
