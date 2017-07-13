package patterns.decorate;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
  private Function<Color, Color> filter;

  public Camera() {
    setFilters();
  }

  public void setFilters(final Function<Color, Color>... filters) {
    filter = Stream.of(filters)
        //.reduce((filter, next) -> filter.compose(next))
        .reduce(Function::compose) // Function 을 체이닝 하는 방법
        .orElse(color -> color);

  }
  public Color capture(final Color inputColor) {
    final Color processedColor = filter.apply(inputColor); // 몇개의 function을 통과할지 모른다
    return processedColor;
  }

}
