package patterns.strategy;

/**
 * Created by hotjoyit on 2017-07-12.
 */
public class Asset {
  enum AssetType { BOND, STOCK };
  private final AssetType assetType;
  private final int value;

  public Asset(AssetType assetType, int value) {
    this.assetType = assetType;
    this.value = value;
  }

  public AssetType getAssetType() {
    return assetType;
  }

  public int getValue() {
    return value;
  }
}
