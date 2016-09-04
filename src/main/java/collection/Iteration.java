package collection;

import java.util.function.Consumer;

import static collection.Folks.friends;

/**
 * Created by hotjoyit on 16. 9. 4.
 */
public class Iteration {

  public static void main(String[] args) {

    // 명령형 스타일 : 자해하는 패턴 self-inflicted wound pattern
    for (int i = 0; i < friends.size(); i++) {
      System.out.println(friends.get(i));
    }

    // 명령형 스타일 : JAVA8에서는 사용하지 않는게 좋다
    for (String friend : friends) {
      System.out.println(friend);
    }

    // 위 두 스타일은 요구하지 말고 설명해봐(Tell, don't ask) 원칙을 만족시키지 못한다

    // Iterable interface는 JAVA8에서 forEach() 메소드를 제공
    // 각 엘리먼트를 어떻게 이터레이션 하는지에 대해서 생각할 필요 없이
    // 각 엘리먼트에서 해야 할 작업에 초점을 맞출 수 있다
    // 즉 코드가 서술적(Declarative)이다
    friends.stream().forEach(new Consumer<String>() {
      public void accept(final String name) {
        System.out.println(name);
      }
    });

    // Anonymous Class를 람다 표현식으로 표현
    friends.stream().forEach((final String name) -> System.out.println(name));

    // JAVA 컴파일러의 타입추론을 활용하여 괄호와 타입을 생략가능
    // final이 생략되어서 파라미터가 람다 표현식 내부에서 수정되지 않도록 주의해야 함
    friends.stream().forEach(name -> System.out.println(name));

    // 메소드 레퍼런스 사용
    friends.stream().forEach(System.out::println);

    /**
     * 완벽은 더 추가할 것이 없을 때가 아니라
     * 더 뺄 것이 없을 때 이루어 진다
     * - 생텍쥐페리 -
     */
  }

}
