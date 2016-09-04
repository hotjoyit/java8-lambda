package collection;

import java.util.ArrayList;
import java.util.List;

import static collection.Folks.friends;

/**
 * Created by hotjoyit on 16. 9. 4.
 */
public class Transform {

  public static void main(String[] args) {
    {
      // 명령형 스타일
      final List<String> upperCaseNames = new ArrayList<>();
      for (String name : friends) {
        upperCaseNames.add(name.toUpperCase());
      }
    }

    {
      // 함수형 스타일
      final List<String> upperCaseNames = new ArrayList<>();
      friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
    }

    {
      // Stream 인터페이스의 map() 메소드 사용하면 가변성이 발생하지 않도록 할 수 있다
      // map() 메소드는 입력 컬렉션을 출력 컬렉션으로 매핑하거나 변경하는데 유용하다
      // 컬렉션에 있는 각 엘리먼트의 내용에 대한 처리를 하며,
      // 람다 표현식의 실행 결과를 취합하여 결과 컬렉션으로 리턴한다
      // 비어 있는 컬렉션의 초기화 작업이나 가비지 변수가 필요하지 않다
      friends.stream()
          .map(name -> name.toUpperCase())
          .forEach(name -> System.out.print(name + " "));
    }

    {
      // 메서드 레퍼런스로 간결화
      friends.stream()
          .map(String::toUpperCase)
          .forEach(name -> System.out.print(name + " "));
    }
  }
}
