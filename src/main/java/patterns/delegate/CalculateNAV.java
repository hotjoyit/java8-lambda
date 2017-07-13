package patterns.delegate;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * 책임을 다른 클래스에 위임하기보다는 그 부분을 람다 표현식과 메서드 레퍼런스로 위임하는 것이 더 좋다.
 * 이러한 방법은 클래스의 개수가 늘어나는 것을 막아준다.
 *
 * NAV(Net Asset Value) : 순자산가치 평가 클래스
 */
public class CalculateNAV {

  private Function<String, BigDecimal> priceFinder;

  /**
   * DI를 통해 구현 부분을 추가하기보다는 문제를 분리하고 각 문제를 추상화한다.
   * 이를 통해 코드를 확장할 수 있고,
   * 클래스의 코드 길이를 줄일 수 있으며,
   * 짧은 시간내 테스트가 가능하다.
   * @param priceFinder
   */
  public CalculateNAV(Function<String, BigDecimal> priceFinder) {
    this.priceFinder = priceFinder;
  }

  /**
   * @param ticker 주식시세표
   * @param shares 주식량
   * @return 평가금액
   */
  public BigDecimal computeStockWorth(final String ticker, final int shares) {
    return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
  }
}
