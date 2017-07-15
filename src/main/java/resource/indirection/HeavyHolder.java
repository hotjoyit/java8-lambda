package resource.indirection;

import java.util.function.Supplier;

/**
 * Created by hotjoyit on 2017-07-15.
 */
public class HeavyHolder {
  private Supplier<Heavy> heavySupplier = () -> createAndCacheHeavy();

  public HeavyHolder() {
    System.out.println("Holder created");
  }

  public Heavy getHeavy() {
    return heavySupplier.get();
  }

  // 임계영역은 HeavyHolder가 처음 생성되었을 때만 동작
  private synchronized Heavy createAndCacheHeavy() {
    class HeavyFactory implements Supplier<Heavy> {
      private final Heavy heavyInstance = new Heavy();

      @Override
      public Heavy get() {
        return heavyInstance;
      }
    }

    // syncronized 블록 내부에서 supplier를 교체해버림
    // heavyInstance가 null인지 확인할 필요 없이 깔끔하게 싱글톤 패턴을 구현
    if (!HeavyFactory.class.isInstance(heavySupplier)) {
      heavySupplier = new HeavyFactory();
    }
    return heavySupplier.get();
  }

  public static void main(String[] args) {
    HeavyHolder holder = new HeavyHolder();
    Heavy heavy = holder.getHeavy();
    Heavy heavyCached = holder.getHeavy();
  }
}
