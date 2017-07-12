package patterns.strategy;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hotjoyit on 2017-07-12.
 */
public class AssetUtil {
  public static int totalAssetValues(final List<Asset> assets) {
    return assets.stream()
            .mapToInt(Asset::getValue)
            .sum();
  }

  public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
    return assets.stream()
            // Strategy Pattern 으로 Asset 선택 전략을 동적으로 변경한다
            .filter(assetSelector)
            .mapToInt(Asset::getValue)
            .sum();
  }
}
