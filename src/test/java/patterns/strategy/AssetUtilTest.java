package patterns.strategy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by hotjoyit on 2017-07-12.
 */
public class AssetUtilTest {

  final List<Asset> assets = Arrays.asList(
          new Asset(Asset.AssetType.BOND, 1000),
          new Asset(Asset.AssetType.BOND, 2000),
          new Asset(Asset.AssetType.BOND, 3000),
          new Asset(Asset.AssetType.STOCK, 600),
          new Asset(Asset.AssetType.STOCK, 400)
  );

  @Test
  public void 자산_총합_테스트() {
    assertThat(AssetUtil.totalAssetValues(assets), is(7000));
  }


  @Test
  public void 주식자산_총합_테스트() {
    assertThat(AssetUtil.totalAssetValues(assets,
            asset -> asset.getAssetType() == Asset.AssetType.STOCK), is(1000));
  }

  @Test
  public void 채권자산_총합_테스트() {
    assertThat(AssetUtil.totalAssetValues(assets,
            asset -> asset.getAssetType() == Asset.AssetType.BOND), is(6000));
  }

  @Test
  public void 자산_총합_테스트2() {
    assertThat(AssetUtil.totalAssetValues(assets,
            asset -> true), is(7000));
  }
}
