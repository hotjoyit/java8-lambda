package patterns.builder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FluentMailerTest {

  @Test
  public void 메일_작성_테스트() {
    String mail = FluentMailer.send(fluentMailer -> fluentMailer
          .from("me")
          .to("you")
          .subject("Hello")
          .body("Sincerely")
    );

    assertThat(mail.contains("me"), is(true));
    assertThat(mail.contains("you"), is(true));
    assertThat(mail.contains("Hello"), is(true));
    assertThat(mail.contains("Sincerely"), is(true));
  }
}
