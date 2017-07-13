package patterns.decorate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.function.Consumer;

import org.junit.Test;

public class CameraTest {

  @Test
  public void NoFilter_테스트() {
    Camera camera = new Camera();
    final Consumer<String> printCaptured =
        (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

    printCaptured.accept("no filter");

    assertThat(camera.capture(new Color(200, 100, 200)), is(new Color(200, 100, 200)));
  }

  @Test
  public void BrighterFilter_테스트() {
    Camera camera = new Camera();
    camera.setFilters(Color::brighter);
    final Consumer<String> printCaptured =
        (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

    printCaptured.accept("brighter filter");
  }

  @Test
  public void DarkerFilter_테스트() {
    Camera camera = new Camera();
    camera.setFilters(Color::darker);
    final Consumer<String> printCaptured =
        (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

    printCaptured.accept("darker filter");
  }

  @Test
  public void BrightDarkerChainFilter_테스트() {
    Camera camera = new Camera();
    camera.setFilters(Color::brighter, Color::darker);
    final Consumer<String> printCaptured =
        (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

    printCaptured.accept("chain filter");
  }
}
